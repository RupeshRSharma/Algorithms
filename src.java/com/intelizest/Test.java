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
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] a = { 1, 2, 4 };
		int[] b = { 3, 4 };
		int[][] query;

		
		
		/**
		 *  select t2.flight_id, (t2.number_of_seats - ifnull(t1.seats_filled,0)) as free_seats
    from (select flight_id, count(seat_no) as seats_filled from purchases group by flight_id) as t1 right join
    (select fl.flight_id, pl.number_of_seats from flights fl, planes pl where fl.plane_id = pl.plane_id) as t2
     on t2.flight_id=t1.flight_id order by t2.flight_id;
		 */

		String number = "060000000";
		int k = 4, index = 0;
		List<String> list = new ArrayList<>();
		String str = number;
		while (true) {
			index = 0;
			if (k >= number.length()) {
				list.add(number);
				break;
			}

			if (index + k > number.length()) {
				if (index < number.length()) {

					list.add(number.substring(index));
				}
				break;
			}

			while (true) {

				if (str.startsWith("0")) {
					index += 1;

					if (str.length() > index)
						str = str.substring(index);
					System.out.println(str);
				} else {
					break;
				}
			}

			if (index + k >= str.length()) {
				System.out.println("aas" + index + str.substring(index));
				list.add(str.substring(index));
				break;
			}
			System.out.println(index + str.substring(index, index + k));
			list.add(str.substring(index, index + k));
			str = str.substring(index);
			// index += k;

		}

		String str2[] = new String[list.size()];

		// ArrayList to Array Conversion for (int j = 0; j < list.size(); j++) {

		// Assign each value to String array str2[j] = list.get(j); }

		System.out.println(Arrays.toString(str2));

		int[] digits = { 1, 9, 9 };
		int[] newdigits = null;
		int size = digits.length - 1;

		while (true) {
			if (digits[size] == 9) {

				digits[size] = 0;
				if (size == 0) {
					newdigits = new int[digits.length + 1];
					newdigits[0] = 1;
					for (int i = 1; i < newdigits.length; i++) {
						newdigits[i] = 0;
					}
					break;
				} else {
					size--;
				}

			} else {
				digits[size] = digits[size] + 1;
				newdigits = digits;
				break;
			}
		}

		System.out.println(Arrays.toString(newdigits));

	}

}
