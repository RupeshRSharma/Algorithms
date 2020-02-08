/**
 * 
 */
package com.intelizest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rupesh sharma
 *
 */
public class Inventory<T> {
	
	private int balance;
	
	private Map<Bill, Integer> inventory = new HashMap<>();

	public int getQuantity(Bill bill) {
		Integer value = inventory.get(bill);
		return value == null ? 0 : value;
	}

	public void add(Bill bill, int number) {
		int count = inventory.get(bill) + number;
		inventory.put(bill, count);
		this.balance = this.balance + (bill.getDenomination() * number);
	}

	public void deduct(Bill bill, int number) {
		if (hasbill(bill)) {
			int count = inventory.get(bill) - number;
			inventory.put(bill, count);
			this.balance = this.balance - (bill.getDenomination() * number);
		}
	}

	public boolean hasbill(Bill bill) {
		return getQuantity(bill) > 0;
	}

	public void clear() {
		inventory.clear();
	}

	public void put(Bill bill, int quantity) { 
		inventory.put(bill, quantity); 
		this.balance = this.balance + (bill.getDenomination() * quantity);
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
}