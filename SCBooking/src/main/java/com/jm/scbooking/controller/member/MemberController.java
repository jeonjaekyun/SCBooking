package com.jm.scbooking.controller.member;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jm.scbooking.model.member.dto.MemberDTO;
import com.jm.scbooking.service.member.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	MemberService memberService;
	
	@RequestMapping("/login")
	public String Login() {
		return "/member/login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String LoginPost(@ModelAttribute MemberDTO dto,Model model, HttpSession session) {
		String name = memberService.loginCheck(dto.getUserid(), dto.getPasswd());	
		logger.info(name);
		if(name==null) {
			model.addAttribute("msg","아이디 또는 비밀번호를 확인하세요");
			return "/member/login";
		}else {
			logger.info("userid/name:"+dto.getUserid()+"/"+dto.getName());
			session.setAttribute("userid", dto.getUserid());
			session.setAttribute("name", name);
			return "redirect:/main/booking";
		}
	}
	
	@RequestMapping("/logout")
	public String Logout(HttpSession session) {
		session.invalidate();
		return "redirect:/member/login";
	}
	
	@RequestMapping("/register")
	public String register() {
		return "/member/register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerPost(@ModelAttribute MemberDTO dto) {
		logger.info("dto : "+dto);
		memberService.memberRegister(dto);
		return "redirect:/member/login";
	}
	
	@RequestMapping("/duplicateCheck")
	public String duplicateCheck(@ModelAttribute MemberDTO dto, Model model) {
		
		model.addAttribute("dto", dto);
		
		if(memberService.duplicateCheck(dto.getUserid())==1) {
			model.addAttribute("msg", "중복된 아이디");
		}else {
			model.addAttribute("msg", "사용가능합니다.");
		}
		
		return "/member/register";
	}
	
}
