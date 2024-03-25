package nl.codefox.tudelft.cse2310.greedy.ex1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

class BetterAverageTest {
	
	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
	void solveTest() {
		int n = 4;
		double[] list = {4, 2, 1, 3};
		Assertions.assertEquals(2.5, BetterAverage.solve(n, list), 1e-3);
	}
	
}