package nl.codefox.tudelft.cse2310.divideconquer.ex5;

public class LargestConsecutiveSum {
	
	public static int largestSum(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		return largestSum(arr, 0, arr.length - 1);
	}
	
	public static int largestSum(int[] arr, int low, int high) {
		if (low == high) {
			return arr[low];
		}
		int mid = (low + high) / 2;
		// Find largest sum with elements from left side
		// Note that we iterate starting from mid
		int temp = 0;
		int leftSum = Integer.MIN_VALUE;
		for (int i = 0; i <= mid; i++) {
			temp += arr[i];
			if (temp > leftSum) {
				leftSum = temp;
			}
		}
		// Find largest sum with elements from right side
		// Note that we iterate starting from mid
		temp = 0;
		int rightSum = Integer.MIN_VALUE;
		for (int i = mid + 1; i <= high; i++) {
			temp += arr[i];
			if (temp > rightSum) {
				rightSum = temp;
			}
		}
		// A lot of max, in general takes the max of:
		// 1. The largest sequence in left side
		// 2. The largest sequence in right side
		// 3. The largest sequence spanning both left and right
		return Math.max(Math.max(largestSum(arr, low, mid), largestSum(arr, mid + 1, high)), leftSum + rightSum);
	}
	
}
