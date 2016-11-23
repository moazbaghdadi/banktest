package com.supergroup.mybank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class AccountDaoTest {

	private AccountDao accountDao;
	
	@Before
	public void before(){
		accountDao = new AccountDaoImpl();
	}
	
	@Test
	public void findShouldReturnRightAccount() throws Exception {
		AbstractAccount mockAccount = mock(AbstractAccount.class);
		boolean saveSuccessful = accountDao.save(mockAccount);
		int accountNumber = 0;
		AbstractAccount abstractAccount = accountDao.find(accountNumber);
		assertSame(mockAccount, abstractAccount);
	}
	
	@Test
	public void savaShouldReturnTrueWhenNoAccountConflict() throws Exception {
		AbstractAccount mockAccount = mock(AbstractAccount.class);
		boolean saveSuccessful = accountDao.save(mockAccount);
		assertEquals(true, saveSuccessful);
//		System.out.println(mockAccount.getAccountNumber());
	}

}
