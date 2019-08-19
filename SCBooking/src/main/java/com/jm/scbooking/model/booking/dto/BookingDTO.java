package com.jm.scbooking.model.booking.dto;

public class BookingDTO {
	private String userid;
	private String roomNum;
	private int byear;
	private int bmonth;
	private int bday;
	private int bstart;
	private int bend;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	public int getByear() {
		return byear;
	}
	public void setByear(int byear) {
		this.byear = byear;
	}
	public int getBmonth() {
		return bmonth;
	}
	public void setBmonth(int bmonth) {
		this.bmonth = bmonth;
	}
	public int getBday() {
		return bday;
	}
	public void setBday(int bday) {
		this.bday = bday;
	}
	public int getBstart() {
		return bstart;
	}
	public void setBstart(int bstart) {
		this.bstart = bstart;
	}
	public int getBend() {
		return bend;
	}
	public void setBend(int bend) {
		this.bend = bend;
	}
	@Override
	public String toString() {
		return "BookingDTO [userid=" + userid + ", roomNum=" + roomNum + ", byear=" + byear + ", bmonth=" + bmonth
				+ ", bday=" + bday + ", bstart=" + bstart + ", bend=" + bend + "]";
	}
	
}
