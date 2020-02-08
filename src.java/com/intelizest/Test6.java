package com.intelizest;

public class Test6 {

	public static void main(String[] args) {
		int[] coins = { 2,6 };
		int count = 0;

		for (int i = 0; i < coins.length; i++) {
			count = count + Count(12, coins, i, 0);
		}
		System.out.println(count);
	}

	public static int Count(int Sum, int[] coins, int index, int curSum) {
		int count = 0;

		if (index >= coins.length)
			return 0;

		int sumNow = curSum + coins[index];
		if (sumNow > Sum)
			return 0;
		if (sumNow == Sum)
			return 1;

		for (int i = index + 1; i < coins.length; i++)
			count += Count(Sum, coins, i, sumNow);

		return count;
	}

}
