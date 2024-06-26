package com.miniproject2.study.domain;

import java.sql.Timestamp;

import org.springframework.format.annotation.DateTimeFormat;

public class ItemList {
	String itemNum;
	String itemName;
	String itemProducer;
	String itemContent;
	int itemPrice;
	String itemFile;
	String itemItr;
	String  itemStartDate;
	String  itemEndDate;
	String memberId;
	
	public ItemList() {}

	
	
	public ItemList(String itemNum, String itemName, String itemProducer, String itemContent, int itemPrice,
			String itemFile, String itemItr,  String memberId , String  itemStartDate, String  itemEndDate) {
		super();
		this.itemNum = itemNum;
		this.itemName = itemName;
		this.itemProducer = itemProducer;
		this.itemContent = itemContent;
		this.itemPrice = itemPrice;
		this.itemFile = itemFile;
		this.itemItr = itemItr;
	
		this.itemStartDate = itemStartDate;
		this.itemEndDate = itemEndDate;
		this. memberId= memberId;
	}



	public String getItemNum() {
		return itemNum;
	}

	public void setItemNum(String itemNum) {
		this.itemNum = itemNum;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemProducer() {
		return itemProducer;
	}

	public void setItemProducer(String itemProducer) {
		this.itemProducer = itemProducer;
	}

	public String getItemContent() {
		return itemContent;
	}

	public void setItemContent(String itemContent) {
		this.itemContent = itemContent;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemFile() {
		return itemFile;
	}

	public void setItemFile(String itemFile) {
		this.itemFile = itemFile;
	}

	public String getItemItr() {
		return itemItr;
	}

	public void setItemItr(String itemItr) {
		this.itemItr = itemItr;
	}

	public String  getItemStartDate() {
		return itemStartDate;
	}
	
	public void setItemStartDate(String  itemStartDate) {
		this.itemStartDate = itemStartDate;
	}
	public String  getItemEndDate() {
		return itemEndDate;
	}
	
	public void setItemEndDate(String  itemEndDate) {
		this.itemEndDate = itemEndDate;
	}
	public String  getMemberId() {
		return memberId;
	}
	
	public void setMemberId(String memberId  ) {
		this.memberId = memberId;
	}
	
}
