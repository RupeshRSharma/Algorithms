/**
 * 
 */
package com.intelizest;

/**
 * @author rupesh sharma
 *
 */

public class Dollar20Dispenser implements DispenseChain {

	private DispenseChain chain;
	
	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
	}

	@Override
	public void dispense(Currency cur, Inventory<Bill> inventory) {
		if(cur.getAmount() >= 20){
			int num = cur.getAmount()/20;
			int remainder = cur.getAmount() % 20;
			//System.out.println("Dispensing "+num+" 20$ note");
			int quantity = inventory.getQuantity(Bill.TWENTY);
			if(num > quantity) {
				remainder = remainder + ((num - quantity) * 20);
				inventory.deduct(Bill.TWENTY, quantity);
				System.out.println("Dispensing "+quantity+" 20$ note");
			}else {
				inventory.deduct(Bill.TWENTY, num);
				System.out.println("Dispensing "+num+" 20$ note");
			}
			//System.out.println("Remaining "+inventory.getQuantity(Bill.TWENTY)+" 20$ note");
			if(remainder !=0) this.chain.dispense(new Currency(remainder), inventory);
		}else{
			this.chain.dispense(cur, inventory);
		}
	}

}

