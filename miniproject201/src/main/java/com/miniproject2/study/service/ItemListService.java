package com.miniproject2.study.service;

import java.util.List;
import java.util.Map;

import com.miniproject2.study.domain.ItemList;

public interface ItemListService {
		//즐겨찾기한 리스트만 뽑기
		public abstract List<ItemList> getBidList(String fonkyMemberId);
	
	
		//아이템리스트를 출력하는 메서드
		//옥션용
		public abstract Map<String,Object> itemList(int pageNum);
		//물품리스트용
		public abstract Map<String,Object> itemList(int pageNum,String type, String keyword);
		//아이템리스트를 출력하는 메서드(헤더)
		
		public abstract List<ItemList> itemList();
		
		
		 //해당번호 아이탬리스트를 출력하는 메서드 
		public abstract ItemList getList(String itemNum);
		  
		 //게시글 쓰기 
		public abstract void insertList(ItemList itemlist);
		  
		  // 게시글 수정하기 
		public abstract void updateList(ItemList itemlist);
		  
		  //게시글 삭제하기 
		public abstract void deleteList(String itemNum);
		 
}
