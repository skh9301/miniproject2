package com.miniproject2.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.miniproject2.study.domain.ItemList;
import com.miniproject2.study.service.ItemListService;

@Controller
public class ItemListController {
	@Autowired
	private ItemListService itemService;
	
	/*
	 * @RequestMapping({"/itemList","/list"}) public String itemList(Model model) {
	 * List<ItemList> iList = itemService.itemList();
	 * model.addAttribute("iList",iList); return "itemList"; }
	 */
	
	@RequestMapping({"/main","/"})
	public String main(){
		return "main";
	}
}
