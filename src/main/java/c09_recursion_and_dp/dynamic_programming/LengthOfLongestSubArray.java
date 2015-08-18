package c09_recursion_and_dp.dynamic_programming;

public class LengthOfLongestSubArray {

	static int lengthOfLongestSubArray(int[] array) {
		int[] length = new int[array.length];
		int max = 0;
		length[0] = 1; // Length of first element
		for (int i = 1; i < array.length; i++) {
			if (array[i] > array[i - 1]) {
				length[i] = length[i - 1] + 1;
			} else {
				length[i] = 1;
			}
			if (max < length[i])
				max = length[i];
		}

		return max;
	}

	public static void main(String[] args) {
		int[] array = { 2, 4, 5, 9, 10, 11, 12, 13, 14, 15, 4, 5, 2, 1, 2, 3,
				4, 5, 6, 7, 9 };

		System.out.println(lengthOfLongestSubArray(array));

	}
}
