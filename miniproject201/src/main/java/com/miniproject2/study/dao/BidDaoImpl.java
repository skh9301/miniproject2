package com.miniproject2.study.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miniproject2.study.domain.Bid;
@Repository
public class BidDaoImpl implements BidDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String NAME_SPACE="com.miniproject2.mapper.ItemMapper";

	@Override
	public void  insertBid(Bid bid) {
		
		sqlSession.insert(NAME_SPACE+".insertBid",bid);
	}
	
	
	@Override
		public void  deleteBid(Bid bid) {
		
		sqlSession.delete(NAME_SPACE+".deleteBid",bid);
	}

	@Override
	public void updateBidItr(String bidItr, String fonkyItemNum, String fonkyMemberId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bidItr", bidItr);
		params.put("fonkyItemNum", fonkyItemNum);
		params.put("fonkyMemberId", fonkyMemberId);
		sqlSession.update(NAME_SPACE+".updateBidItr",params);
	}


	@Override
	public Bid selectBid(String itemNum, String memberId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("itemNum", itemNum);
		params.put("memberId", memberId);
		return sqlSession.selectOne(NAME_SPACE+".selectBidItr",params);
		
	}
	
}	
