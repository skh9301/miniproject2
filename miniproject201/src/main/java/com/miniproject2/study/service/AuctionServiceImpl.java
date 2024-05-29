package com.miniproject2.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject2.study.dao.AuctionDao;
import com.miniproject2.study.domain.Auction;

@Service
public class AuctionServiceImpl implements  AuctionService{
	
	@Autowired
	private AuctionDao autionDao;


	@Override
	public void insertAuction(Auction auction) {
		autionDao.insertAuction(auction);
		
	}


	@Override
	public List<Auction> getAuction(String itemNum) {
		return autionDao.getAuction(itemNum);
	}


}
