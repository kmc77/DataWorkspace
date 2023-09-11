package com.naver.myhome.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.naver.myhome.domain.MailVO;
import com.naver.myhome.domain.Member;
import com.naver.myhome.service.MemberService;
import com.naver.myhome.task.SendMail;
/*
@Component를 이용해서 스프링 컨테이너가 해당 클래스 객체를 생성하도록 설정할 수 있지만
모든 클래스에 @Component를 할당하면 어떤 클래스가 어떤 역할을 수행하는지 파악하기 어렵습니다.
스프링 프레임워크에서는 이런 클래스들을 분류하기 위해서
@Component를 상속하여 다음과 같은 세 개의 애노테이션을 제공합니다.

1. @Controller - 사용자의 요청을 제어하는 Controller 클래스
2. @Repository - 데이터 베이스 연동을 처리하는 DAO클래스
3. @Service - 비즈니스 로직을 처리하는 Service 클래스
 
*/


//이 컨트롤러는 회원 가입시 비밀번호 암호화와 로그인 처리 후 메일 전송하는 컨트롤러 입니다.


@Controller
@RequestMapping(value = "/member") // http://localhost:8088/myhome/member/로 시작하는 주소 매핑
public class MemberController2 {
   // import org.slf4j.Logger;
   // import org.slf4j.LoggerFactory;

   private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

   private MemberService memberservice;
   private PasswordEncoder passwordEncoder;
   private SendMail sendMail;

   @Autowired
   public MemberController2(MemberService memberservice, PasswordEncoder passwordEncoder, SendMail sendMail ) {
      this.memberservice = memberservice;
      this.passwordEncoder = passwordEncoder;
      this.sendMail =sendMail;
   }

   /*
    * @CookieValue(value="saveid", required=false) Cookie readCookie 이름이 saveid인
    * 쿠키를 Cookie 타입으로 전달받습니다. 지정한 이름의 쿠키가 존재하지 않을 수도 있기 때문에 required=false로 설정해야
    * 합니다. 즉 id 기억하기를 선택하지 않을 수도 있기 때문에 required=false로 설정해야 합니다. required=true
    * 상태에서 지정한 이름을 가진 쿠키가 존재하지 않으면 스프링 MVC는 익셉션을 발생시킵니다.
    */

   // http://localhost:8088/myhome4/login
   // 로그인 폼이동
   @RequestMapping(value = "/login", method = RequestMethod.GET)
      public ModelAndView login(ModelAndView mv, 
                          @CookieValue(value = "remember-me", required = false) Cookie readCookie,
                          HttpSession session,
                          Principal userPrincipal
                          ) {
         if (readCookie != null) {
            logger.info("저장된 아이디 :" + userPrincipal.getName());//principal.getName() : 로그인한 아이디 값을 알 수 있어요
            mv.setViewName("redirect:/board/list");
         }else {
            mv.setViewName("member/member_loginForm");
            mv.addObject("loginfail", session.getAttribute("loginfail"));//세션에 저장된 값을 한 번만 실행될 수 있도록 mv에 저장합니다
            session.removeAttribute("loginfail");//세션의 값은 제거합니다.
         }
         return mv;
      }
   
   
   
   // http://localhost:8088/myhome4/member/join
   // 회원가입 폼 이동
   @RequestMapping(value = "/join", method = RequestMethod.GET)
   public String join() {
      return "member/member_joinForm";// WEB-IF/views/member/member_joinForm.jsp
   }

   
   
   
   
   
   // 회원가입폼에서 아이디 검사
   @ResponseBody // @ResponseBody를 이용해서 각 메서드의 실행 결과는 JSON으로 변환되어
               // HTTP Response BODY에 설정됩니다.
   @RequestMapping(value = "/idcheck", method = RequestMethod.GET)
   public int idcheck(@RequestParam("id") String id) {
      return memberservice.isId(id);// WEB-IF/views/member/member_joinForm.jsp
   }

   // 회원가입 처리
   @RequestMapping(value = "/joinProcess", method = RequestMethod.POST)
   public String joinProcess(Member member,
         RedirectAttributes rattr, 
         Model model, 
         HttpServletRequest request,
         MailVO vo) {

      //비밀번호 암호화 추가
            String encPassword = passwordEncoder.encode(member.getPassword());
            logger.info(encPassword);
            member.setPassword(encPassword);
      
      // MemberService를 사용하여 회원을 데이터베이스에 추가합니다.
      int result = memberservice.insert(member);
      // result=0;
      /*
       * 스프링에서 제공하는 RedirectAttributes는 기존의 Servlet에서 사용되던 response.sendRedirect()를
       * 사용할 때와 동일한 용도로 사용합니다. 리다이렉트로 전송하면 파라미터를 전달하고자 할 때 addAttribute()나
       * addFlashAttribute()를 사용합니다. 예) response.sendRedirect("/test?result=1"); =>
       * rattr.addAttribute("result",1);
       */
      // 삽입이 된 경우
      // 회원 가입 결과에 따라 리다이렉트할 페이지를 결정합니다.
      if (result == 1) {
         vo.setTo(member.getEmail());
         vo.setContent(member.getId() + "님 회원 가입을 축하드립니다.");
         sendMail.sendMail(vo);
         
         
         rattr.addFlashAttribute("result", "joinSuccess");
         return "redirect:login"; // 로그인 페이지로 이동
      } else {
         model.addAttribute("url", request.getRequestURL());
         model.addAttribute("message", "회원가입 실패");
         return "error/error"; // 회원 가입 폼 페이지로 이동
      }
   }

   // 로그인 처리
   @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
   public String loginProcess(@RequestParam("id") String id, @RequestParam("password") String password,
         @RequestParam(value = "remember", defaultValue = "", required = false) String remember,
         HttpServletResponse response, HttpSession session, RedirectAttributes rattr) {

      int result = memberservice.isId(id, password);
      logger.info("결과 :" + result);

      if (result == 1) {
         // 로그인 성공
         session.setAttribute("id", id);
         Cookie savecookie = new Cookie("saveid", id);
         if (!remember.equals("")) {
            savecookie.setMaxAge(60 * 60);
            logger.info("쿠키저장 : 60*60");
         } else {
            logger.info("쿠키저장 : 0 ");
            savecookie.setMaxAge(0);
         }
         response.addCookie(savecookie);

         return "redirect:/board/list";
      } else {
         rattr.addFlashAttribute("result", result);
         return "redirect:login"; // http://localhost:8088/myhome4/member/login
      }
   }

   /*
    * 회원정보 수정폼1.(HttpSession 이용)
    * 
    * @RequestMapping(value = "/update", method = RequestMethod.GET) public
    * ModelAndView member_update(HttpSession session, ModelAndView mv) {
    * 
    * String id = (String) session.getAttribute("id");
    * 
    * 
    * if(id == null) { mv.setViewName("redirect:login"); logger.info("id is null");
    * }else { Member m = memberservice.member_info(id);
    * mv.setViewName("member/member_updateForm"); mv.addObject("memberinfo", m); }
    * return mv; }
    */

   // 회원 정보 수정폼2
      @RequestMapping(value = "/update", method = RequestMethod.GET)
      public ModelAndView member_update(Principal principal, ModelAndView mv) {
            String id = principal.getName();
          
         if (id == null) {
            mv.setViewName("redirect:login");
            logger.info("id is null");
         } else {
            Member m = memberservice.member_info(id);
            mv.setViewName("member/member_update");
            mv.addObject("memberinfo", m);
         }
         return mv;
      }


   // 수정처리
   @RequestMapping(value = "/updateProcess", method = RequestMethod.POST)
   public String updateProcess(Member member, Model model, HttpServletRequest request, RedirectAttributes rattr) {

      int result = memberservice.update(member);
      if (result == 1) {
         rattr.addFlashAttribute("result", "updateSuccess");
         return "redirect:/board/list";
      } else {
         model.addAttribute("url", request.getRequestURL());
         model.addAttribute("message", "정보 수정 실패");
         return "error/error";

      }

   }
   /*
    * 1.header.jsp에서 이동하는 경우 href="${pageContext.request.contextPath}/member/list"
    * 
    * 2. member_list.jsp에서 이동하는 경우 <a href
    * ="list?page=2&search_field=-1&search word=" class="page-lick">2</a>
    * 
    */

   @RequestMapping(value = "/list")
   public ModelAndView memberList(@RequestParam(value = "page", defaultValue = "1", required = false) int page,
         @RequestParam(value = "limit", defaultValue = "3", required = false) int limit, ModelAndView mv,
         @RequestParam(value = "search_field", defaultValue = "1", required = false) int index,
         @RequestParam(value = "search_word", defaultValue = "", required = false) String search_word) {

      int listcount = memberservice.getSearchListCount(index, search_word);
      List<Member> list = memberservice.getSearchList(index, search_word, page, limit);

      // 총 페이지 수
      int maxpage = (listcount + limit - 1) / limit;

      // 현재 페이지에 보여줄 시작 페이지 수 (1, 11, 21 등...)
      int startpage = ((page - 1) / 10) * 10 + 1;

      // 현재 페이지에 보여줄 마지막 페이지 수 (10, 20, 30 등...)
      int endpage = startpage + 10 - 1;

      if (endpage > maxpage)
         endpage = maxpage;

      mv.setViewName("member/member_list");
      mv.addObject("page", page);
      mv.addObject("maxpage", maxpage);
      mv.addObject("startpage", startpage);
      mv.addObject("endpage", endpage);
      mv.addObject("listcount", listcount);
      mv.addObject("memberlist", list);
      mv.addObject("search_field", index);
      mv.addObject("search_word", search_word);
      return mv;

   }

   @RequestMapping(value = "/info", method = RequestMethod.GET)
   public ModelAndView member_info(@RequestParam("id") 
                           String id,
                           ModelAndView mv,
                           HttpServletRequest request) {
        
      Member m = memberservice.member_info(id);
      //m=null;//오류 확인하는 값
      if (m!= null) {
         mv.setViewName("member/member_info");
         mv.addObject("memberinfo", m);
      } else {
         mv.addObject("url", request.getRequestURL());
         mv.addObject("message","해당 정보가 없습니다.");
         mv.setViewName("error/error");
         
      }
      return mv;
   }

   
   @RequestMapping(value= "/delete", method = RequestMethod.GET)
      public String member_delete(String id ) {
         
        memberservice.delete(id);
         return "redirect:list";
      }
   
   
   //로그아웃
   @RequestMapping(value ="/logout", method = RequestMethod.GET)
   public String loginout(HttpSession session){
      session.invalidate();
      return "redirect:login";
   }
}