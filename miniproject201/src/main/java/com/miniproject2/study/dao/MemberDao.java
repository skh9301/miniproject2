package com.miniproject2.study.dao;

import com.miniproject2.study.domain.Member;

public interface MemberDao {
	
	//회원 정보를 회원테이블에서 수정하는 메서드
	public void deleteMember(Member member);
	
	//회원 정보 수정 시에 기존 비밀번호가 맞는지 체크하는 메서드
	public String memberPassCheck(String memberId, String memberPass);
	
	//회원 정보를 회원 테이블에서 수정하는 메서드
	public void updateMember(Member member);
	
	//회원 정보를 회원 테이블에 저장하는 메서드
	public void addMember(Member member);

	//한 명의 회원 정보를 반환하는 메서드
	public Member getMember(String memberId);
	
	public void deDuctionPoint(Member member) ;
	

}
