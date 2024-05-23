package com.miniproject2.study.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miniproject2.study.domain.Auction;

@Repository
public class AuctionDaoImpl implements AuctionDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String NAME_SPACE="com.miniproject2.mapper.auctionMapper";


	@Override
	public List<Auction> auctionList() {
		return sqlSession.selectList(NAME_SPACE+".auctionList");
	}

}
