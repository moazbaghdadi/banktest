package com.supergroup.mybank;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AccountNumberGeneratorTest {

	private AccountNumberGenerator accountNumberGenerator;

	@Before
	public void setup() {
		accountNumberGenerator = new SimpleAccountNumberGenerator();
	}
	
	@Test
	public void testGenerateNewNumberShouldIncreaseNumber() throws Exception {
		int first = accountNumberGenerator.generateNumberGenerator();
		int second = accountNumberGenerator.generateNumberGenerator();
		int third = accountNumberGenerator.generateNumberGenerator();
		
		assertEquals(1, first);
		assertEquals(2, second);
		assertEquals(3, third);
	}
}
