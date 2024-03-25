package nl.codefox.tudelft.cse2310.divideconquer.ex6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ClosestPairTest {
	
	@Test()
	@Timeout(1000)
	public void test1() {
		List<Point> points = new ArrayList<>();
		points.add(new Point(1, 2));
		points.add(new Point(4, 6));
		Assertions.assertEquals(5, Solution.closestPair(points), 5e-6);
	}
	
	@Test()
	@Timeout(1000)
	public void test2() {
		List<Point> points = new ArrayList<>();
		points.add(new Point(2, 3));
		points.add(new Point(12, 30));
		points.add(new Point(40, 50));
		points.add(new Point(5, 1));
		points.add(new Point(12, 10));
		points.add(new Point(3, 4));
		Assertions.assertEquals(1.4142135623730951, Solution.closestPair(points), 1e-6);
	}
	
	@Test()
	@Timeout(1000)
	public void test3() {
		Random random = new Random(1234);
		List<Point> points = new ArrayList<>();
		for (int i = 0; i < 1000000; i++) {
			int x = (int) Math.floor(1000000 * random.nextDouble());
			int y = (int) Math.floor(1000000 * random.nextDouble());
			points.add(new Point(x, y));
		}
		points.add(new Point(25, 25));
		points.add(new Point(25.1, 25));
		Assertions.assertEquals(0.1, Solution.closestPair(points), 1e-6);
	}
	
}

class Solution extends ClosestPair {}