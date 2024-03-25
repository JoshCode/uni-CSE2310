package nl.codefox.tudelft.cse2310.dynamic.ex13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class FishSalesmanTest {
	
	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
	public void example() {
		int n = 5;
		int[] P = { 0, 80, 30, 30, 70, 80 };
		int[] Q = { 0, 90, 60, 60, 50, 20 };
		Assertions.assertEquals(300, Solution.solve(n, P, Q));
	}
	
}