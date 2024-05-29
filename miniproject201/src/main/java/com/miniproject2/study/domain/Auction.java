package com.miniproject2.study.domain;

public class Auction {
	String auctionNum;
	String itemNum;
	int regPrice;
	String memberId;
	String memberNick;
	
	public Auction() {}
	
	public Auction(String auctionNum, int regPrice,String memberId,String memberNick,String itemNum) {
		super();
		this.auctionNum = auctionNum;
		this.regPrice = regPrice;
		this.memberId =memberId;
		this.memberNick =memberNick;
		
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
	public String  getMemberNick() {
		return memberNick;
	}
	
	public void setMemberNick(String memberNick ) {
		this.memberNick = memberNick;
	}
	
	public String  getItemNum() {
		return itemNum;
	}
	
	public void setItemNum(String itemNum ) {
		this.itemNum = itemNum;
	}
	
	
}
