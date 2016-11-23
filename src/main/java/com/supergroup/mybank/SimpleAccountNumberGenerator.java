package com.supergroup.mybank;

public class SimpleAccountNumberGenerator implements AccountNumberGenerator {

	int nextNumber = 1;
	
	public int generateNumber() {
		return nextNumber++;
	}

}
