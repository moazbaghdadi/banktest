package com.supergroup.mybank;

import java.util.Date;

public class Booking {
	private int amount;
	private Date date;
	
	public Booking(int amount, Date date){
		this.amount = amount;
		this.date = date;
	}
	
	public int getAmount() {
		return amount;
	}

	public Date getDate() {
		return date;
	}

}
