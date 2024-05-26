package com.miniproject2.study.ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miniproject2.study.domain.ItemList;
import com.miniproject2.study.service.ItemListService;

@Controller
public class ItemListAjaxController {
	
	@Autowired
	private ItemListService itemService;
	
	@PostMapping("/header.ajax")
	@ResponseBody
	public List<ItemList> getItemNum(ItemList itemlist) {
		
		 List<ItemList> iList =itemService.itemList();
		 
		 
		// 갱신된 댓글 리스트를 읽어와서 반환	
		// [{"no": 1, "bbsNo": 200, "replyContent": "오늘 뭐 먹지"}, {}, {}]
		return iList;
	}
}
