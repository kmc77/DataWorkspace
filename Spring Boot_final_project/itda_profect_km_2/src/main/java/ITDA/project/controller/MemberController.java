package ITDA.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ITDA.project.domain.Member;
import ITDA.project.service.MemberService;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	private MemberService memberservice;
	
	@Autowired
	public MemberController(MemberService memberservice) {
		this.memberservice = memberservice;
	}
	
	@GetMapping(value="/join.me")
	public String join() {
		return "member/joinForm";
	}
	
	
	
	@PostMapping(value="/joinProcess.me")
	public String joinProcess(
								Member member,
								RedirectAttributes rattr,
								Model model,
								HttpServletRequest request) {
		
		logger.info("get parameter " + member.getUserId());

		int result = memberservice.insert(member);
		
		logger.info("결과 : " + result);
		
		
		if(result == 1) {
			rattr.addFlashAttribute("result", "joinSuccess");
			return "redirect:/itda/main";
		}else {
			model.addAttribute("url", request.getRequestURI());
			model.addAttribute("message", "회원 가입 실패");
			return "error/error";
		}
	}
	
	@ResponseBody
	@GetMapping(value="/idcheck.chl")
	public int idCheck(@RequestParam("id") String id) {
		return memberservice.idCheck(id);
	}
	
	
	@PostMapping(value="/loginProcess.me")
	public String loginProcess(
								@RequestParam("userId") String id,
								@RequestParam("userPw") String password,
								HttpServletResponse response,
								HttpSession session,
								RedirectAttributes rattr) {
		
		int result = memberservice.idCheck(id, password);
		logger.info("결과 : " + result);
		logger.info("get parameter : " + id + " " + password);
		if(result == 1) {
			session.setAttribute("id", id);
			return "redirect:/itda/main";
		}else {
			rattr.addFlashAttribute("result", result);
			return "redirect:/itda/main";
		}
		
	}
	
	
	
	

}