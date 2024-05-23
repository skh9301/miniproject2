package com.miniproject2.study.domain;

public class Auction {
	String auctionNum;
	int regPrice;
	String memberId;
	
	public Auction() {}
	
	public Auction(String auctionNum, int regPrice,String memberId) {
		super();
		this.auctionNum = auctionNum;
		this.regPrice = regPrice;
		this.memberId =memberId;
		
	}
	public String getAuctionNum() {
		return auctionNum;
	}
	public void setAuctionNum(String auctionNum) {
		this.auctionNum = auctionNum;
	}
	public int getRegPrice() {
		return regPrice;
	}
	public void setRegPrice(int regPrice) {
		this.regPrice = regPrice;
	}
	public String  getMemberId() {
		return memberId;
	}
	
	public void setMemberId(String memberId  ) {
		this.memberId = memberId;
	}
	
	
}
