package com.intelizest;

import java.math.BigInteger;
import java.util.Arrays;

public class Test5 {

	private static BigInteger countChanges(int amount, int[] coins){
        final int n = coins.length;
        int cycle = 0;
        for (int c : coins)
            if (c <= amount && c >= cycle)
                cycle = c + 1;
        cycle *= n;
        BigInteger[] table = new BigInteger[cycle];
        Arrays.fill(table, 0, n, BigInteger.ONE);
        Arrays.fill(table, n, cycle, BigInteger.ZERO);
 
        int pos = n;
        for (int s = 1; s <= amount; s++) {
            for (int i = 0; i < n; i++) {
                if (i == 0 && pos >= cycle)
                    pos = 0;
                if (coins[i] <= s) {
                    final int q = pos - (coins[i] * n);
                    table[pos] = (q >= 0) ? table[q] : table[q + cycle];
                }
                if (i != 0)
                    table[pos] = table[pos].add(table[pos - 1]);
                pos++;
            }
        }
 
        System.out.println(Arrays.toString(table));
        
        return table[pos - 1];
    }
 
    public static void main(String[] args) {
        final int[][] coinsUsEu = {{2,6},
                                   {2,6}};
 
        for (int[] coins : coinsUsEu) {
            //System.out.println(countChanges(     100,
              //  Arrays.copyOfRange(coins, 2, coins.length)));
            System.out.println(countChanges(  12, coins));
            //System.out.println(countChanges( 1000000, coins));
            //System.out.println(countChanges(10000000, coins) + "\n");
        }
    }
	
}
