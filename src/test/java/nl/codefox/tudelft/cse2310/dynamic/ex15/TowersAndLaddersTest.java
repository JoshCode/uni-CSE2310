package nl.codefox.tudelft.cse2310.dynamic.ex15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class TowersAndLaddersTest {
	
	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
	public void example() {
		int n = 2;
		int m = 3;
		int[][] graph = { { 3, 5, 6 }, { 4, 2, 1 } };
		Assertions.assertEquals(1, Solution.solve(n, m, graph));
	}
	
}