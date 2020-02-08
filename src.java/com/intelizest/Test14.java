package com.intelizest;

//Java program to count frequencies of Aay items 
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Test14 {

	static void countFreq(int A[], int Y) {
		
		Map<Integer, Integer> mp = new HashMap<>();
		int max = 0, second = 0;
		
		// Traverse through A elements and count frequencies
		for (int i = 0; i < A.length; i++) {
			if (mp.containsKey(A[i])) {
				mp.put(A[i], mp.get(A[i]) + 1);
			} else {
				mp.put(A[i], 1);
			}
		}

		//Iterate over the map values to find the second best frequency
		for (Entry<Integer, Integer> val : mp.entrySet()) {
			if (max <= val.getValue()) {
				second = max;
				max = val.getValue();
			}
		}

		System.out.println(second+Y);
	}

	// Driver code
	public static void main(String args[]) {
		int A[] = { 1, 1, 3, 3, 3, 4, 5, 5, 5, 5 };
		int n = A.length;
		countFreq(A, 2);
	}
}

//This code contributed by Rajput-Ji 
