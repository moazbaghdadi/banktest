package com.supergroup.mybank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class AbstractAccount {
	private int accountNumber;
	private int balance;
	private List<Booking> bookingHistory = new ArrayList<Booking>();
	
	public AbstractAccount(int accountNumber, int balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	public boolean book(int amount) {
		if(verifyBookingPrecondition(amount)) {
			balance = balance + amount;
			Booking booking = new Booking(amount, new Date());
			addBooking(booking);
			return true;
		} else {
			return false;
		}
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public int getAccountNumber() {
		return this.accountNumber;
	}
	
	abstract boolean verifyBookingPrecondition(int amount);

	public List<Booking> getBookingHistory() {
		return bookingHistory;
	}
	
	private boolean addBooking(Booking booking){
		return bookingHistory.add(booking);
	}
	
}
