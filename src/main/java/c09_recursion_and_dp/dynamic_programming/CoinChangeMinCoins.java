package c09_recursion_and_dp.dynamic_programming;

//Wrong solution

/**
 * http://www.topcoder.com/tc?d1=tutorials&d2=dynProg&module=Static
 * 
 * You are eventually finding minimum coins for all Sum from 1 to S
 * So, you need a Min array that can hold min coins up to S, so create Min[S+1]
 * Set Min[i] equal to Infinity for all of i except Min[0]
 * Start with having a solution of 0 coins for sum 0.
 * Min[0]=0 
 * For i = 1 to S 
 * 	For j = 0 to N - 1
 * 		If (C[j]<=i AND Min[i-C[j]]+1<Min[i])
 * 		Then Min[i]=Min[i-Vj]+1
 * Output Min[S]
 *
 */
public class CoinChangeMinCoins {
	
	/**
	 * Change(p)
	 * 1 if (p < 0)
	 * 2 then return ∞
	 * 3 elseif (p = 0)
	 * 4 then return 0
	 * 5 else
	 * 6 return 1 + min{Change(p − 1), Change(p − 5), Change(p − 10)}
	 */

	
	static long count(int[] C, int S) {
		long[] Min = new long[S + 1];
		for(int index = 1; index < Min.length; index ++) {
			Min[index] = Integer.MAX_VALUE;
		}
		for(int i = 1; i <= S; i++) {	// For every Sum 1 to S
			for(int j : C) {	//For every coin
				if(j <= i) {
					Min[i] = Math.min(Min[i], Min[i - j] + 1);
				}
			}
		}
		return Min[S] < Integer.MAX_VALUE ? Min[S] : 0;
	}
	
	public static void main(String[] args) {
		System.out.println("Num of coins " + count(new int[] { 3, 4 }, 15 ));
	}

}
