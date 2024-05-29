package com.miniproject2.study.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public List<ItemList> itemList(int startRow,int num,String type, String keyword) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("startRow", startRow);
		params.put("num", num);
		params.put("type", type);
		params.put("keyword", keyword);
		
		return	  sqlSession.selectList(NAME_SPACE+".itemList",params); 
	}
	  @Override
	  public List<ItemList> itemList(int startRow,int num) {
		  Map<String, Object> params = new HashMap<String, Object>();
		  params.put("startRow", startRow);
		  params.put("num", num);
		  
		  return	  sqlSession.selectList(NAME_SPACE+".itemListH",params); 
	}
	 
	  // 게시글리스트 카운트
		@Override
		public int getItemCount(String type, String keyword) {
			Map<String, String> params = new HashMap<String, String>();
			params.put("type", type);
			params.put("keyword", keyword);
			return sqlSession.selectOne(NAME_SPACE+".getItemCount",params);
		}
		// 옥션물품리스트 카운트
		@Override
		public int getItemCount() {
			return sqlSession.selectOne(NAME_SPACE+".getItemCount");
		}
	
	  @Override 
	  public ItemList getList(String itemNum) {
		  
	  return sqlSession.selectOne(NAME_SPACE+".getList",itemNum); 
	  }
	  
	  @Override 
	  public void insertList(ItemList itemList) {
		  
	  sqlSession.insert(NAME_SPACE+".insertList",itemList);
	  
	  }
	  
	  @Override 
	  public void updateList(ItemList itemlist) {
	  sqlSession.update(NAME_SPACE+".updateList", itemlist);
	  
	  }
	  
	  @Override 
	  public void deleteList(String itemNum) {
	  sqlSession.delete(NAME_SPACE+".deleteList",itemNum); 
	  
	  }

	@Override
	public List<ItemList> itemList() {
		return sqlSession.selectList(NAME_SPACE+".itemListH"); 
	}





	
	 

}
