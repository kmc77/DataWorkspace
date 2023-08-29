package com.naver.myhome4.controller;

import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.naver.myhome4.domain.Board;
import com.naver.myhome4.service.BoardService;
import com.naver.myhome4.service.CommentService;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

   private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

   private BoardService boardService;

   private CommentService commentService;

   @Autowired
   public BoardController(BoardService boardService, CommentService commentService) {
      this.boardService = boardService;
      this.commentService = commentService;
   }

   @RequestMapping(value = "/list", method = RequestMethod.GET)
   public ModelAndView boardlist(@RequestParam(value = "page", defaultValue = "1", required = false) int page,
         ModelAndView mv) {

      int limit = 10; // 한 화면에 출력할 로우 갯수

      int listcount = boardService.getListCount(); // 총 리스트 수를 받아옴

      // 총 페이지 수
      int maxpage = (listcount + limit - 1) / limit;

      // 현재 페이지에 보여줄 시작 페이지 수 (1, 11, 21 등...)
      int startpage = ((page - 1) / 10) * 10 + 1;

      // 현재 페이지에 보여줄 마지막 페이지 수 (10, 20, 30 등...)
      int endpage = startpage + 10 - 1;

      if (endpage > maxpage)
         endpage = maxpage;

      // 리스트를 받아옴
      List<Board> boardlist = boardService.getBoardList(page, limit);

      mv.setViewName("board/board_list");
      mv.addObject("page", page);
      mv.addObject("maxpage", maxpage);
      mv.addObject("startpage", startpage);
      mv.addObject("endpage", endpage);
      mv.addObject("listcount", listcount);
      mv.addObject("boardlist", boardlist);
      mv.addObject("limit", limit);

      return mv;
   }

   // 글쓰기
   @GetMapping(value = "/write") // board/write
   // @RequestMapping(value = "/write", method = RequestMethod.GET)
   public String board_write() {
      return "board/board_write";
   }

   @PostMapping(value = "/add")
   // @RequestMapping(value = "/add", method = RequestMethod.POST)
   public String add(Board board, HttpServletRequest request) throws Exception {

      MultipartFile uploadfile = board.getUploadfile();

      if (!uploadfile.isEmpty()) {
         String fileName = uploadfile.getOriginalFilename();// 원래 파일명
         board.setBOARD_ORIGINAL(fileName);// 원래 파일명 저장

         String saveFolder = request.getSession().getServletContext().getRealPath("resources/upload");
         String fileDBName = fileDBName(fileName, saveFolder);
         logger.info("fileDBName = " + fileDBName);

         // transferTo(File path): 업로드한 파일을 매개변수의 경로에 저장합니다.
         uploadfile.transferTo(new File(saveFolder + fileDBName));
         logger.info("transferTo path = " + saveFolder + fileDBName);
         // 바뀐 파일명으로 저장
         board.setBOARD_FILE(fileDBName);
      }

      boardService.insertBoard(board);// 저장메서드 호출
      logger.info(board.toString());// selectKey로 정의한 BOARD_NUM 값 확인해 봅니다.
      return "redirect:list";
   }

   private String fileDBName(String fileName, String saveFolder) {
      // 새로운 폴더 이름 : 오늘 년 + 월 + 일
      Calendar c = Calendar.getInstance();
      int year = c.get(Calendar.YEAR);// 오늘 년도 구합니다.
      int month = c.get(Calendar.MONTH) + 1;// 오늘 월 구합니다.
      int date = c.get(Calendar.DATE);// 오늘 일 구합니다.

      String homedir = saveFolder + "/" + year + "-" + month + "-" + date;
      logger.info(homedir);
      File path1 = new File(homedir);
      if (!(path1.exists())) {
         path1.mkdir();// 새로운 폴더를 생성
      }

      // 난수를 구합니다.
      Random r = new Random();
      int random = r.nextInt(100000000);

      /**** 확장자 구하기 시작 ****/
      int index = fileName.lastIndexOf(".");
      // 문자열에서 특정 문자열의 위치 값(index)를 반환합니다.
      // indexOf가 처음 발견되는 문자열에 대한 index를 반환하는 반면,
      // lastIndexOf는 마지막으로 발견되는 문자열의 index를 반환합니다.
      // (파일명에 점에 여러개 있을 경우 맨 마지막에 발견되는 문자열의 위치를 리턴합니다.
      logger.info("index = " + index);

      String fileExtension = fileName.substring(index + 1);
      logger.info("fileExtension = " + fileExtension);

      // 새로운 파일명
      String refileName = "bbs" + year + month + date + random + "." + fileExtension;
      logger.info("refileName = " + refileName);

      // 오라클 디비에 저장될 파일 명
      // String fileDBName = "/" + year + "-" + month + "-" + date + "/" + refileName;
      String fileDBName = File.separator + year + "-" + month + "-" + date + File.separator + refileName;
      logger.info("fileDBName = " + fileDBName);

      return fileDBName;
   }

}