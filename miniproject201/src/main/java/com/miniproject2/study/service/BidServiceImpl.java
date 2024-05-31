package com.miniproject2.study.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject2.study.dao.BidDao;
import com.miniproject2.study.dao.ItemListDao;
import com.miniproject2.study.domain.Bid;

@Service
public class BidServiceImpl implements BidService{

	@Autowired
	private BidDao bidDao;
	
	@Autowired
	private ItemListDao itemDao;
	
	@Override
	public void insertBid(Bid bid) {
		bidDao.insertBid(bid);
	}

	@Override
	public void updateBidItr(String bidItr,String fonkyItemNum, String memberId) {
		bidDao.updateBidItr(bidItr, fonkyItemNum, memberId);
	}

	@Override
	public void deleteBid(Bid bid) {
		bidDao.deleteBid(bid);
	}

	@Override
	public Bid selectBid(String fonkyItemNum, String fonkyMemberId) {
		return bidDao.selectBid(fonkyItemNum, fonkyMemberId);
	}

}
