package com.itda.ITDA.controller;

import java.security.Principal;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
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

import com.itda.ITDA.domain.MailVO;
import com.itda.ITDA.domain.Member;
import com.itda.ITDA.service.MemberService;

//DAO와 Service가 작성되어야 Controller가 완성된다
@Controller
@RequestMapping(value = "/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	private MemberService memberService;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public MemberController(MemberService memberService, PasswordEncoder passwordEncoder) {
		this.memberService = memberService;
		this.passwordEncoder = passwordEncoder;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView login(ModelAndView mv, @CookieValue(value="saveid", required=false) Cookie readCookie,
			HttpSession session, Principal userPrincipal) {
		
		if (readCookie != null) {
			logger.info("저장된 아이디 : " + userPrincipal.getName());			//로그인한 아이디값을 로그에 찍어봄
			mv.setViewName("redirect:/main/protomain");
		}else {
			mv.setViewName("/main/protomain");
			mv.addObject("loginfail", session.getAttribute("loginfail"));	//loginfail을 mv에 저장해주고
			session.removeAttribute("loginfail");							//세션값은 삭제한다
		}
		
		return mv;
	}
	
	@ResponseBody	//@ResponseBody : 각 메소드의 실행 결과를 JSON으로 변환하여 HTTP Response Body에 설정된다
	@RequestMapping(value="/idcheck", method=RequestMethod.GET)
	public int idcheck(@RequestParam("userId") String userId) {
		return memberService.isId(userId);
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "member/joinForm";
	}
	
	@RequestMapping(value="/joinProcess", method=RequestMethod.POST)
	public String insert(Member mem, RedirectAttributes ra, Model model, HttpServletRequest request) {
		String encPassword = passwordEncoder.encode(mem.getUserPw());
		logger.info(encPassword);
		mem.setUserPw(encPassword);
		
		int result = memberService.insert(mem);
		
		if (result == 1) {
			ra.addFlashAttribute("result", "joinSuccess");
			return "redirect:/main/protomain";
		}else {
			model.addAttribute("url", request.getRequestURI());
			model.addAttribute("message", "회원 가입 실패");
			return "/main/protomain";
		}
		
	}
}
