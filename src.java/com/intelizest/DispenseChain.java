/**
 * 
 */
package com.intelizest;

/**
 * @author rupesh sharma
 *
 */

public interface DispenseChain {

	void setNextChain(DispenseChain nextChain);
	
	void dispense(Currency cur, Inventory<Bill> inventory);
}

