package com.java.BankSystem;

import java.util.Scanner;

public class SBAccount extends Account {

	private double interestRate;
	private double amount;

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) throws InvalidAmountException {
		if (amount <= 0) {
			throw new InvalidAmountException("Warning! Enter the valid amount");
		}
		this.amount = amount;
	}

	Scanner scan = new Scanner(System.in);

	double calculateInterest() throws InvalidAmountException {
		System.out.println("-----Basic Savings Bank Deposit Account-----");
		System.out.println("Enter the amount");
		setAmount(scan.nextDouble());
		System.out.println("Enter the type of account\n1.Normal\n2.NRI\n");
		String str = scan.next();

		if (str.equalsIgnoreCase("normal")) {
			setInterestRate(4);
		} else if (str.equalsIgnoreCase("nri")) {
			setInterestRate(6);
		}

		return (getAmount() * getInterestRate()) / 100;

	}

}
