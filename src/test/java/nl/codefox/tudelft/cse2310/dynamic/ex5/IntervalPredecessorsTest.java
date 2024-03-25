package nl.codefox.tudelft.cse2310.dynamic.ex5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

class IntervalPredecessorsTest {
	
	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
	public void example() {
		int[] s = { 0, 0, 1, 3 };
		int[] f = { 0, 3, 4, 8 };
		int[] v = { 0, 3, 5, 7 };
		int[] p = { 0, -1, -1, 1 };
		int[] solution = Solution.solve(3, s, f, v);
		solution[0] = 0;
		Assertions.assertArrayEquals(p, solution);
	}
	
//	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
	public void example2() {
		int[] s = { 0, 0, 1, 4, 3 };
		int[] f = { 0, 3, 4, 8, 8 };
		int[] v = { 0, 3, 5, 7, 7 };
		int[] p = { 0, -1, -1, 1, 1 };
		int[] solution = Solution.solve(4, s, f, v);
		solution[0] = 0;
		Assertions.assertArrayEquals(p, solution);
	}

}