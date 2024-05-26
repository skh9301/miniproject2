package com.miniproject2.study.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.miniproject2.study.domain.Member;
import com.miniproject2.study.service.MemberService;

@Controller
@SessionAttributes("member")
public class MemberController {
	@Autowired
	private MemberService memberService;


	// "/login"으로 들어오는 post방식의 요청을 처리
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(Model model, @RequestParam("userId") String memberId, @RequestParam("pass") String memberPass,
			HttpSession session, HttpServletResponse response) throws ServletException, IOException {
			
		
		int result = memberService.login(memberId, memberPass);
		if(result == -1) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println(" alert('존재하지 않는 아이디 입니다.');");
			out.println(" history.back();");
			out.println("</script>");
			
			return null;
		
		}else if(result == 0) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println(" alert('비밀번호가 다릅니다.');");
			out.println(" history.back();");
			out.println("</script>");
			
			return null;
		}
		
		Member member = memberService.getMember(memberId);
		session.setAttribute("isLogin", true);
		model.addAttribute("member", member);
		
		return "redirect:/main";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/list";
	}
	
	@RequestMapping("/joinResult")
	public String joinResult(Model model, Member member, String memberPass,
			String emailId, String emailDomain, String memberPhone) {
		
		member.setMemberPass(memberPass);
		member.setMemberEmail(emailId + "@" + emailDomain);
		System.out.println("memberPhone:"+memberPhone);
		 if (memberPhone != null && memberPhone.length() == 11) {
		        String formattedPhone = memberPhone.substring(0, 3) + "-" +
		                                memberPhone.substring(3, 7) + "-" +
		                                memberPhone.substring(7);
		        member.setMemberPhone(formattedPhone);
		    } else {
		        // 휴대폰 번호가 유효하지 않은 경우의 처리
		        member.setMemberPhone(memberPhone); // 기본적으로 입력된 형식 그대로 저장
		    }
		
		//MemberService를 통해서 회원 가입 폼에서 들어온 데이터를 DB에 저장한다.
		memberService.addMember(member);
		
		//로그인 폼으로 리다이렉트 시킨다.
		return "redirect:main";
	}
	
	//회원가입 폼에서 들어오는 중복 아이디 체크 요청을 처리하는 메서드
	@RequestMapping("/overlapIdcheck")
	public String overlapIdCheck(Model model, String memberId, String memberNick) {
		
		//회원 아이디 중복 여부
		boolean overlap = memberService.overlapIdCheck(memberId);
		
		//model에 아이디와 회원 아이디 중복 여부를 저장
		model.addAttribute("memberId", memberId);
		model.addAttribute("memberNick", memberNick);
		model.addAttribute("overlap", overlap);
		
		return "forward:WEB-INF/views/member/memberJoinForm.jsp";
	}
	
}
