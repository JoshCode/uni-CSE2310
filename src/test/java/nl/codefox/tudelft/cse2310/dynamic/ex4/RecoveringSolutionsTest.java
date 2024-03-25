package nl.codefox.tudelft.cse2310.dynamic.ex4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.sql.Time;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class RecoveringSolutionsTest {
	
	public static int[] getResultArray(int n, int[] nodes) {
		if (n <= 2) {
			return nodes;
		}
		int[] mem = new int[n + 1];
		mem[0] = 0;
		mem[1] = nodes[1];
		mem[2] = nodes[2];
		for (int i = 3; i <= n; i++) {
			// Find node of max distance 3, that minimizes total weight.
			int result = nodes[i] + Integer.min(Integer.min(mem[i - 1], mem[i - 2]), mem[i - 3]);
			mem[i] = result;
		}
		return mem;
	}
	
	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
	public void example() {
		int n = 7;
		int[] nodes = { 0, 1, 18, 18, 1, 18, 18, 1 };
		int[] mem = { 0, 1, 18, 18, 2, 20, 20, 3 };
		int optValue = 3;
		List<Integer> result = Arrays.asList(1, 4, 7);
		Assertions.assertEquals(result, Solution.solve(n, nodes, optValue, mem));
	}

}