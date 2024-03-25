package nl.codefox.tudelft.cse2310.divideconquer.ex8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class PartialSumsTest {
	
	@Test
	public void testExampleA() {
		Integer[] arr = new Integer[]{1, 2};
		Set<Integer> res = Solution.partialSums(arr);
		Set<Integer> expected = new HashSet<>(Arrays.asList(0, 1, 2, 3));
		Assertions.assertEquals(expected, res);
	}
	
	@Test
	public void testExampleB() {
		Integer[] arr = new Integer[]{1, 2, 3, 4};
		Set<Integer> res = Solution.partialSums(arr);
		Set<Integer> expected = new HashSet<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		Assertions.assertEquals(expected, res);
	}
	
	@Test
	public void testEmpty() {
		Integer[] arr = new Integer[]{};
		Set<Integer> res = Solution.partialSums(arr);
		Set<Integer> expected = new HashSet<>(Collections.singletonList(0));
		Assertions.assertEquals(expected, res);
	}
	
}

class Solution extends PartialSums {}