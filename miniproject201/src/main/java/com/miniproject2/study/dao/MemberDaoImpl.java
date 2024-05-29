package com.miniproject2.study.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miniproject2.study.domain.Member;

@Repository
public class MemberDaoImpl implements MemberDao{
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	//정의한 Mapper namespce를 상수로 정의
	private final String NAME_SPACE =  "com.miniproject2.mapper.MemberMapper";
	
	
	
	//회원 정보를 회원 테이블에 저장하는 메서드
	@Override
	public void addMember(Member member) {
		sqlSession.insert(NAME_SPACE+ ".addMember", member);
	}
	//memberlist테이블에서 memberId에 해당하는 회원 정보를 읽어오는 메서드 반환하는 메서드
	@Override
	public Member getMember(String memberId) {
		// 디버깅을 위해 매개변수 출력
		return sqlSession.selectOne(NAME_SPACE + ".getMember", memberId);
	}
	


}
