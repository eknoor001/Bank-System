package com.java.BankSystem;

public abstract class Account {

	double interestRate;
	double amount;

	abstract double calculateInterest() throws Exception;

}
