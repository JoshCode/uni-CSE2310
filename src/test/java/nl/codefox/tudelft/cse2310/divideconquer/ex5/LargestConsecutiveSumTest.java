package nl.codefox.tudelft.cse2310.divideconquer.ex5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LargestConsecutiveSumTest {
	
	@Test
	public void testExampleA() {
		int[] input = new int[]{2, -3, 2, 1};
		Assertions.assertEquals(3, Solution.largestSum(input));
	}
	
	@Test
	public void testExampleB() {
		int[] input = new int[]{3, -3, -2, 42, -11, 2, 4, 4};
		Assertions.assertEquals(42, Solution.largestSum(input));
	}
	
}

class Solution extends LargestConsecutiveSum {
	
	public static int largestSum(int[] arr) {
		return LargestConsecutiveSum.largestSum(arr);
	}
	
}