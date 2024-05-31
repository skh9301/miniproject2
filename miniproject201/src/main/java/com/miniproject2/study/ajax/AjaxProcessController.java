package com.miniproject2.study.ajax;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miniproject2.study.domain.Bid;
import com.miniproject2.study.domain.Member;
import com.miniproject2.study.service.BidService;
import com.miniproject2.study.service.MemberService;

@Controller
public class AjaxProcessController {
	
	
	@Autowired
	private BidService bidService;
	
	@Autowired
	private MemberService memberService;
	
	
	
	//비밀번호 확인
	@RequestMapping("/passCheck.ajax")
	@ResponseBody
	public Map<String, Boolean> memberPassCheck(String memberId, String memberPass){
		boolean result = memberService.memberPassCheck(memberId, memberPass);
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("result", result);
		
		return map;
	}
	
	@RequestMapping("/idCheck.ajax")
	@ResponseBody
	public Map<String, Boolean> idCheck(String memberId){
		boolean result = memberService.idCheck(memberId);
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("result", result);
		
		return map;
	}
	
	//즐겨찾기
	
	@RequestMapping("/addBid.ajax")
	@ResponseBody
	public Map<String, String> insertBid(Bid bid, String fonkyItemNum, String fonkyMemberId, HttpSession Session) {
		Map<String, String> response = new HashMap<>();
		
		
		
	
		Bid bid1 = bidService.selectBid(fonkyItemNum, fonkyMemberId);
		System.out.println("첫번째 셀렉" + bid1);
	    if (bid1 == null) {
	        bidService.insertBid(bid);
	        System.out.println(fonkyItemNum);
			System.out.println(fonkyMemberId);
	        bid1 = bidService.selectBid(fonkyItemNum, fonkyMemberId); // 새로운 즐겨찾기 추가 후 다시 조회
	    }

		System.out.println(bid1.getBidItr());
	    String bidItr = bid1.getBidItr();
	    int bidItrValue = Integer.parseInt(bidItr); // 문자열을 숫자로 변환
	    
	    if (bidItrValue == 0) {
	        bidItr = "1"; // 문자열 "1"로 설정
	        System.out.println("두번째부분" + bidItr);
	        bidService.updateBidItr(bidItr, fonkyItemNum, fonkyMemberId);
	        response.put("message", "즐겨찾기가 추가되었습니다.");
	    } else {
	        bidItr = "0"; // 문자열 "0"로 설정
	        System.out.println("세번째부분" + bidItr);
	        bidService.updateBidItr(bidItr, fonkyItemNum, fonkyMemberId);
	        response.put("message", "즐겨찾기가 삭제되었습니다.");
	    }
	    
	    return response;
	}
	
	//최종입찰자의 포인트를 차감하는 매핑
	@RequestMapping("/deDuctionPoint")
	@ResponseBody
	public void deDuctionPoint(Member member, HttpSession session) {
		
		memberService.deDuctionPoint(member);
		session.setAttribute("memberPoint", member.getMemberPoint());
		
	}
	
}
