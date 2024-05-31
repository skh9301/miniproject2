package com.miniproject2.study.domain;

public class Member {
	String memberId;
	String memberPass;
	String memberNick;
	String memberZipcode;
	String memberAddress;
	String memberAddress2;
	int memberPoint;
	String memberPhone;
	String memberEmail;
	
	public Member(){}

	public Member(String memberId, String memberPass, String memberNick, String memberZipcode, String memberAddress,
			String memberAddress2, int memberPoint, String memberPhone, String memberEmail) {
		super();
		this.memberId = memberId;
		this.memberPass = memberPass;
		this.memberNick = memberNick;
		this.memberZipcode = memberZipcode;
		this.memberAddress = memberAddress;
		this.memberAddress2 = memberAddress2;
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

	public String getMemberNick() {
		return memberNick;
	}

	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}

	public String getMemberZipcode() {
		return memberZipcode;
	}

	public void setMemberZipcode(String memberzipcode) {
		this.memberZipcode = memberzipcode;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public String getMemberAddress2() {
		return memberAddress2;
	}

	public void setMemberAddress2(String memberAddress2) {
		this.memberAddress2 = memberAddress2;
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
