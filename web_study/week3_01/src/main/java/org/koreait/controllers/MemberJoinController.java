package org.koreait.controllers;

import javax.validation.Valid;

import org.koreait.models.member.MemberJoinService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/join")
public class MemberJoinController {
	
	private MemberJoinValidator validator;
	private MemberJoinService service;
	
	public MemberJoinController(MemberJoinValidator validator, MemberJoinService service) {
		this.validator = validator;
		this.service = service;
	}
	
	@GetMapping
	public String join(Model model) {
		MemberJoin memberJoin = new MemberJoin();
		model.addAttribute("memberJoin", memberJoin);
			
		return "member/join";
	}
	
	@PostMapping
	public String joinPs(@Valid MemberJoin member, Errors errors) {
		
		validator.validate(member, errors);
		
		if (errors.hasErrors()) {
			return "member/join";
		}
		
		// 회원 가입 처리
		service.join(member);
		
		return "redirect:/member/login"; // 회원가입 완료 후 로그인 페이지 이동
	}
}
