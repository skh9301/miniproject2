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
	
	//회원 정보를 DAO를 이용해 회원테이블에서 수정하는 메서드
	@Override
	public void updateMember(Member member) {
		sqlSession.update(NAME_SPACE + ".updateMember", member);
	}
	

	//회원 정보 수정시에 기존 비밀번호가 맞는지 체크하는 메서드
	@Override
	public String memberPassCheck(String memberId, String memberPass) {
		return sqlSession.selectOne(NAME_SPACE + ".memberPassCheck", memberId);
		
	}

	//회원 정보를 DAO를 이용해 회원테이블에서 삭제하는 메서드
	@Override
	public void deleteMember(Member member) {
		sqlSession.delete(NAME_SPACE  + ".deleteMember", member);
	}
	
	@Override
	public void deDuctionPoint(Member member) {
		sqlSession.delete(NAME_SPACE+".deDuctionPoint",member);
	}
		
}
