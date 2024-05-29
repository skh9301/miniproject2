package com.miniproject2.study.ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miniproject2.study.domain.ItemList;
import com.miniproject2.study.service.AuctionService;
import com.miniproject2.study.service.ItemListService;

@Controller
public class ItemListAjaxController {
	
	@Autowired
	private ItemListService itemService;
	
	@Autowired
	private AuctionService auctionService;
	
	
	@RequestMapping("/AuctionJoin.ajax")
	@ResponseBody
	public ItemList AuctionJoin(String itemNum) {
		ItemList item = itemService.getList(itemNum);
		return item;
	}
	
	
}
