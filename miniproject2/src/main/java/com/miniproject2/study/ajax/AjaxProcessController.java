package com.miniproject2.study.ajax;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miniproject2.study.service.MemberService;

@Controller
public class AjaxProcessController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/overlapIdcheck.ajax")
	@ResponseBody
	public Map<String, Boolean> overlapIdCheck(String memberId){
		
		boolean result = memberService.overlapIdCheck(memberId);
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("result", result);
		
		return map;
	}
}
