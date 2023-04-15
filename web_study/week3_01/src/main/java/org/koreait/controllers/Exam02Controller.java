package org.koreait.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Exam02Controller {
	@Autowired
	private HttpSession session;
	
	@GetMapping("/exam02/ex1")
	public void exam01() {
		session.setAttribute("key1", "세션 값1");
	}
	
	@GetMapping("/exam02/ex2")
	public void exam02() {
		String value = (String)session.getAttribute("key1");
		System.out.printf("value=%s%n", value);
	}
}
