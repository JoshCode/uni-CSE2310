package nl.codefox.tudelft.cse2310.dynamic.ex10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution extends KnapsackRetrieval {
	
	public static List<Integer> mathijsFavouriteProblem(int n, int W, int[] w, int[] v, int[][] mem) {
		return solve(n, W, w, v, mem);
	}
	
}

public class KnapsackRetrieval {
	
	/**
	 * Retrieves the knapsack items used in an optimal solution.
	 *
	 * @param n the number of items.
	 * @param W the maximum weight.
	 * @param w the weight of the items, indexed w[1] to w[n].
	 * @param v the value of the items, indexed v[1] to v[n].
	 * @param mem is a (n x W) integer array, where element mem[i][j] is
	 *            the maximum value using only elements 1 to i and max weight of j.
	 *
	 * @return list containing the id of the items used in the optimal solution, ordered increasingly.
	 */
	public static List<Integer> solve(int n, int W, int[] w, int[] v, int[][] mem) {
		List<Integer> items = new ArrayList<>();
		
		int remainingWeight = W;
		for (int i = n; i > 0; i--) {
			if (w[i] > remainingWeight) continue;
			if (v[i] + mem[i-1][remainingWeight - w[i]] > mem[i-1][remainingWeight]) {
				remainingWeight -= w[i];
				items.add(i);
			}
		}
		
		Collections.reverse(items);
		return items;
	}

}
