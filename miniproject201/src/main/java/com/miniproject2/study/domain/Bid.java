package com.miniproject2.study.domain;

public class Bid {
	String fonkyMemberId;
	String fonkyItemNum;
	String bidNum;
	String bidItr;
	
	public Bid() {}
	
	public Bid(String fonkyMemberId, String fonkyItemNum, String bidNum,String bidItr) {
		super();
		this.fonkyMemberId = fonkyMemberId;
		this.fonkyItemNum = fonkyItemNum;
		this.bidNum = bidNum;
		this.bidItr = bidItr;
	}
	public String getFonkyMemberId() {
		return fonkyMemberId;
	}
	public void setFonkyMemberId(String fonkyMemberId) {
		this.fonkyMemberId = fonkyMemberId;
	}
	public String getFonkyItemNum() {
		return fonkyItemNum;
	}
	public void setFonkyItemNum(String fonkyItemNum) {
		this.fonkyItemNum = fonkyItemNum;
	}
	public String getBidNum() {
		return bidNum;
	}
	public void setBidNum(String bidNum) {
		this.bidNum = bidNum;
	}
	
	public String getBidItr() {
		return bidItr;
	}
	public void setBidItr(String bidItr) {
		this.bidItr = bidItr;
	}
	
	
}
