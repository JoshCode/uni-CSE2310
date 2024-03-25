package nl.codefox.tudelft.cse2310.dynamic.ex3;

import java.util.Arrays;

class Solution extends Iterative {}

public class Iterative {
	
	/**
	 * Implement this method to be an iterative approach for the recursive formula given in the slides.
	 *
	 * @param n     The number of nodes
	 * @param nodes the different weights. You should use nodes[1] to nodes[n]
	 * @return the minimal weight
	 */
	public static int solve(int n, int[] nodes) {
		int[] minPathWeight = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			int i_weight = nodes[i];
			int minPrevWeight = Integer.MAX_VALUE;
			for (int j = i - 1; j >= i - 3 && j >= 0; j--) {
				minPrevWeight = Math.min(minPrevWeight, minPathWeight[j]);
			}
			minPathWeight[i] = minPrevWeight + i_weight;
		}
		System.out.println(Arrays.toString(minPathWeight));
		return minPathWeight[n];
	}
	
}
