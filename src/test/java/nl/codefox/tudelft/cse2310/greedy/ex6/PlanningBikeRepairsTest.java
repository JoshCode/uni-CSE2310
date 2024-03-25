package nl.codefox.tudelft.cse2310.greedy.ex6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlanningBikeRepairsTest {
	
	@Test
	public void example() {
		int n = 6;
		int[] starttimes = {0, 6, 3, 1, 8, 3, 1};
		int[] durations = {0, 1, 5, 2, 3, 3, 4};
		Assertions.assertEquals(3, PlanningBikeRepairs.fixMyBikesPlease(n, starttimes, durations));
	}
	
	
	@Test
	public void testAnswer() {
		int n = 3;
		int[] starttimes = {0, 1, 1, 3};
		int[] durations = {0, 2, 4, 3};
		Assertions.assertEquals(2, PlanningBikeRepairs.answer(n, starttimes, durations));
	}
	
}
