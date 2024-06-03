package com.java.BankSystem;

import java.util.Scanner;

public class InterestCalculator {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int key;

		do {
			System.out.println("\nSelect the option:\r\n" + "1. Interest Calculator –FD\r\n"
					+ "2. Interest Calculator –RD\r\n" + "3. Interest Calculator –SB\r\n" + "4. Exit");

			key = scan.nextInt();
			Account account;
			switch (key) {
			case 1:
				account = new FDAccount();

				try {
					System.out.println(account.calculateInterest());
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}

				break;

			case 2:

				account = new RDAccount();
				try {
					System.out.println(account.calculateInterest());
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}

				break;

			case 3:

				account = new SBAccount();
				try {
					System.out.println(account.calculateInterest());
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}

				break;

			case 4:
				System.out.println("you are exit from the system");
				System.exit(0);
			default:
				System.out.println("Please enter the correct option from ");

			}

		} while (key != 4);
	}

}
