package com.miniproject2.study.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

import com.miniproject2.study.domain.ItemList;
import com.miniproject2.study.domain.Member;
import com.miniproject2.study.service.ItemListService;
import com.miniproject2.study.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private ItemListService itemService;
	
	

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
		session.setAttribute("member", member);
		session.setAttribute("fonkyMemberId", member.getMemberId());
		
		return "redirect:/main";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/main";
	}
	
	@RequestMapping("/joinResult")
	public String joinResult(Model model, Member member, String memberPass,
			String emailId, String emailDomain, String memberPhone,HttpSession session) {
		
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
		 List<ItemList> iList= itemService.itemList();
			model.addAttribute("itemNum",iList.get(0).getItemNum());
		//MemberService를 통해서 회원 가입 폼에서 들어온 데이터를 DB에 저장한다.
		memberService.addMember(member);
		//로그인 폼으로 리다이렉트 시킨다.
		return "redirect:/main";
	}
	
	//5월 27일 수정
	//회원가입 폼에서 들어오는 중복 아이디 체크 요청을 처리하는 메서드
	@RequestMapping("/idCheck")
	public String idCheck(Model model, String memberId){
		
		//회원 아이디 중복 여부
		boolean idChk = memberService.idCheck(memberId);
		
		//model에 아이디와 회원 아이디 중복 여부를 저장
		model.addAttribute("memberId", memberId);
		model.addAttribute("idChk", idChk);
		
		return "forward:WEB-INF/views/member/memberJoinForm.jsp";
	}
	
	//회원 수정폼에서 들어오는 요청을 처리하는 메서드
	@RequestMapping("/memberUpdateResult")
	public String memberUpdateInfo(HttpSession session,Model model, Member member, String memberNick, String pass1, 
				String memberZipcode, String memberAddress, String memberAddress2,
				String emailId, String emailDomain, String memberPhone) {
		
		member.setMemberPass(pass1);
		member.setMemberEmail(emailId + "@" + emailDomain);
		member.setMemberPhone(memberPhone);
//		 if (memberPhone != null && memberPhone.length() == 11) {
//		        String formattedPhone = memberPhone.substring(0, 3) + "-" +
//		                                memberPhone.substring(3, 7) + "-" +
//		                                memberPhone.substring(7);
//		     
//		        member.setMemberPhone(formattedPhone);
//		    } else {
//		        // 휴대폰 번호가 유효하지 않은 경우의 처리
//		        member.setMemberPhone(memberPhone); // 기본적으로 입력된 형식 그대로 저장
//		    }
		 
		 //MemberService를 통해서 회원 수정 폼에서 들어온 데이터를 DB에서 수정한다.
		 memberService.updateMember(member);
		 model.addAttribute("member", member);
		 
		 return "redirect:main";
	}
	
	//5월 28일 추가
		//회원 정보 수정 폼 요청을 처리하는 메서드
		@RequestMapping("/memberUpdateForm")
		public String updateForm(Model model, HttpSession session) {
			List<ItemList> iList= itemService.itemList();
			 model.addAttribute("itemNum",iList.get(0).getItemNum());
			 System.out.println(iList.get(0).getItemNum());
			return "member/memberUpdateForm";
		}
	
	
	//회원 탈퇴
		@RequestMapping("/memberDeleteResult")
	public String deleteForm(Model model, HttpSession session) {
			
		Member member = (Member) session.getAttribute("member");
		memberService.deleteMember(member);
		
		session.invalidate();
		
		return "redirect:main";
	}
}
