package nl.codefox.tudelft.cse2310.greedy.ex8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

class AssigningWorkstationsTest {
	
	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
	public void example() {
		int[] start = {0, 2, 1, 17, 3, 15};
		int[] duration = {0, 6, 2, 7, 9, 6};
		int m = 10;
		int expected = 3;
		int n = start.length - 1;
		Assertions.assertEquals(expected, AssigningWorkstations.solve(n, m, start, duration));
	}
	
	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
	public void test1() {
		int[] start = {0, 1};
		int[] duration = {0, 10};
		int m = 10;
		int expected = 0;
		int n = start.length - 1;
		Assertions.assertEquals(expected, AssigningWorkstations.solve(n, m, start, duration));
	}
	
	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
	public void test2() {
		int[] start = {0, 5, 1};
		int[] duration = {0, 10, 1};
		int m = 10;
		int expected = 1;
		int n = start.length - 1;
		Assertions.assertEquals(expected, AssigningWorkstations.solve(n, m, start, duration));
	}
	
	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
	public void test3() {
		int[] start = {0, 5, 1};
		int[] duration = {0, 10, 10};
		int m = 10;
		int expected = 0;
		int n = start.length - 1;
		Assertions.assertEquals(expected, AssigningWorkstations.solve(n, m, start, duration));
	}
	
	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
	public void test4() {
		int[] start = {0, 5, 1, 100};
		int[] duration = {0, 10, 10, 1};
		int m = 10;
		int expected = 0;
		int n = start.length - 1;
		Assertions.assertEquals(expected, AssigningWorkstations.solve(n, m, start, duration));
	}
	
}