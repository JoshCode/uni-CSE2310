package nl.codefox.tudelft.cse2310.dynamic.ex3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

class IterativeTest {
	
	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
	public void example() {
		int n = 7;
		int[] nodes = {0, 1, 18, 18, 1, 18, 18, 1};
		Assertions.assertEquals(3, Solution.solve(n, nodes));
	}
	
}