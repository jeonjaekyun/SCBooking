package com.jm.scbooking.model.qa.dto;

import java.util.Date;

public class QaDTO {
	private int bno;
	private String title;
	private String writer;
	private String context;
	private String register_date;
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getRegister_date() {
		return register_date;
	}
	public void setRegister_date(String register_date) {
		this.register_date = register_date;
	}
	@Override
	public String toString() {
		return "QaDTO [bno=" + bno + ", title=" + title + ", writer=" + writer + ", context=" + context
				+ ", register_date=" + register_date + "]";
	}
	
}
