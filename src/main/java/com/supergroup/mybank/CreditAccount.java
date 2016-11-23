package com.supergroup.mybank;

public class CreditAccount extends AbstractAccount {
	private int creditLine;

	public CreditAccount(int accountNumber, int balance, int creditLine) {
		super(accountNumber, balance);
		this.creditLine = creditLine;
	}

	@Override
	boolean verifyBookingPrecondition(int amount) {
		if (getBalance() + amount + creditLine < 0) {
			return false;
		}
		// TODO Auto-generated method stub

		return true;
	}

	public int getCreditLine() {
		return creditLine;
	}

	public void setCreditLine(int creditLine) {
		this.creditLine = creditLine;
	}
}