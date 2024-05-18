package com.miniproject2.study.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miniproject2.study.domain.ItemList;

@Repository
public class ItemListDaoImpl implements ItemListDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	
	private final String NAME_SPACE="com.miniproject2.mapper.ItemMapper";


	@Override
	public List<ItemList> itemList() {
		return sqlSession.selectList(NAME_SPACE+".itemList");
	}

	@Override
	public ItemList getList(String itemNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertList(ItemList itemlist) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateList(ItemList itemlist) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteList(String itemNum) {
		// TODO Auto-generated method stub
		
	}

}
