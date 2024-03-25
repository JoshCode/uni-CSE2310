package nl.codefox.tudelft.cse2310.dynamic.ex9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class KnapsackTest {
	
	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
	public void example() {
		int n = 3;
		int W = 10;
		int[] w = { 0, 8, 3, 5 };
		int[] v = { 0, 8, 4, 9 };
		Assertions.assertEquals(13, Solution.mathijsFavouriteProblem(n, W, w, v));
	}

}