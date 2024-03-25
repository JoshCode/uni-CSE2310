package nl.codefox.tudelft.cse2310.divideconquer.ex3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

class FindMinimumTest {
	
	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
	public void testExample() {
		Equation eq1 = new QuadraticEquation(0, 8, -240);
		Equation eq2 = new QuadraticEquation(0, 6, -156);
		Assertions.assertEquals(42, Solution.findMin(eq1, eq2, 0, 100));
	}
	
}

class Solution extends FindMinimum {
	
	public static long findMin(Equation e1, Equation e2, long low, long high) {
		return FindMinimum.findMin(e1, e2, low, high);
	}
	
}