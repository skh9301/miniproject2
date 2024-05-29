package com.miniproject2.study.ajax;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject2.study.domain.Auction;
import com.miniproject2.study.domain.ItemList;
import com.miniproject2.study.service.AuctionService;
import com.miniproject2.study.service.ItemListService;

@RestController
public class ItemListAjaxController {
	
	@Autowired
	private ItemListService itemService;
	
	@Autowired
	private AuctionService auctionService;
	
	
	@RequestMapping("/auctionTime")
	public Map<String, Object> ActionTime(String itemNum) {
		List<Auction> aList = auctionService.getAuction(itemNum);
		// 경매 시작 시간과 종료 시간을 읽어와
		ItemList item = itemService.getList(itemNum);
		LocalDateTime startDt = LocalDateTime.parse(item.getItemStartDate());
		LocalDateTime endDt = LocalDateTime.parse(item.getItemEndDate());
		LocalDateTime currDt = LocalDateTime.now();		
		
		// 시작 시간과 종료일 사이의 초 계산
		long seconds = currDt.until(endDt, ChronoUnit.SECONDS);		
		
		// 남은 날짜를 계산하고 날짜 계산한 만큼 차감 
		long days = seconds / 24 / 60 / 60;
		seconds = seconds - days * 24 * 60 * 60;
		
		// 남은 시간을 계산하고 시간 계산한 만큼 차감
		long hours = seconds / 60 / 60;
		seconds = seconds - hours * 60 * 60;
		
		// 남은 분을 계산하고 분 계산한 만큼 차감 
		long minutes = seconds / 60;
		seconds = seconds - minutes * 60;
		
		// 경매 종료까지 남은 날짜와 시간 출력
		
		// 경매 시작 전이면 경매 시작시간 표시
		// 경매가 시작되었으면 종료까지 남은 시간 표시
		// 경매 시작 전 여부 started=true, 경매 종료여부 finished=true
		boolean started = currDt.isAfter(startDt);
		
		boolean finished = currDt.isAfter(endDt);
		
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("started", started);
		System.out.println(started);
		resultMap.put("finished", finished);
		resultMap.put("days", days);
		resultMap.put("hours", hours);		
		resultMap.put("minutes", minutes);
		resultMap.put("seconds", seconds);
		resultMap.put("aList", aList);
		
		return resultMap;
	}
	
	@RequestMapping("/insertAuction")
	@ResponseBody
	public String  insertAuction(String itemNum,String memberId, int regPrice) {
		Auction auction = new Auction();
		auction.setItemNum(itemNum);
		auction.setMemberId(memberId);
		auction.setRegPrice(regPrice);
		auctionService.insertAuction(auction);
		
		return "success";
	}
	
	
	
	
}
