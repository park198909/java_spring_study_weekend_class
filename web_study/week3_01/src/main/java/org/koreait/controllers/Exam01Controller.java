package org.koreait.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Exam01Controller {
	@GetMapping("/ex01")
	public String ex01(Model model) {
		
		// 컬렉션, 배열 addCss 속성, addScript 
		String[] addCss = { "member/join", "member/common" };
		List<String> addScript = Arrays.asList("member/join", "member/common");
		
		model.addAttribute("addCss", addCss);
		model.addAttribute("addScript", addScript);
		
		model.addAttribute("pageTitle", "페이지 제목!!!");
		
		return "exam/ex01";
	}
}
