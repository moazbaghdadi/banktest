package com.supergroup.mybank;

public abstract class AbstractAccount {
	private int accountNumber;
	private int balance;
	
	public AbstractAccount(int accountNumber, int balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	public boolean book(int amount) {
		if(verifyBookingPrecondition(amount)) {
			balance = balance + amount;
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
}
