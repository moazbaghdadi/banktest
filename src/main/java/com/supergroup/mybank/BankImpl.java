package com.supergroup.mybank;

public class BankImpl implements Bank {
	
	AccountDao accountDao;
	
	public BankImpl(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public boolean withdrawal(int accountNumber, int amount) {
		AbstractAccount account = accountDao.find(accountNumber);
		return account.book(-amount);
	}

	public boolean deposit(int accountNumber, int amount) {
		AbstractAccount account = accountDao.find(accountNumber);
		return account.book(amount);
	}

	public boolean transfer(int payingAccountNumber, int receivingAccountNumber, int amount) {
		boolean result = withdrawal(payingAccountNumber, amount);
		if(result) {
			boolean result2 = deposit(receivingAccountNumber, amount);
			if(result2){
				return true;
			} else {
				deposit(payingAccountNumber, amount);
			}
		}
		return false;
	}

	public AbstractAccount createAccount(int balance, int creditLine, AccountType accountType) {
		// TODO Auto-generated method stub
		return null;
	}

}
