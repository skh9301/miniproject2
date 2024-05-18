package com.miniproject2.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.miniproject2.study.domain.ItemList;
import com.miniproject2.study.service.ItemListService;

@Controller
public class ItemListController {
	@Autowired
	private ItemListService itemService;
	
	// 아이템게시판 메핑
	@GetMapping({"/itemList","/list"}) 
		public String itemList(Model model) {
		List<ItemList> iList = itemService.itemList();
		model.addAttribute("iList",iList); 
		return "itemList"; 
		}
	
	// 메인 페이지 메핑
	@RequestMapping({"/main","/"})
	public String main(){
		return "main";
	}
	// 아이템추가하는 메핑
	@PostMapping("/writeProcess")
	public String insertList(ItemList itemList) {
		itemService.insertList(itemList);
		return "redirect:itemList";
	}
	@RequestMapping("/writeForm")
	public String insertList() {
		return "writeForm";
	}
	//아이템게시판 상세페이지 
	@RequestMapping("/itemDetail")
	public String itemDetail(Model model,String itemNum) {
		ItemList itemList = itemService.getList(itemNum);
		model.addAttribute("itemList",itemList);
		return "itemDetail";
	}
	
	@PostMapping("/delete")
	public String deleteList(String itemNum) {
		itemService.deleteList(itemNum);
		return "redirect:itemList";
	}
	
	@PostMapping("/updateProcess")
	public String updateList(ItemList itemList) {
		itemService.updateList(itemList);
		return "redirect:itemList";
	}
	
	@RequestMapping("/update")
	public String updateList(String itemNum, Model model) {
		ItemList itemList = itemService.getList(itemNum);
		model.addAttribute("itemList",itemList);
		return "updateForm";
		
	}
}
