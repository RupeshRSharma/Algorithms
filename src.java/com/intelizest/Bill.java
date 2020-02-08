/**
 * 
 */
package com.intelizest;

/**
 * @author rupesh sharma
 *
 */
public enum Bill {
	
	ONE(1), FIVE(5), TEN(10), TWENTY(20);

	private int denomination;

	private Bill(int denomination) {
		this.denomination = denomination;
	}

	public int getDenomination() {
		return denomination;
	}
	
	public static Bill valueOf(int denomination) {
        for (Bill bill : Bill.values()) {
            if (bill.denomination == denomination) {
                return bill;
            }
        }
        return null;
    }
}
