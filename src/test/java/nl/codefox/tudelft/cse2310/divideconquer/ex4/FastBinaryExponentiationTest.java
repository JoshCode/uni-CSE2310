package nl.codefox.tudelft.cse2310.divideconquer.ex4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FastBinaryExponentiationTest {
	
	@Test
	public void testExampleA() {
		int[] a = new int[]{3, -2, 6};
		int[] b = new int[]{2, 5, 8};
		int[][] c = Solution.computeC(a, b);
		int[][] expected = new int[][]{{9, 243, 6561}, {4, -32, 256}, {36, 7776, 1679616}};
		Assertions.assertArrayEquals(expected, c);
	}
	
}

class Solution extends FastBinaryExponentiation {
	
	public static int[][] computeC(int[] a, int[] b) {
		return FastBinaryExponentiation.computeC(a, b);
	}
}