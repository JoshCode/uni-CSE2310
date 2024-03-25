package nl.codefox.tudelft.cse2310.dynamic.ex12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TightOnTimeTest {
	
	@Test
	public void testExampleA() {
		int n = 4;
		int h = 6;
		int[][] f = {{0, 0, 0, 0, 0, 0, 0}, {1, 1, 2, 3, 4, 4, 4}, {1, 6, 6, 6, 6, 6, 6}, {1, 2, 2, 2, 2, 2, 2}, {1, 1, 2, 3, 4, 7, 10}};
		// Spend 1 hour on the second assignment and 5 hours on the last assignment
		// Including the base grade for the remaining two assignments
		// 6 + 7 + 2 = 15
		Assertions.assertEquals(15, Solution.maxGrade(n, h, f));
	}
	
	@Test
	public void testExampleB() {
		int n = 3;
		int h = 7;
		int[][] f = {{0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 4, 6, 9, 9, 10, 10}, {1, 1, 6, 6, 6, 6, 6, 6}, {1, 3, 3, 3, 3, 3, 3, 3}};
		// Spend 4 hours on the first assignment, 2 hours on the second assignment, and 1 hour on the last assignment
		// 9 + 6 + 3 = 18
		Assertions.assertEquals(18, Solution.maxGrade(n, h, f));
	}
	
	@Test
	public void testOneAssignment() {
		int n = 1;
		int h = 5;
		int[][] f = {{0, 0, 0, 0, 0, 0}, {1, 2, 4, 6, 8, 10}};
		// Only one assignment to choose from, spend max hours on it
		Assertions.assertEquals(10, Solution.maxGrade(n, h, f));
	}
	
	@Test
	public void testNoTimeLeft() {
		int n = 2;
		int h = 1;
		int[][] f = {{0, 0}, {1, 2}, {1, 4}};
		// Only one hour to spare, pick the second assignment with max grade
		Assertions.assertEquals(5, Solution.maxGrade(n, h, f));
	}
	
	@Test
	public void testNoTimeAtAll() {
		int n = 2;
		int h = 0;
		int[][] f = {{0, 0}, {1, 2}, {1, 4}};
		// Only get base grades from the assignments
		Assertions.assertEquals(2, Solution.maxGrade(n, h, f));
	}
	
	@Test
	public void testWorkOnEveryAssignment() {
		int n = 8;
		int h = 8;
		int[][] f = {{0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 7, 7, 7, 7, 7, 7, 7, 7}, {1, 3, 3, 3, 3, 3, 3, 3, 3}, {1, 2, 2, 2, 2, 2, 2, 2, 2}, {1, 4, 4, 4, 4, 4, 4, 4, 4}, {1, 5, 5, 5, 5, 5, 5, 5, 5}, {1, 10, 10, 10, 10, 10, 10, 10, 10}, {1, 7, 7, 7, 7, 7, 7, 7, 7}, {1, 4, 4, 4, 4, 4, 4, 4, 4}};
		// Spend exactly 1 hour per assignment
		Assertions.assertEquals(42, Solution.maxGrade(n, h, f));
	}
	
}