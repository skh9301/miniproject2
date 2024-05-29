package com.miniproject2.study.service;

import java.util.List;

import com.miniproject2.study.domain.Auction;

public interface AuctionService {
	public abstract List<Auction> getAuction(String itemNum);
	
	public abstract void insertAuction(Auction auction);
}


