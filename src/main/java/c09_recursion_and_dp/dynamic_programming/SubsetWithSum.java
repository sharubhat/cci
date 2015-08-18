package c09_recursion_and_dp.dynamic_programming;

//Not working code
public class SubsetWithSum {

	static int[][] answer  = new int[20][20];
	static int prev[][] = new int[20][20];

	public static void main(String[] args) {
		int[] input = { 8, 4, 7, 2, 1 };

		int sum = 11;

		SubsetWithSum s = new SubsetWithSum();

		s.subArrays(input, 0, input.length, sum);
		s.printArray(prev);
		System.out.println("Answer");
		s.printArray(answer);

	}

	public boolean subArrays(int[] a, int i, int j, int s) {
		//http://simple-programming.quora.com/Dynamic-Programming-Subset-Sum-Problem
		if (answer[i][j] != 0)
			return true;
		else {
			if (s == 0) {
				answer[i][j] = 1;
				return true;
			}
			if(i == j) {
				if(a[i] == s) {
					answer[i][j] = 1;
					return true;
				}
				else {
					return false;
				}
			}
			else {
				for(int k = 0; k <= j ;) {
					if(subArrays(a, k+1, j, s-a[k])) {
						prev[k+1][j] = 1;
						answer[i][j] = 1;
						return true;
					}
					else if(subArrays(a, k+1, j, s)) {
						prev[k+1][j] = 1;
						answer[i][j] = 1;
						return true;
					}
					else
						return false;
				}
			}
			return false;
		}
	}

	public int[][] subsets(int[] a) {
		int S = 0;
		int N = a.length;
		for (int i = 0; i < N; i++) {
			S += a[i];
		}
		S = S / 2;

		int[][] dp = new int[N][S + 1];

		dp[0][0] = 1;

		for (int j = 0; j <= S; j++) {
			if (j >= a[0])
				dp[0][j] = 1;
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; j <= S; j++) {
				dp[i][j] = dp[i - 1][j];
				if (j >= a[i])
					dp[i][j] += dp[i - 1][j - a[i]];
			}
		}

		System.out.println(dp[N - 1][S]);

		return dp;

	}

	private void printArray(int[][] a) {
		int ROWS = a.length;
		int COLS = a[0].length;
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				System.out.print(" " + a[i][j]);
			}
			System.out.println("");
		}
	}

}
