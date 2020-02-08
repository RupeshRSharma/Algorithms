/**
 * 
 */
package com.intelizest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author rupes
 *
 */
public class Test9 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] a = { 1, 2, 2 };
		int[] b = { 2, 3 };
		int[][] query = { { 1, 4 }, { 0, 0, 3 }, { 1, 5 } };
		List<Integer> list = new ArrayList<>();
		int count = 0;
		
		for (int k = 0; k < query.length; k++) {

			if (query[k].length == 2) {
				for (int i = 0; i < a.length; i++) {

					for (int j = 0; j < b.length; j++) {

						if (a[i] + b[j] == query[k][1]) {
							count++;
						}

					}

				}

				list.add(count);
				count = 0;
				
			} else if (query[k].length == 3) {
				b[query[k][1]] = query[k][2];
			} 
		}
		
		System.out.println(Arrays.toString(list.stream().mapToInt(i->i).toArray()));

		/*
		 * 
		 * String number = "060000000"; int k = 4, index = 0; List<String> list = new
		 * ArrayList<>(); String str = number; while (true) { index=0; if (k >=
		 * number.length()) { list.add(number); break; }
		 * 
		 * 
		 * if (index + k > number.length()) { if (index < number.length()) {
		 * 
		 * list.add(number.substring(index)); } break; }
		 * 
		 * 
		 * while (true) {
		 * 
		 * if (str.startsWith("0")) { index += 1;
		 * 
		 * if(str.length()>index)str=str.substring(index); System.out.println(str); }
		 * else { break; } }
		 * 
		 * if(index + k >= str.length()) {
		 * System.out.println("aas"+index+str.substring(index));
		 * list.add(str.substring(index)); break; }
		 * System.out.println(index+str.substring(index, index+k));
		 * list.add(str.substring(index, index + k)); str = str.substring(index);
		 * //index += k;
		 * 
		 * }
		 * 
		 * String str2[] = new String[list.size()];
		 * 
		 * // ArrayList to Array Conversion for (int j = 0; j < list.size(); j++) {
		 * 
		 * // Assign each value to String array str2[j] = list.get(j); }
		 * 
		 * System.out.println(Arrays.toString(str2));
		 * 
		 * 
		 * int[] digits = {1,9,9}; int[] newdigits = null; int size = digits.length-1;
		 * 
		 * while(true) { if(digits[size]==9) {
		 * 
		 * digits[size]=0; if(size==0) { newdigits=new int[digits.length+1];
		 * newdigits[0]=1; for(int i=1; i< newdigits.length; i++) { newdigits[i]=0; }
		 * break; }else { size--; }
		 * 
		 * 
		 * }else { digits[size] = digits[size]+1; newdigits = digits; break; } }
		 * 
		 * System.out.println(Arrays.toString(newdigits));
		 * 
		 * 
		 */}

}
