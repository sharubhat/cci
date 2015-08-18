package c09_recursion_and_dp.dynamic_programming;

import java.util.LinkedList;
import java.util.List;

public class LongestIncreasingSubSequence {

	static List<Integer> longestSequence(int[] list) {
		if (list == null || list.length == 0)
			return null;

		List<Integer> longest = new LinkedList<Integer>();
		List<Integer> current = new LinkedList<Integer>();
		for (int elem : list) {
			if (current.size() == 0) {
				current.add(elem);
			} else if (elem >= current.get(current.size()-1)) {
				current.add(elem);
			} else {
				if (current.size() > longest.size()) {
					longest = current;
				}
				current = new LinkedList<Integer>();
				current.add(elem);
			}
		}
		if (current.size() > longest.size()) {
			longest = current;
		}
		return longest;
	}

	public static void main(String[] args) {
		int[] array = { 2, 4, 5, 9, 10, 11, 12, 13, 14, 15, 4, 5, 2, 1, 2, 3,
				4, 5, 6, 7, 9 };

		System.out.println(longestSequence(array));

	}
}
