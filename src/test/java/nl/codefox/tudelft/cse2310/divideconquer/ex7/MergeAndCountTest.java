package nl.codefox.tudelft.cse2310.divideconquer.ex7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class MergeAndCountTest {
	
	@Test
	@Timeout(100)
	public void countInversions() {
		int[] input = {2, 1, 0, 8};
		Assertions.assertEquals(3, Solution.countInversions(input));
	}
	
}

class Solution extends MergeAndCount {
	
	public static int countInversions(int[] array) {
		return MergeAndCount.countInversions(array);
	}
	
}