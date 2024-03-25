package nl.codefox.tudelft.cse2310.greedy.ex11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class PlanningStoreLocationsTest {
	
	@Test
	public void twoForOne() {
		int n = 2;
		int k = 1;
		List<House> houses = new ArrayList<>();
		houses.add(new House(0, 1, 1));
		houses.add(new House(1, 3, 3));
		Set<Store> expected = new HashSet<>();
		expected.add(new Store(2, 2));
		Assertions.assertEquals(expected, PlanningStoreLocations.donutTime(n, k, houses));
	}
	
	@Test
	public void test2() {
		int n = 4;
		int k = 2;
		List<House> houses = new ArrayList<>();
		houses.add(new House(0, 1, 1));
		houses.add(new House(1, 3, 3));
		houses.add(new House(2, 1, 5));
		houses.add(new House(3, 2, 5));
		Set<Store> expected = new HashSet<>();
		expected.add(new Store(1, 1));
		expected.add(new Store(2, 4 + (double) 1 / 3));
		Set<Store> actual = PlanningStoreLocations.donutTime(n, k, houses);
		Assertions.assertEquals(expected, actual);
	}
	
}