package com.miniproject2.study.dao;

import java.util.List;

import com.miniproject2.study.domain.Auction;

public interface AuctionDao {
	public abstract List<Auction> getAuction(String itemNum);
	
	public abstract void insertAuction(Auction auction);
}
