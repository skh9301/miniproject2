package com.miniproject2.study.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject2.study.dao.ItemListDao;
import com.miniproject2.study.domain.ItemList;

@Service
public class ItemListServiceImpl implements ItemListService{

	@Autowired
	private ItemListDao itemListDao;
	
	private static final  int PAGE_SIZE = 5;
	private static final  int APAGE_SIZE = 15;
	
	private static final int  PAGE_GROUP =10;
	private static final int  APAGE_GROUP =5;
	//물품리스트용
	@Override
	public Map<String, Object> itemList(int pageNum,String type, String keyword) {
		int currentPage = pageNum;
		int startRow = (currentPage-1)* PAGE_SIZE;
		int listCount = 0;
		
		boolean searchOption = (type.equals("null")
				|| keyword.equals("null")) ? false : true;
		listCount = itemListDao.getItemCount( type, keyword);
		List<ItemList> iList =  itemListDao.itemList(startRow, PAGE_SIZE,type, keyword);
		
		int pageCount= listCount / PAGE_SIZE + (listCount%PAGE_SIZE==0?0:1);
		
		int startPage = (currentPage / PAGE_GROUP)* PAGE_GROUP+1 -(currentPage%PAGE_GROUP==0?PAGE_GROUP:0);
		int endPage = startPage + PAGE_GROUP -1;
		if(endPage>pageCount) {
			endPage=pageCount;
		}
		// 옥션부분 페이징처리
		
		Map<String,Object> modelMap = new HashMap<String,Object>();
		
		// 물품리스트 출력
		modelMap.put("iList",iList);
		modelMap.put("pageCount", pageCount);
		modelMap.put("startPage", startPage);
		modelMap.put("endPage", endPage);
		modelMap.put("currentPage", currentPage);
		modelMap.put("listCount", listCount);
		modelMap.put("pageGroup", PAGE_GROUP);
		modelMap.put("searchOption", searchOption);
		// 검색 요청이면 type과 keyword를 모델에 저장한다.
		if(searchOption) {
			modelMap.put("type", type);
			modelMap.put("keyword", keyword);
		}
		
		
		return modelMap;
	}
	//옥션용
	@Override
	public Map<String, Object> itemList(int pageNum) {
		int currentPage = pageNum;
		
		int listCount = itemListDao.getItemCount();
		
		// 옥션부분 페이징처리
		int aStartRow = (currentPage-1)* APAGE_SIZE;
		List<ItemList> aiList =  itemListDao.itemList(aStartRow, APAGE_SIZE);
		
		int aPageCount= listCount / APAGE_SIZE + (listCount%APAGE_SIZE==0?0:1);
		
		int aStartPage = (currentPage / APAGE_GROUP)* APAGE_GROUP+1 -(currentPage%APAGE_GROUP==0?APAGE_GROUP:0);
		int aEndPage = aStartPage + APAGE_GROUP -1;
		if(aEndPage>aPageCount) {
			aEndPage=aPageCount;
		}
		
		Map<String,Object> modelMap = new HashMap<String,Object>();
		
		modelMap.put("currentPage", currentPage);
		modelMap.put("listCount", listCount);
		modelMap.put("aiList",aiList);
		modelMap.put("aPageCount", aPageCount);
		modelMap.put("aStartPage", aStartPage);
		modelMap.put("aEndPage", aEndPage);
		modelMap.put("aPageGroup", APAGE_GROUP);
		
		return modelMap;
	}

	@Override 
	public ItemList getList(String itemNum){

		return	itemListDao.getList(itemNum); 
		}

	@Override 
	public void insertList(ItemList itemlist) {
		itemListDao.insertList(itemlist); 
		}

	@Override 
	public void updateList(ItemList itemlist) {
		itemListDao.updateList(itemlist); 
		}

	@Override 
	public void deleteList(String itemNum) {
		itemListDao.deleteList(itemNum); 
		}

	@Override
	public List<ItemList> itemList() {
		return itemListDao.itemList();
	}

}
