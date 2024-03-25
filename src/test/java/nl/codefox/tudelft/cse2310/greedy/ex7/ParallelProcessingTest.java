package nl.codefox.tudelft.cse2310.greedy.ex7;

import nl.codefox.tudelft.cse2310.util.WebLab;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class ParallelProcessingTest {
	
	private static void runTestWithFile(String fileName) {
		Scanner sc = new Scanner(WebLab.getData(fileName + ".in"));
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] jobs = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			jobs[i] = sc.nextInt();
		}
		sc.close();
		int expected = Integer.parseInt(WebLab.getData(fileName + ".out"));
		Assertions.assertEquals(expected, ParallelProcessing.solve(n, m, jobs));
	}
	
	@Test
	@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
	public void example() {
		int n = 5;
		int m = 2;
		int[] deadlines = {0, 3, 1, 1, 1, 2};
		Assertions.assertEquals(1, ParallelProcessing.solve(n, m, deadlines));
	}
	
	@Test
	@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
	public void test1() {
		int m = 1;
		int[] deadlines = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int n = deadlines.length - 1;
		Assertions.assertEquals(0, ParallelProcessing.solve(n, m, deadlines));
	}
	
	@Test
	@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
	public void test2() {
		int[] deadlines = {0, 1, 1, 1, 1};
		int m = 2;
		int expectedLate = 1;
		
		int n = deadlines.length - 1;
		Assertions.assertEquals(expectedLate, ParallelProcessing.solve(n, m, deadlines));
	}
	
	@Test
	@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
	public void test3() {
		int[] deadlines = {0, 1, 1, 1, 1};
		int m = 4;
		int expectedLate = 0;
		
		int n = deadlines.length - 1;
		Assertions.assertEquals(expectedLate, ParallelProcessing.solve(n, m, deadlines));
	}
	
	@Test
	@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
	public void test4() {
		int[] deadlines = {0, 0, 1, 1, 1};
		int m = 10;
		int expectedLate = 1;
		
		int n = deadlines.length - 1;
		Assertions.assertEquals(expectedLate, ParallelProcessing.solve(n, m, deadlines));
	}
	
	@Test
	@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
	public void test5NoDeadlines() {
		int[] deadlines = {0};
		int m = 10;
		int expectedLate = 0;
		
		int n = deadlines.length - 1;
		Assertions.assertEquals(expectedLate, ParallelProcessing.solve(n, m, deadlines));
	}
	
	@Test
	@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
	public void test6NoProcessors() {
		int[] deadlines = {0, 1, 1};
		int m = 0;
		int expectedLate = 2;
		
		int n = deadlines.length - 1;
		Assertions.assertThrows(UnsupportedOperationException.class, () -> {
			ParallelProcessing.solve(n, m, deadlines);
		});
	}
	
	@Test
	@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
	public void test7AlwaysLate() {
		int[] deadlines = {0, 10, 0, 0, 10};
		int m = 4;
		int expectedLate = 1;
		
		int n = deadlines.length - 1;
		Assertions.assertEquals(expectedLate, ParallelProcessing.solve(n, m, deadlines));
	}
	
}