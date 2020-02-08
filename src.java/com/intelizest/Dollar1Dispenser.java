/**
 * 
 */
package com.intelizest;

/**
 * @author rupesh sharma
 *
 */

public class Dollar1Dispenser implements DispenseChain {

	private DispenseChain chain;
	
	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
	}

	@Override
	public void dispense(Currency cur, Inventory<Bill> inventory) {
		if(cur.getAmount() >= 1){
			int num = cur.getAmount()/1;
			int remainder = cur.getAmount() % 1;
			//System.out.println("Dispensing "+num+" 1$ note");
			int quantity = inventory.getQuantity(Bill.ONE);
			if(num > quantity) {
				remainder = remainder + num - quantity;
				inventory.deduct(Bill.ONE, quantity);
				System.out.println("Dispensing "+quantity+" 1$ note");
			}else {
				inventory.deduct(Bill.ONE, num);
				System.out.println("Dispensing "+num+" 1$ note");
			}
			//System.out.println("Remaining "+inventory.getQuantity(Bill.ONE)+" 1$ note");
			if(remainder !=0) this.chain.dispense(new Currency(remainder), inventory);
		}else{
			this.chain.dispense(cur, inventory);
		}
	}

}

