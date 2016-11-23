package com.supergroup.mybank;

public class BankImpl implements Bank {
	
	AccountDao accountDao;
	AccountNumberGenerator generator;
	
	public BankImpl(AccountDao accountDao, AccountNumberGenerator generator) {
		this.accountDao = accountDao;
		this.generator = generator;
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
		AbstractAccount account = null;
		boolean result;
		switch (accountType) {
		case SAVING_ACCOUNT:
			account = new SavingAccount(generator.generateNumber(), balance);
			result = accountDao.save(account);
			if (result) {
				return account;
			}
			break;
		case CREDIT_ACCOUNT:
			account = new CreditAccount(generator.generateNumber(), balance, creditLine);
			result = accountDao.save(account);
			if (result) {
				return account;
			}
			break;
		}
		return null;
	}

}
