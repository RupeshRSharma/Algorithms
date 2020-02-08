/**
 * 
 */
package com.intelizest;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author rupes
 *
 */
public class Test2 {

	static HashMap<Integer, Integer> mapCount = null;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		  String str = "(2,5),12";
		  
		  str = str.replace("(", ""); str = str.replace(")", ""); String[] arr =
		  str.split(","); System.out.println(Arrays.toString(arr));
		  Integer[] intarr = new Integer[arr.length-1];
		  for(int i=0; i<arr.length-1;i++) {
			  intarr[i]=Integer.parseInt(arr[i]);
		  }
		 
		
		int[] a = { 2,5 };
		int totalCoinSize = a.length;
		
		int number = Integer.parseInt("12");
		
		if (number <= 0) {
			System.out.println(" No minimum coin needed to reach sum");
		} else {
			mapCount = new HashMap<Integer, Integer>();
			minCoinToReachSum(a, totalCoinSize, number);
			System.out.println(mapCount);
		}
		
		
	}
	
	private static void minCoinToReachSum(int[] a, int totalCoinSize, int number) {
		for (int k = 0; k < totalCoinSize; k++) {
			System.out.println(number % a[k]);
			if (number >= a[k]) {
				if (number % a[k] >= 0) {
					int coinTotal = number/a[k];
					number = number % a[k];
					System.out.println(" number "+number);
					System.out.println(" coinTotal " + coinTotal);
					if (mapCount.containsKey(a[k])) {
						int totalCntFromMap = mapCount.get(a[k]);
						mapCount.put(a[k], totalCntFromMap + coinTotal);
					} else {
						mapCount.put(a[k], coinTotal);
					}
					minCoinToReachSum(a, totalCoinSize, number);
					break;
				}
			}
		}
	}

}
