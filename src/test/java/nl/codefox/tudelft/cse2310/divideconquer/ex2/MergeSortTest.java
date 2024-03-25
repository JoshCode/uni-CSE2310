package nl.codefox.tudelft.cse2310.divideconquer.ex2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

class MergeSortTest {
	
	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
	public void example() {
		int[] input = {4, 2, 5, 1, 3};
		new Solution().sort(input);
		Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, input);
	}
	
}

class Solution extends MergeSort {
	public Solution() {
	}
	
	@Override
	public void sort(int[] arr) {
		super.sort(arr);
	}
}