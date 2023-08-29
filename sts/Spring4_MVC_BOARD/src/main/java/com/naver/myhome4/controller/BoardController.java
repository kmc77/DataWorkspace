package com.naver.myhome4.controller;

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

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	private BoardService boardService;
	
	private CommentService commentService;
	
	@Autowired 
	public BoardController(BoardService boardService, CommentService commentservice) {
		this.boardService=boardService;
		this.commentService=commentService;
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView boardList(
					@RequestParam(value="page", defaultValue="1", required=false) int page,
					ModelAndView mv) {
		int limit = 10; //한 화면에 출력할 로우 갯수
		
		int listcount = boardService.getListCount(); //총 리스트 수를 받아옴
		
		//총 페이지 수
		int maxpage = (listcount + limit - 1 ) / limit;
		
		//현재 페이지에 보여줄 시작 페이지 수(1, 11, 21 등 ...)
		int startpage = ((page - 1) / 10) * 10 + 1;
		
		//현재 페이지에 보여줄 마지막 페이지 수(10, 20, 30 등 ...)
		int endpage = startpage + 10 - 1;
		
		if (endpage > maxpage)
			endpage = maxpage;
		
		List<Board> boardlist = boardService.getBoardList(page, limit); //리스트를 받아옴
		
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
	
	//글쓰기
	@GetMapping(value = "/write") //board/write
	public String board_write() {
		return "board/board_write";
	}
	
	@PostMapping("/add")
	public String add(Board board, HttpServletRequest request)
			throws Exception {
		
		MultipartFile uploadfile = board.getUploadfile();
		
		if(!uploadfile.isEmpty()) {
			String fileName = uploadfile.getOriginalFilename();
			board.setBOARD_ORIGINAL(fileName);
			
			String saveFolder = request.getSession().getServletContext().getRealPath("resources/upload");
			String fileDBName = fileDBName(fileName, saveFolder);
			logger.info("fileDBName = " + fileDBName);
			
			//transferTo(File path) : 업로드한 파일을 매개변수의 경로에 저장합니다.
			
			
		}
	}

}
