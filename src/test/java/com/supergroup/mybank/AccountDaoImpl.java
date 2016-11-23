package com.supergroup.mybank;

import java.util.HashMap;
import java.util.Map;

public class AccountDaoImpl implements AccountDao {

	private Map<Integer, AbstractAccount> accounts = new HashMap<Integer, AbstractAccount>();
	
	public boolean save(AbstractAccount account) {
		return accounts.put(account.getAccountNumber(), account) != null ? false : true;
	}

	public AbstractAccount find(int accountNumber) {
		return accounts.get(accountNumber);
	}

}
