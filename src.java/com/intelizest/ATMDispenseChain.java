/**
 * 
 */
package com.intelizest;

import java.util.Scanner;

/**
 * @author rupesh sharma
 *
 */

public class ATMDispenseChain {

	private DispenseChain c1;

	public ATMDispenseChain() {
		// initialize the chain
		this.c1 = new Dollar20Dispenser();
		DispenseChain c2 = new Dollar10Dispenser();
		DispenseChain c3 = new Dollar5Dispenser();
		DispenseChain c4 = new Dollar1Dispenser();

		// set the chain of responsibility
		c1.setNextChain(c2);
		c2.setNextChain(c3);
		c3.setNextChain(c4);
	}

	public static void main(String[] args) {

		//Sample input as below, each new line takes input
		/**
		 * Enter option: Deposit or Withdraw? 
		 * Deposit 
		 * Enter denomination 
		 * 20 
		 * Enter quantity 
		 * 10 
		 * Enter denomination 
		 * 10 
		 * Enter quantity 
		 * 10 
		 * Enter denomination
		 * 5
		 * Enter quantity
		 * 10 
		 * Enter denomination 
		 * 1 
		 * Enter quantity
		 * 10 
		 * Balance: 20s=10, 10s=10, 5s=10, 1s=10, Total=360 
		 * Enter option: Deposit or Withdraw? 
		 * Withdraw
		 * Enter amount to dispense 
		 * 137 
		 * Dispensing 6 20$ note 
		 * Dispensing 1 10$ note
		 * Dispensing 1 5$ note 
		 * Dispensing 2 1$ note 
		 * Balance: 20s=4, 10s=9, 5s=9, 1s=8, Total=223 
		 * Enter option: Deposit or Withdraw?
		 */

		ATMDispenseChain atmDispenser = new ATMDispenseChain();

		// Initialize the inventory
		Inventory<Bill> inventory = new Inventory<>();
		inventory.put(Bill.TWENTY, 0);
		inventory.put(Bill.TEN, 0);
		inventory.put(Bill.FIVE, 0);
		inventory.put(Bill.ONE, 0);

		// Infinite loop
		while (true) {

			// Take Deposit or Withdraw as the input option
			System.out.println("Enter option: Deposit or Withdraw?");
			Scanner input = new Scanner(System.in);
			// input.useDelimiter(":");
			String option = input.next();

			switch (option) {

			case "Deposit":

				int allInputZero = 0; // Error condition count for all input as 0
				int inputCount = 0; // Input count for bills

				// Run for all the 4 denominations, right now I am taking input on each next
				// line,
				// but it can be changed to take input on single line as mentioned in
				// requirement
				while (inputCount < 4) {

					System.out.println("Enter denomination ");
					inputCount++;
					int bill = input.nextInt();
					System.out.println("Enter quantity. ");
					int quantity = input.nextInt();

					// System.out.println("Bill "+bill+" Quantity "+quantity);

					if (quantity < 0) {
						System.out.println("Incorrect Deposit Amount.");
						break;
					} else if (quantity == 0) {
						allInputZero++;
					} else {
						inventory.add(Bill.valueOf(bill), quantity);
					}
				}

				if (allInputZero == inputCount) {
					System.out.println("Deposit Amount cannnot be zero.");
				}

				break;

			case "Withdraw":
				System.out.println("Enter amount to dispense");
				int amount = input.nextInt();

				if (amount <= 0 || amount > inventory.getBalance()) {
					System.out.println("Incorrect or Insufficient funds.");
					break;
				}

				atmDispenser.c1.dispense(new Currency(amount), inventory);
				break;

			default:
				System.out.println("Enter valid input.");
			}
			// process the request

			System.out.println("Balance: 20s=" + inventory.getQuantity(Bill.TWENTY) + ", 10s="
					+ inventory.getQuantity(Bill.TEN) + ", 5s=" + inventory.getQuantity(Bill.FIVE) + ", 1s="
					+ inventory.getQuantity(Bill.ONE) + ", Total=" + inventory.getBalance());
		}

	}

}
