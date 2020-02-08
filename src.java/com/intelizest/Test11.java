package com.intelizest;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

class Test11 {

	public static int solution(int[] A) {
		// write your code in Java SE 8

		List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());

		SortedSet set = new TreeSet(list);

		Iterator iterator = set.iterator();

		int count = 1;
		while (iterator.hasNext()) {

			if ((int)iterator.next() == count) {
				count++;
			} else {
				break;
			}

		}

		return count;

	}

	public static void main(String args[]) {

		int[] A = { 1, 2, 3,8,1,5,4 };

		System.out.println(solution(A));

	}
}
