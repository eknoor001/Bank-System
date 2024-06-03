package com.java.BankSystem;

import java.util.Scanner;

public class FDAccount extends Account {

	private double interestRate;
	private double amount;
	private int noOfDays;
	private int ageOfACHolder;
	private double general;
	private double sCitizen;

	Scanner scan = new Scanner(System.in);

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

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) throws InvalidDaysException {
		if (noOfDays <= 0 || noOfDays > 365) {
			throw new InvalidDaysException("Warning! Enter the valid days\nNumber of Days at least 7");
		}
		this.noOfDays = noOfDays;
	}

	public int getAgeOfACHolder() {
		return ageOfACHolder;
	}

	public void setAgeOfACHolder(int ageOfACHolder) throws InvalidAgeException {
		if (ageOfACHolder <= 0) {
			throw new InvalidAgeException("Warning! Enter the valid Age");
		}
		this.ageOfACHolder = ageOfACHolder;
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

	double calculateInterest() throws InvalidAmountException, InvalidDaysException, InvalidAgeException {

		System.out.println("Enter the FD amount: ");
		setAmount(scan.nextDouble());
		System.out.println("Enter the number of days: ");
		setNoOfDays(scan.nextInt());
		System.out.println("Enter your age: ");
		setAgeOfACHolder(scan.nextInt());

		if (amount < 10000000) {
			if (noOfDays >= 7 && noOfDays <= 14) {
				setGeneral(4.50);
				setsCitizen(5.00);

			} else if (noOfDays >= 15 && noOfDays <= 29) {
				setGeneral(4.75);
				setsCitizen(5.25);

			} else if (noOfDays >= 30 && noOfDays <= 45) {
				setGeneral(5.50);
				setsCitizen(6.00);

			} else if (noOfDays > 45 && noOfDays <= 60) {
				setGeneral(7.00);
				setsCitizen(7.50);

			} else if (noOfDays > 61 && noOfDays <= 184) {
				setGeneral(7.50);
				setsCitizen(8.00);

			} else if (noOfDays > 185 && noOfDays <= 365) {
				setGeneral(8.00);
				setsCitizen(8.50);

			}
			if (getAgeOfACHolder() < 60 && getAgeOfACHolder() > 0) {
				setInterestRate(getGeneral());
			} else {
				setInterestRate(getsCitizen());
			}
		} else if (amount > 10000000) {
			if (noOfDays >= 7 && noOfDays <= 14) {
				setInterestRate(6.50);

			} else if (noOfDays >= 15 && noOfDays <= 29) {
				setInterestRate(6.75);
			} else if (noOfDays >= 30 && noOfDays <= 45) {
				setInterestRate(6.75);
			} else if (noOfDays > 45 && noOfDays <= 60) {
				setInterestRate(8);
			} else if (noOfDays > 61 && noOfDays <= 184) {
				setInterestRate(8.50);
			} else if (noOfDays > 185 && noOfDays <= 365) {
				setInterestRate(10.00);
			}

		}

		return (getInterestRate() * getAmount()) / 100;

	}

}
