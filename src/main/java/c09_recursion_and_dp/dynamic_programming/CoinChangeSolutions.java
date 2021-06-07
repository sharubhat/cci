package c09_recursion_and_dp.dynamic_programming;

import java.util.ArrayList;

/**
 * http://www.codeproject.com/Articles/31002/Coin-Change-Problem-Using-Dynamic-Programming
 * 
 * Coin change is the problem of finding the number of ways to make change for a
 * target amount given a set of denominations. It is assumed that there is an
 * unlimited supply of coins for each denomination. An example will be finding
 * change for target amount 4 using change of 1,2,3 for which the solutions are
 * (1,1,1,1), (2,2), (1,1,2), (1,3). As you can see, the optimal solution can be
 * (2,2) or (1,3).
 * 
 * 
 */

class CoinChangeAnswer {
	public int OPT[][]; // contains the optimal solution
	// during every recurrence step.
	public String optimalChange[][]; // string representation of optimal
										// solutions.

	/**
	 * List of all possible solutions for the target
	 */
	public ArrayList<String> allPossibleChanges = new ArrayList<String>();

	/**
	 * The target amount.
	 */
	private int target;

	public int count;

	/**
	 * Copy of the denominations that was used to generate this solution
	 */
	public int[] denoms;

	public CoinChangeAnswer(int target, int[] denoms) {
		this.target = target;
		this.denoms = denoms;
		optimalChange = new String[denoms.length][target + 1];
		OPT = new int[denoms.length][target + 1];
	}

	public void printAllPossibleCombos() {
		if (allPossibleChanges.size() > 0) {
			System.out.println("All possible change(s) Target=" + target
					+ ", Denominations=" + denomString());
			int i = 1;
			for (String s : allPossibleChanges) {
				System.out.println(i + ") " + s);
				i++;
			}
			System.out.println();
		} else {
			System.out.println("No change for target=" + target
					+ ", Denominations=" + denomString());
		}

	}

	public String denomString() {
		StringBuilder sb = new StringBuilder();
		for (int i : denoms) {
			sb.append(i + " ");
		}
		return sb.toString();
	}

	public String getOptimalChange() {
		int i = optimalChange.length;
		int j = optimalChange[0].length;
		String str = "Optimal solution for Target=" + target
				+ ", Denominations=" + denomString() + " is ("
				+ optimalChange[i - 1][j - 1].trim() + ")";
		return str;
	}
}

public class CoinChangeSolutions {

	private void findAllCombinationsRecursive(String tsoln, int startIx,
			int remainingTarget, CoinChangeAnswer soln) {

		for (int i = startIx; i < soln.denoms.length; i++) {
			int temp = remainingTarget - soln.denoms[i];
			String tmpSol = tsoln + "" + soln.denoms[i] + ",";

			if (temp < 0)
				return;
			else if (temp == 0) {
				// reached the answer hence quit from the loop
				soln.allPossibleChanges.add(tmpSol);
				soln.count++;
				return;
			} else {
				findAllCombinationsRecursive(tmpSol, i, temp, soln);
			}
		}

	}

	public CoinChangeAnswer findAllPossibleCombinations(int target, int[] denoms) {
		CoinChangeAnswer soln = new CoinChangeAnswer(target, denoms);
		findAllCombinationsRecursive("", 0, target, soln);
		return soln;
	}

	public CoinChangeAnswer findOptimalChange(int target, int[] denoms) {
		CoinChangeAnswer soln = new CoinChangeAnswer(target, denoms);
		StringBuilder sb = new StringBuilder();

		// initialize the solution structure
		for (int i = 0; i < soln.OPT[0].length; i++) {
			soln.OPT[0][i] = i;
			soln.optimalChange[0][i] = sb.toString();
			sb.append(denoms[0] + " ");
		}

		// Read through the following for more details on the explanation
		// of the algorithm.
		// http://condor.depaul.edu/~rjohnson/algorithm/coins.pdf
		for (int i = 1; i < denoms.length; i++) {
			for (int j = 0; j < target + 1; j++) {
				int value = j;
				int targetWithPrevDenomiation = soln.OPT[i - 1][j];
				int ix = (value) - denoms[i];
				if (ix >= 0 && (denoms[i] <= value)) {
					int x2 = denoms[i] + soln.OPT[i][ix];
					if (x2 <= target
							&& (1 + soln.OPT[i][ix] < targetWithPrevDenomiation)) {
						String temp = soln.optimalChange[i][ix] + denoms[i]
								+ " ";
						soln.optimalChange[i][j] = temp;
						soln.OPT[i][j] = 1 + soln.OPT[i][ix];
					} else {
						soln.optimalChange[i][j] = soln.optimalChange[i - 1][j]
								+ " ";
						soln.OPT[i][j] = targetWithPrevDenomiation;
					}
				} else {
					soln.optimalChange[i][j] = soln.optimalChange[i - 1][j];
					soln.OPT[i][j] = targetWithPrevDenomiation;
				}
			}
		}

		return soln;
	}

	public static void main(String[] args) {
		CoinChangeSolutions ch = new CoinChangeSolutions();

		// target is 15 and change is 1,6,7
		CoinChangeAnswer soln = ch.findAllPossibleCombinations(15, new int[] {
				1, 6, 7 });
		soln.printAllPossibleCombos();
		System.out.println("Number of ways possible : " + soln.count + "\n");

		// example 2
		soln = ch.findAllPossibleCombinations(4, new int[] { 1, 2, 3 });
		soln.printAllPossibleCombos();
		System.out.println("Number of ways possible : " + soln.count + "\n");

		// example 3
		soln = ch.findAllPossibleCombinations(15, new int[] { 1, 3, 5, 10 });
		soln.printAllPossibleCombos();
		System.out.println("Number of ways possible : " + soln.count + "\n");

		// example 4
		soln = ch.findAllPossibleCombinations(15, new int[] { 3, 4 });
		soln.printAllPossibleCombos();
		System.out.println("Number of ways possible : " + soln.count + "\n");

		// optimal solution for target=15
		// soln = ch.findOptimalChange(15, new int[] {1,5,3,10});
		soln = ch.findOptimalChange(15, new int[] { 3, 4 });
		// soln = ch.findOptimalChange(4, new int[] { 1, 2, 3 });
		System.out.println(soln.getOptimalChange());
	}
}
