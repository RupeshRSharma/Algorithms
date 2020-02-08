/**
 * 
 */
package com.intelizest;

/**
 * @author rupesh sharma
 *
 */

public class Dollar10Dispenser implements DispenseChain {

	private DispenseChain chain;
	
	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
	}

	@Override
	public void dispense(Currency cur, Inventory<Bill> inventory) {
		if(cur.getAmount() >= 10){
			int num = cur.getAmount()/10;
			int remainder = cur.getAmount() % 10;
			//System.out.println("Dispensing "+num+" 10$ note");
			int quantity = inventory.getQuantity(Bill.TEN);
			if(num > quantity) {
				remainder = remainder + ((num - quantity) * 10 );
				inventory.deduct(Bill.TEN, quantity);
				System.out.println("Dispensing "+quantity+" 10$ note");
			}else {
				inventory.deduct(Bill.TEN, num);
				System.out.println("Dispensing "+num+" 10$ note");
			}
			//System.out.println("Remaining "+inventory.getQuantity(Bill.TEN)+" 10$ note");
			if(remainder !=0) this.chain.dispense(new Currency(remainder), inventory);
		}else{
			this.chain.dispense(cur, inventory);
		}
	}

}

