package com.miniproject2.study.service;

import com.miniproject2.study.domain.Member;

public interface MemberService {
	
	//회원정보를 DAO를 이용해 회원테이블에서 삭제하는 메서드
	public void deleteMember(Member member);
	
	//회원 정보 수정시에 기존 비밀번호가 맞는지 체크하는 메서드
	public boolean memberPassCheck(String memberId, String memberPass);
	
	//회원 정보를 DAO를 이용해 회원테이블에서 수정하는 메서드
	public void updateMember(Member member);
	
	//회원가입시 DAO를 이용해 아이디 중복을 체크하는 메서드
	public boolean idCheck(String memberId);
	
	//회원 정보를 DAO를 이용해 회원 테이블에 저장하는 메서드
	public void addMember(Member member);
	
	// 회원 로그인을 처리하는 메서드
	public int login(String memberId, String memberPass);
	
	//한명의 회원정보를 반환하는 메서드
	public Member getMember(String memberId);
	
	//옥션 종료후 포인트 차감
	public void deDuctionPoint(Member member);
}
