package com.miniproject2.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.miniproject2.study.dao.MemberDao;
import com.miniproject2.study.domain.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	// MemberDao를 이용해 로그인 요청처리 결과를 반환하는 메서드
	@Override
	public int login(String memberId, String memberPass) {

		Member m = memberDao.getMember(memberId);
		int result = -1;

		// id가 존재하지 않으면
		if (m == null) {
			return result;
		}
		// 로그인 성공
		if (passwordEncoder.matches(memberPass, m.getMemberPass())) {
			result = 1;
		} else { // 비밀번호가 틀리면
			result = 0;
		}
		return result;
	}

	// MemberDao를 이용해 아이디에 해당하는 회원정보를 가져오는 메서
	@Override
	public Member getMember(String memberId) {

		return memberDao.getMember(memberId);
	}


	//회원 정보를 DAO를 이용해 회원 테이블에 저장하는 메서드
	@Override
	public void addMember(Member member) {
		member.setMemberPass(passwordEncoder.encode(member.getMemberPass()));
		memberDao.addMember(member);
	}

	// 회원 가입시 아이디 중복을 체크하는 메서드
	@Override
	public boolean idCheck(String memberId) {
		
		Member member = memberDao.getMember(memberId);
		System.out.println("idCheck - member : "  + member);
		if(member == null) {
			return false;
		}
		return true;
	}

	//회원 정보 수정시에 기존 비밀번호가 맞는지 체크하는 메서드
	@Override
	public boolean memberPassCheck(String memberId, String memberPass) {
		
		String dbPass = memberDao.memberPassCheck(memberId, memberPass);
		boolean result = false;
		
		if(passwordEncoder.matches(memberPass, dbPass)) {
			result = true;
		}
		
		return result;
	}

	//회원 정보를 DAO를 이용해 회원 테이블에서 수정하는 메서드
	@Override
	public void updateMember(Member member) {
		
		member.setMemberPass(passwordEncoder.encode(member.getMemberPass()));
		System.out.println(member.getMemberPass());
		
		memberDao.updateMember(member);
	}

	//회원정보를 DAO를 이용해 회원테이블에서 삭제하는 메서드
	@Override
	public void deleteMember(Member member) {

		memberDao.deleteMember(member);
	}

	@Override
	public void deDuctionPoint(Member member) {
		memberDao.deDuctionPoint(member);
	}
	

}
