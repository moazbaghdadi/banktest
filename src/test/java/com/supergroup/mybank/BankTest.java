package com.supergroup.mybank;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class BankTest {
	
	private Bank bank;
	private AbstractAccount account;
	private AccountDao accountDao;

	@Before
	public void setup() {
		account = Mockito.mock(AbstractAccount.class);
		accountDao = Mockito.mock(AccountDao.class);
		bank = new BankImpl(accountDao);
		
	}
	
	@Test
	public void testDepositShouldCallFindMethodInDaoAndBookMethodOfAccount() throws Exception {
		int amount = 10;
		
		Mockito.when(accountDao.find(1)).thenReturn(account);
		
		Mockito.when(account.book(amount)).thenReturn(true);
		
		boolean result = bank.deposit(1, amount);
		
		assertTrue(result);
		Mockito.verify(accountDao).find(1);
		Mockito.verify(account).book(amount);
	}
	
	@Test
	public void testWithdrawalShouldCallFindMethodInDaoAndBookMethodOfAccount() throws Exception {
		int amount = 10;

		Mockito.when(accountDao.find(1)).thenReturn(account);
		
		Mockito.when(account.book(-amount)).thenReturn(true);
		
		boolean result = bank.withdrawal(1, amount);
		
		assertTrue(result);
		Mockito.verify(accountDao).find(1);
		Mockito.verify(account).book(-amount);
	}
	
	@Test
	public void testTransferShouldCallFindMethodInDaoTwiceAndBookMethodOfAccountTwice() throws Exception {
		int amount = 10;
		AbstractAccount account2 = Mockito.mock(AbstractAccount.class);
		
		Mockito.when(accountDao.find(1)).thenReturn(account);
		Mockito.when(accountDao.find(2)).thenReturn(account2);
		
		Mockito.when(account.book(-amount)).thenReturn(true);
		Mockito.when(account2.book(amount)).thenReturn(true);
		
		boolean result = bank.transfer(1, 2, amount);
		
		assertTrue(result);
		Mockito.verify(accountDao).find(1);
		Mockito.verify(accountDao).find(2);
		Mockito.verify(account).book(-amount);
		Mockito.verify(account2).book(amount);
	}

	@Test
	public void testTransferShouldFailAtWithdrawal() throws Exception {
		int amount = 10;
		
		Mockito.when(accountDao.find(1)).thenReturn(account);
		
		Mockito.when(account.book(-amount)).thenReturn(false);
		
		boolean result = bank.transfer(1, 2, amount);
		
		assertFalse(result);
		Mockito.verify(accountDao).find(1);
		Mockito.verify(account).book(-amount);
	}
	
	@Test
	public void testTransferShouldFailAtDeposit() throws Exception {
		int amount = 10;
		AbstractAccount account2 = Mockito.mock(AbstractAccount.class);
		
		Mockito.when(accountDao.find(1)).thenReturn(account);
		Mockito.when(accountDao.find(2)).thenReturn(account2);
		
		Mockito.when(account.book(-amount)).thenReturn(true);
		Mockito.when(account2.book(amount)).thenReturn(false);
		
		boolean result = bank.transfer(1, 2, amount);
		
		assertFalse(result);
		Mockito.verify(accountDao, Mockito.times(2)).find(1);
		Mockito.verify(accountDao).find(2);
		Mockito.verify(account).book(-amount);
		Mockito.verify(account).book(amount);
		Mockito.verify(account2).book(amount);
	}
	
}
