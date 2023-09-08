package com.naver.myhome4.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.naver.myhome4.domain.Member;
import com.naver.myhome4.service.MemberService;

/*
 	@Component�� �̿��ؼ� ������ �����̳ʰ� �ش� Ŭ���� ��ü�� �����ϵ��� ������ �� ������
 	��� Ŭ������ @Component�� �Ҵ��ϸ� � Ŭ������ � ������ �����ϴ��� �ľ��ϱ�
 	��ƽ��ϴ�. ������ �����ӿ�ũ������ �̷� Ŭ�������� �з��ϱ� ���ؼ�
 	@Component�� ����Ͽ� ������ ���� �� ���� �ֳ����̼��� �����մϴ�.
 	
    1. @Controller - ������� ��û�� �����ϴ� Controller Ŭ����
    2. @Repository - ������ ���̽� ������ ó���ϴ� DAOŬ����
    3. @Service - ����Ͻ� ������ ó���ϴ� Service Ŭ����
 */

@Controller
@RequestMapping(value="/member")//http://localhost:8088/myhome4/member/�� �����ϴ� �ּ� ����
public class MemberController {
	//import org.slf4j.Logger;
	//import org.slf4j.LoggerFactory;
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	private MemberService memberservice;
	
	@Autowired
	public MemberController(MemberService memberservice) {
		this.memberservice = memberservice;
	}
	
	/*
    @CookieValue(value="saveid", required=false) Cookie readCookie
    �̸��� saveid�� ��Ű�� Cookie Ÿ������ ���޹޽��ϴ�.
    ������ �̸��� ��Ű�� �������� ���� ���� �ֱ� ������ required=false �� �����ؾ� �մϴ�.
    �� id ����ϱ⸦ �������� ���� ���� �ֱ� ������ required=false �� �����ؾ� �մϴ�.
    required=true ���¿��� ������ �̸��� ���� ��Ű�� �������� ������ ������ MVC�� �ͼ����� �߻���ŵ�ϴ�.
    */
	// http://localhost:8088/myhome4/member/login
	// �α��� ���̵�
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(ModelAndView mv, @CookieValue(value="saveid", required=false) Cookie readCookie) {
		if(readCookie != null) {
			mv.addObject("saveid",readCookie.getValue());
			logger.info("cookie time=" + readCookie.getMaxAge());
		}
			mv.setViewName("member/member_loginForm");
			return mv;
	}
	
	// http://localhost:8088/myhome4/member/login
	// ȸ������ �� �̵�
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "member/member_joinForm"; //WEB-INF/views/member/member_joinForm.jsp
	}
	
	//ȸ������������ ���̵� �˻�
	@ResponseBody 	// @ResponseBody�� �̿��ؼ� �� �޼����� ���� ����� JSON���� ��ȯ�Ǿ�
					//HTTP Response BODY�� �����˴ϴ�.
	@RequestMapping(value = "/idcheck", method = RequestMethod.GET)
	public int idcheck(@RequestParam("id") String id) {
		return memberservice.isId(id);
	}
	
	@RequestMapping(value = "/joinProcess", method = RequestMethod.POST)
	public String joinProcess(Member member,
								RedirectAttributes rattr,
								Model model,
								HttpServletRequest request) {
		int result = memberservice.insert(member);
		//result = 0;
		/*
		 	���������� �����ϴ� RedirectAttributes�� ������ Servlet���� ���Ǵ�
		 	response.sendRedirect()�� ����� ���� ������ �뵵�� ����մϴ�.
		 	�����̷�Ʈ�� �����ϸ� �Ķ���͸� �����ϰ���  �� �� addAttribute()�� addFlashAttribute()�� ����մϴ�.
		 	��) response.sendRedirect("/test?result=1");
		 		=> rattr.addAttribute("result",1);
		 */
		//������ �� ���
		if (result == 1) {
			rattr.addFlashAttribute("result", "joinSuccess");
			return "redirect:login";
		}else {
			model.addAttribute("url", request.getRequestURL());
			model.addAttribute("message", "ȸ�� ���� ����");
			return "error/error";
		}
	}
	
	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public String loginProcess(
								@RequestParam("id") String id,
								@RequestParam("password") String password,
								@RequestParam(value = "remember", defaultValue="", required=false) String remember,
								HttpServletResponse response,
								HttpSession session,
								RedirectAttributes rattr) {
		
		int result = memberservice.isId(id, password);
		logger.info("��� : " + result);

		if(result == 1) {
			//�α��� ����
			session.setAttribute("id", id);
			Cookie savecookie = new Cookie("saveid",id);
			if(!remember.equals("")) {
				savecookie.setMaxAge(60*60);
				logger.info("��Ű���� : 60*60");
			}else {
				logger.info("��Ű���� : 0");
				savecookie.setMaxAge(0);
			}
				response.addCookie(savecookie);
				return "redirect:/board/list";
			} else {
				rattr.addFlashAttribute("result", result);
				return "redirect:login";
			}
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView member_update(@SessionAttribute(name="id", required=false) String id, ModelAndView mv) {
		if(id == null) {
			mv.setViewName("redirect:login");
			logger.info("id is null");
		}else {
			Member m = memberservice.member_info(id);
			mv.setViewName("member/member_updateForm");
			mv.addObject("memberinfo", m);
		}
		return mv;
	}
	
	@PostMapping("/updateProcess")
	public String updateprocess(Member member, Model model,
					HttpServletRequest request,
					RedirectAttributes rattr) {
		
		int result = memberservice.update(member);
		logger.info("��� : " + result);
		
		if(result == 1) {
			rattr.addFlashAttribute("result", "updateSuccess");
			return "redirect:/board/list";
		}
		model.addAttribute("url", request.getRequestURI());
		model.addAttribute("message", "ȸ������ ���� ����");
		return "error/error";
		
	}
	
	@RequestMapping(value = "/list")
	public ModelAndView memberList(
			@RequestParam(value = "page", defaultValue = "1", required = false) int page,
			@RequestParam(value = "limit", defaultValue = "3", required = false) int limit,
			ModelAndView mv,
			@RequestParam(value = "search_field", defaultValue = "-1", required = false) int index,
			@RequestParam(value = "search_word", defaultValue = "", required = false) String search_word			
			) {
		int listcount = memberservice.getSearchListCount(index, search_word); // �� ����Ʈ ���� �޾ƿ�
		List<Member> list = memberservice.getSearchList(index, search_word, page, limit);
		
		// �� ������ ��
		int maxpage = (listcount + limit - 1) / limit;

	    // ���� �������� ������ ���� ������ �� (1, 11, 21 ��...)
	    int startpage = ((page - 1) / 10) * 10 + 1;

	    // ���� �������� ������ ������ ������ �� (10, 20, 30 ��...)
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
	
	@RequestMapping(value = "/info")
	public ModelAndView member_info(@RequestParam(name="id", required=false) String id, 
			ModelAndView mv,
			HttpServletRequest request) {
		
		Member m = memberservice.member_info(id);
		
		if(m != null) {
			mv.setViewName("member/member_info");
			mv.addObject("memberinfo", m);
		}else {
			mv.addObject("url", request.getRequestURL());
			mv.addObject("message", "ȸ�� ���� ����");
			mv.setViewName("error/error");
		}
		return mv;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String id) {
		memberservice.delete(id);
		return "redirect:list";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String loginout(HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}
	
}
