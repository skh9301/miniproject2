package com.miniproject2.study.service;

import com.miniproject2.study.domain.Member;

public interface MemberService {
	
	// 회원 가입시 DAO를 이용해 아이디 중복을 체크하는 메서드
	public boolean overlapIdCheck(String memberId);
	
	//회원 정보를 DAO를 이용해 회원 테이블에 저장하는 메서드
	public void addMember(Member member);
	
	// 회원 로그인을 처리하는 메서드
	public int login(String memberId, String memberPass);
	
	//한명의 회원정보를 반환하는 메서드
	public Member getMember(String memberId);
}
