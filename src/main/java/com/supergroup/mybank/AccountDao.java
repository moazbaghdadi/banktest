package com.supergroup.mybank;

public interface AccountDao {
	boolean save(AbstractAccount account);
	AbstractAccount find(int accountNumber);
}
