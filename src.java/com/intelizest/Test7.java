package com.intelizest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test7 {

	public static void main(String[] args) throws IOException {

		//String line = "(2,5),12";

		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
	    BufferedReader in = new BufferedReader(reader);
	    String line = in.readLine();
		/*
		 * while ((line = in.readLine()) != null) { //System.out.println(line); }
		 */
		
		line = line.replace("(", "");
		line = line.replace(")", "");
		String[] arr = line.split(",");
		Integer[] intarr = new Integer[arr.length - 1];
		for (int i = 0; i < arr.length - 1; i++) {
			intarr[i] = Integer.parseInt(arr[i]);
		}

		ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(intarr));

		Combinations combinations = new Combinations(numbers, Integer.parseInt(arr[arr.length - 1].trim()));
		combinations.calculateCombinations();

		Collections.sort(combinations.getCombinations(), new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return Integer.valueOf(a[0]).compareTo(Integer.valueOf(b[0]));
			}
		});

		for (int[] solution : combinations.getCombinations()) {
			System.out.print(Arrays.toString(solution).replaceAll(" ", ""));
		}

	}

	public static class Combinations {

		private int[] repetitions;
		private ArrayList<Integer> numbers;
		private Integer target;
		private Integer sum;
		private boolean hasNext;
		private List<int[]> combinations;

		/**
		 * Constructor.
		 *
		 * @param numbers Numbers that can be used to calculate the sum.
		 * @param target  Target value for sum.
		 */
		public Combinations(ArrayList<Integer> numbers, Integer target) {

			Set<Integer> numbersSet = new HashSet<>(numbers);
			this.numbers = new ArrayList<>(numbersSet);

			this.numbers.removeAll(Arrays.asList(0));
			Collections.sort(this.numbers);

			this.target = target;
			this.repetitions = new int[this.numbers.size()];
			this.combinations = new ArrayList<>();

			this.sum = 0;
			if (this.repetitions.length > 0)
				this.hasNext = true;
			else
				this.hasNext = false;
		}

		/**
		 * Calculate and return the sum of the current combination.
		 *
		 * @return The sum.
		 */
		private Integer calculateSum() {
			this.sum = 0;
			for (int i = 0; i < repetitions.length; ++i) {
				this.sum += repetitions[i] * numbers.get(i);
			}
			return this.sum;
		}

		/**
		 * Get the sum of the next combination. When 0 is returned, there's no other
		 * combinations to check.
		 *
		 * @return The sum.
		 */
		private Integer next() {
			if (this.hasNext && this.repetitions.length > 0) {
				this.repetitions[0] += 1;

				this.calculateSum();

				for (int i = 0; i < this.repetitions.length && this.sum != 0; ++i) {
					if (this.sum > this.target) {
						this.repetitions[i] = 0;
						if (i + 1 < this.repetitions.length) {
							this.repetitions[i + 1] += 1;

						}
						this.calculateSum();
					}
				}

				if (this.sum.compareTo(0) == 0) {
					this.hasNext = false;
				}
			}
			return this.sum;
		}

		/**
		 * Calculate all combinations whose sum equals target.
		 */
		public void calculateCombinations() {
			while (this.hasNext) {
				Integer next = this.next();
				if (next.compareTo(target) == 0) {
					this.combinations.add(this.toStrings());
				}
			}
		}

		/**
		 * Return all combinations whose sum equals target.
		 *
		 * @return Combinations as a set of strings.
		 */
		public List<int[]> getCombinations() {
			return this.combinations;
		}

		public int[] toStrings() {
			int[] arr = new int[this.numbers.size()];
			for (int i = 0; i < repetitions.length; ++i) {
				for (int j = 0; j < repetitions[i]; ++j) {
					arr[i] = repetitions[i];
				}
			}

			return arr;
		}
	}

}
