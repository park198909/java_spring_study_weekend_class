package org.koreait.controllers;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

public class MemberSearch {
	
	//@NotBlank(message="시작날짜를 입력하세요")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate sdate;
	
	//@NotBlank(message="종료날짜를 입력하세요.")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate edate;
	
	public LocalDate getSdate() {
		return sdate;
	}
	
	public void setSdate(LocalDate sdate) {
		this.sdate = sdate;
	}
	
	public LocalDate getEdate() {
		return edate;
	}
	
	public void setEdate(LocalDate edate) {
		this.edate = edate;
	}
	
}
