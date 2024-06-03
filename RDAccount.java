package com.java.BankSystem;

import java.util.Scanner;
import com.java.BankSystem.*;

public class RDAccount extends Account {

	private double interestRate;
	private double amount;
	private int noOfMonths;
	private double age;

	private double general;
	private double sCitizen;

	public double getAge() {
		return age;
	}

	public void setAge(double age) throws InvalidAgeException {
		if (age <= 0 && age > 150) {
			throw new InvalidAgeException("Warning! Enter the valid Age");
		}
		this.age = age;
	}

	public double getGeneral() {
		return general;
	}

	public void setGeneral(double general) {
		this.general = general;
	}

	public double getsCitizen() {
		return sCitizen;
	}

	public void setsCitizen(double sCitizen) {
		this.sCitizen = sCitizen;
	}

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
			throw new InvalidAmountException("Warning! Enter the valid Amount");
		}
		this.amount = amount;
	}

	public int getNoOfMonths() {

		return noOfMonths;
	}

	public void setNoOfMonths(int noOfMonths) throws InvalidMonthException {
		if (noOfMonths <= 0 || noOfMonths > 21) {
			throw new InvalidMonthException("Warning! Enter the valid Months");
		}
		this.noOfMonths = noOfMonths;
	}

	Scanner scan = new Scanner(System.in);

	double calculateInterest() throws InvalidAmountException, InvalidMonthException, InvalidAgeException {
		System.out.println("-----Recurring Deposit (RD)-----");
		System.out.println("Enter the Amount");
		setAmount(scan.nextDouble());
		System.out.println("Enter the Month");
		setNoOfMonths(scan.nextInt());
		System.out.println("Enter the Age");
		setAge(scan.nextInt());

		if (noOfMonths >= 6 && noOfMonths < 9) {
			setGeneral(7.50);
			setsCitizen(8.00);

		} else if (noOfMonths >= 9 && noOfMonths < 12) {
			setGeneral(7.75);
			setsCitizen(8.25);

		} else if (noOfMonths >= 12 && noOfMonths < 15) {
			setGeneral(8.00);
			setsCitizen(8.50);

		} else if (noOfMonths >= 15 && noOfMonths < 18) {
			setGeneral(8.25);
			setsCitizen(8.75);

		} else if (noOfMonths >= 18 && noOfMonths < 21) {
			setGeneral(8.50);
			setsCitizen(9.00);

		} else if (noOfMonths == 21) {
			setGeneral(8.75);
			setsCitizen(9.25);

		}

		if (age < 60) {
			setInterestRate(getGeneral());
		} else {
			setInterestRate(getsCitizen());
		}

		return (getInterestRate() * (getAmount())) / 100;

	}

}
