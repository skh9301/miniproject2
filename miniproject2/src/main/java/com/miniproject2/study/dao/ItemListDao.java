package com.miniproject2.study.dao;

import java.util.List;

import com.miniproject2.study.domain.ItemList;

public interface ItemListDao {
	
	//아이템리스트를 출력하는 메서드
	
	 public abstract List<ItemList> itemList(); 
	
	
	 //해당번호 아이탬리스트를 출력하는 메서드 
	 public abstract ItemList getList(String itemNum);
	  
	 //게시글 쓰기 
	 public abstract void insertList(ItemList itemlist);
	  
	  // 게시글 수정하기 
	 public abstract void updateList(ItemList itemlist);
	  
	  //게시글 삭제하기 p
	 public abstract void deleteList(String itemNum);
	 

}
