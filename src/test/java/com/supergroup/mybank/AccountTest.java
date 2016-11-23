package com.supergroup.mybank;


import org.junit.Assert;
import org.junit.Test;

public class AccountTest {

	@Test
	public void bookWithPositiveAmount() throws Exception {
		SavingAccount account = new SavingAccount(1, 0);
		Assert.assertEquals(0, account.getBalance());
		int amount = 100;
		account.book(amount);
		Assert.assertEquals(amount, account.getBalance());
	}

	}