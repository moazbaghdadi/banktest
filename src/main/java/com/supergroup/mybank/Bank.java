package com.supergroup.mybank;

public interface Bank {
	boolean withdrawal(int accountNumber, int amount);
	boolean deposit(int accountNumber, int amount);
	boolean transfer(int payingAccountNumber, int receivingAccountNumber, int amount);
	AbstractAccount createAccount(int balance, int creditLine, AccountType accountType);
}
