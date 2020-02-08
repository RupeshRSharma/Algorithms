package com.intelizest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test8 {

	public static void main(String[] args) {
		
		String number = "12045";
		int k = 2, index = 0;
		
		List<String> list = new ArrayList<>();
		
		char[] chars = number.toCharArray();
		
		int count = 0;
		StringBuilder str = new StringBuilder();
		for(int i=0; i<chars.length; i++) {
			
			if(count == k) {
				list.add(str.toString());
				str = new StringBuilder();
				count=0;
			}
			
			if((count == 0 && chars[i] != '0') || count != 0 || i == chars.length-1) {
				str.append(chars[i]);
				count++;
			}
			
			if( i == chars.length-1) {
				
				list.add(str.toString());
			}
			
			
		}
		
		String str2[] = new String[list.size()];

		// ArrayList to Array Conversion
		for (int j = 0; j < list.size(); j++) {

			// Assign each value to String array
			str2[j] = list.get(j);
		}

		System.out.println(Arrays.toString(str2));
		

	}

}
