package c09_recursion_and_dp.dynamic_programming;

/**
 *  * 
 * 
 * http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
 * 
 * Given a value N, if we want to make change for N cents, and we have infinite
 * supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we
 * make the change? The order of coins doesn't matter.
 * 
 * For example, for N = 4 and S = {1,2,3}, there are four solutions:
 * {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S = {2,
 * 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5}
 * and {5,5}. So the output should be 5.
 */

public class CoinChangeNumWays {

	public static void main(String[] args) {
		int arr[] = {1, 2, 3};
	    System.out.println("Number of ways : " + count(arr, arr.length, 4));
	    System.out.println("Number of ways : " + countDP(arr, arr.length, 4));
	}
	
	// Returns the count of ways we can sum  C[0...length-1] coins to get sum n
	static int count(int[] C, int length, int sum) {
		// If sum is 0 then there is 1 solution (do not include any coin)
	    if (sum == 0)
	        return 1;
	     
	    // If sum is less than 0 then no solution exists
	    if (sum < 0)
	        return 0;
	 
	    // If there are no coins and sum is greater than 0, then no solution exist
	    if (length <=0 && sum > 0)
	        return 0;
	 
	    // count is sum of solutions (i) including C[length-1] (ii) excluding C[length-1]
	    return count( C, length - 1, sum ) + count( C, length, sum-C[length-1] );
	}
	
	//Time Complexity: O(mn)
	//Following is a simplified version of method 2. The auxiliary space required here is O(n) only.
	
	static int countDP( int C[], int length, int sum )
	{
	    // table[i] will be storing the number of solutions for
	    // value i. We need n+1 rows as the table is consturcted
	    // in bottom up manner using the base case (n = 0)
	    int[] table = new int[sum+1];
	 
	    // Base case (If given value is 0)
	    table[0] = 1;
	 
	    // Pick all coins one by one and update the table[] values
	    // after the index greater than or equal to the value of the
	    // picked coin
	    for(int i=0; i<length; i++)
	        for(int j=C[i]; j<=sum; j++)
	            table[j] += table[j-C[i]];
	 
	    return table[sum];
	}
}
