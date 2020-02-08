/**
 * 
 */
package com.intelizest;

/**
 * @author rupesh sharma
 *
 */

public class Dollar5Dispenser implements DispenseChain {

	private DispenseChain chain;
	
	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
	}

	@Override
	public void dispense(Currency cur, Inventory<Bill> inventory) {
		if(cur.getAmount() >= 5){
			int num = cur.getAmount()/5;
			int remainder = cur.getAmount() % 5;
			//System.out.println("Dispensing "+num+" 5$ note");
			int quantity = inventory.getQuantity(Bill.FIVE);
			if(num > quantity) {
				remainder = remainder + ((num - quantity) * 5);
				inventory.deduct(Bill.FIVE, quantity);
				System.out.println("Dispensing "+quantity+" 5$ note");
			}else {
				inventory.deduct(Bill.FIVE, num);
				System.out.println("Dispensing "+num+" 5$ note");
			}
			//System.out.println("Remaining "+inventory.getQuantity(Bill.FIVE)+" 5$ note");
			if(remainder !=0) this.chain.dispense(new Currency(remainder), inventory);
		}else{
			this.chain.dispense(cur, inventory);
		}
	}

}

