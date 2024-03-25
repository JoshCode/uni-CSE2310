package nl.codefox.tudelft.cse2310.divideconquer.ex8;

import java.util.HashSet;
import java.util.Set;

public class PartialSums {
	
	/**
	 * Computes all possible partial sums given an array of integers.
	 *
	 * @param arr - all values in the input set
	 * @return set of sums
	 */
	public static Set<Integer> partialSums(Integer[] arr) {
		Set<Integer> result = new HashSet<>(Set.of(0));
		if (arr == null || arr.length == 0)
			return result;
		
		result.addAll(partialSums(arr, 0, arr.length - 1));
		return result;
	}
	
	private static Set<Integer> partialSums(Integer[] arr, int lo, int hi) {
		if (lo >= hi)
			return new HashSet<>(Set.of(arr[lo]));
		Set<Integer> res = new HashSet<>();
		
		int mid = (lo + hi) / 2;
		Set<Integer> res1 = partialSums(arr, lo, mid);
		Set<Integer> res2 = partialSums(arr, mid + 1, hi);
		res.addAll(res1);
		res.addAll(res2);
		
		for (int i : res1) {
			for (int j : res2) {
				res.add(i + j);
			}
		}
		
		return res;
	}
	
}
