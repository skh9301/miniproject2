package com.miniproject2.study.domain;

public class Member {
	String memberId;
	String memberPass;
	String memberNice;
	String memberAddress;
	int memberPoint;
	String memberPhone;
	String memberEmail;
	
	public Member(){}
	
	

	public Member(String memberId, String memberPass, String memberNice, String memberAddress, int memberPoint,
			String memberPhone, String memberEmail) {
		super();
		this.memberId = memberId;
		this.memberPass = memberPass;
		this.memberNice = memberNice;
		this.memberAddress = memberAddress;
		this.memberPoint = memberPoint;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
	}



	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPass() {
		return memberPass;
	}

	public void setMemberPass(String memberPass) {
		this.memberPass = memberPass;
	}

	public String getMemberNice() {
		return memberNice;
	}

	public void setMemberNice(String memberNice) {
		this.memberNice = memberNice;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public int getMemberPoint() {
		return memberPoint;
	}

	public void setMemberPoint(int memberPoint) {
		this.memberPoint = memberPoint;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	
	
}
