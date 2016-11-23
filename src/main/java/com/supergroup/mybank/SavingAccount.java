package com.supergroup.mybank;


public class SavingAccount extends AbstractAccount {
	public SavingAccount(int accountNumber, int balance) {
	super(accountNumber, balance);
	}

	@Override
	boolean verifyBookingPrecondition(int amount) {
		if (getBalance() + amount < 0) {
			return false;
		}
		return true;


	}
}
