package com.miniproject2.study.dao;

import com.miniproject2.study.domain.Member;

public interface MemberDao {
	
	//회원 정보를 회원 테이블에 저장하는 메서드
	public void addMember(Member member);

	//한 명의 회원 정보를 반환하는 메서드
	public Member getMember(String memberId);
}
