package nl.codefox.tudelft.cse2310.greedy.ex5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

class PackingTrucksTest {
	
	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
	public void example() {
		int n = 4;
		int[] weights = {0, 41, 29, 12, 26};
		int maxWeight = 48;
		Assertions.assertEquals(3, PackingTrucks.minAmountOfTrucks(n, weights, maxWeight));
	}
	
}