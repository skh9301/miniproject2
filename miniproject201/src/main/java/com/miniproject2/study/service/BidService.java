package com.miniproject2.study.service;

import java.util.Map;

import com.miniproject2.study.domain.Bid;

public interface BidService {
	public void insertBid(Bid bid);
	
	public void updateBidItr(String BidItr,String fonkyItemNum, String fonkyMemberId);
	
	public void deleteBid(Bid bid);
	
	
	public abstract Bid selectBid(String fonkyItemNum, String fonkyMemberId );
}
