package com.miniproject2.study.dao;

import java.util.Map;

import com.miniproject2.study.domain.Bid;

public interface BidDao {
	public abstract void  insertBid(Bid bid);
	public abstract void  deleteBid(Bid bid);
	//즐겨찾기할때 itr 업데이트
	public abstract void updateBidItr(String bidItr,String fonkyItemNum, String fonkyMemberId );
	public abstract Bid selectBid(String fonkyItemNum, String fonkyMemberId );
}	
