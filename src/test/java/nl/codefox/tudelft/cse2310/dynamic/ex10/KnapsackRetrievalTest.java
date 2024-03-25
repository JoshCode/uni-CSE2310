package nl.codefox.tudelft.cse2310.dynamic.ex10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class KnapsackRetrievalTest {
	
	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
	public void example() {
		int n = 3;
		int W = 10;
		int[] w = { 0, 8, 3, 5 };
		int[] v = { 0, 8, 4, 9 };
		int[][] mem = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 8, 8, 8 }, { 0, 0, 0, 4, 4, 4, 4, 4, 8, 8, 8 }, { 0, 0, 0, 4, 4, 9, 9, 9, 13, 13, 13 } };
		Assertions.assertEquals(List.of(2, 3), Solution.mathijsFavouriteProblem(n, W, w, v, mem));
	}

}