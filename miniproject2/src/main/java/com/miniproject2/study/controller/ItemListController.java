package com.miniproject2.study.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.miniproject2.study.domain.Auction;
import com.miniproject2.study.domain.ItemList;
import com.miniproject2.study.domain.Member;
import com.miniproject2.study.service.AuctionService;
import com.miniproject2.study.service.ItemListService;

@Controller
public class ItemListController {
	@Autowired
	private ItemListService itemService;
	@Autowired
	private AuctionService auctionService;
	//@Autowired
	//private MemberService memberService;
	
	
	// 업로드한 파일을 저장할 폴더 위치를 상수로 선언
	private final static String DEFAULT_PATH = "/resources/upload/";
	
	// 아이템게시판 메핑
	  @RequestMapping(value={"/itemList","/list"},method=RequestMethod.GET) 
	  public String itemList(Model model) { 
		  List<ItemList> iList = itemService.itemList();
		  model.addAttribute("iListNum",iList.get(0).getItemNum());
		  model.addAttribute("iList",iList); 
		  return "itemList"; 
	  }
	
	
	// 메인 페이지 메핑
	@RequestMapping({"/main","/"})
	public String main(Model model){
		List<ItemList> iList = itemService.itemList();
		  model.addAttribute("iListNum",iList.get(0).getItemNum()); 
		return "main";
	}
	
	  // 아이템추가하는 메핑
	  
		
		  @PostMapping("/writeProcess") 
		  public String insertList(Model model, HttpServletRequest req, String itemName, String itemProducer, String itemContent, int itemPrice,
		  @RequestParam(value="itemFile", required=false) MultipartFile multipartFile, String  itemEndDate, String  itemStartDate,String memberId)
		  throws IOException { 
			  
			  ItemList itemList = new ItemList();
		  itemList.setItemName(itemName); 
		  itemList.setItemProducer(itemProducer);
		  itemList.setItemPrice(itemPrice);
		  itemList.setItemContent(itemContent);
		  itemList.setItemStartDate(itemStartDate);
		  itemList.setItemEndDate(itemEndDate);
		  itemList.setMemberId(memberId);
		  
		  
		  if(!multipartFile.isEmpty()) { 
			  String filePath =  req.getServletContext().getRealPath(DEFAULT_PATH); 
			  UUID uid =  UUID.randomUUID(); 
			  String saveName = uid.toString() + "_" +  multipartFile.getOriginalFilename();
			  
			  File file = new File(filePath, saveName); 
			  multipartFile.transferTo(file);
			  itemList.setItemFile(saveName); 
			  System.out.println(filePath);
		  } 
		  
		  itemService.insertList(itemList);
		  return	  "redirect:itemList"; 
		  }
		
	  
	  
		
		  @RequestMapping("/fileDownload") public void download(HttpServletRequest req,
		  HttpServletResponse resp) throws IOException{ 
			  String fileName  =req.getParameter("fileName");
			  String filePath = req.getServletContext().getRealPath(DEFAULT_PATH); 
		  File file = new  File(filePath, fileName);
		  resp.setContentType("application/download; charset=UTF-8");
		  resp.setContentLength((int) file.length()); fileName =
		  URLEncoder.encode(file.getName(), "UTF-8");
		  resp.setHeader("Content-Disposition", "attachment; filename=\"" + fileName +
		  "\";"); 
		  resp.setHeader("Content-Transfer-Encoding", "binary"); 
		  OutputStream out = resp.getOutputStream(); FileInputStream fis = null; fis = new
		  FileInputStream(file); FileCopyUtils.copy(fis, out); 
		  if(fis != null) {
		  fis.close();
		  
		  } out.flush(); }
		 
	  
	  
	 @RequestMapping("/writeForm") 
	 public String insertList(Model model) {
		 List<ItemList> iList = itemService.itemList();
		 model.addAttribute("iListNum",iList.get(0).getItemNum());
		 return  "writeForm"; 
	 }
	 //아이템게시판 상세페이지
	 
	 @RequestMapping("/itemDetail") 
	 public String itemDetail(Model model,String itemNum) {
		 ItemList iList = itemService.getList(itemNum);
	  model.addAttribute("itemList",iList);
	  model.addAttribute("iListNum",iList.getItemNum());
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
		  model.addAttribute("iListNum",itemList.getItemNum()); 
		  
	  return "updateList";
	  }
	  
	  //거래소 사이트
	 @RequestMapping("/exChange")
	 public String exChange(Model model,String itemNum, Auction auction) {
		 List<ItemList> iList = itemService.itemList();
		 ItemList item = itemService.getList(itemNum);
		 List<Auction> aList = auctionService.auctionList();
		 //List<Member> mList = memberService.auctionList();
		 
		 // 옥션 테이블- 아래 출력
		 model.addAttribute("aList",aList);
		 //현재 물품 판매-현페이지 출력
		 model.addAttribute("item",item);
		 //물품 리스트 -> 오른쪽 출력
		 model.addAttribute("iList",iList);
		 //model.addAttribute("mList",mList);
		 
		 return "exChange";
	 }
	 
	 
}
