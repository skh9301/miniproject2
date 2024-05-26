package com.miniproject2.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject2.study.dao.ItemListDao;
import com.miniproject2.study.domain.ItemList;

@Service
public class ItemListServiceImpl implements ItemListService{

	@Autowired
	private ItemListDao itemListDao;


	@Override
	public List<ItemList> itemList() {
		return itemListDao.itemList();
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

}
