package nl.codefox.tudelft.cse2310.dynamic.ex9;

class Solution extends Knapsack {
	
	public static int mathijsFavouriteProblem(int n, int W, int[] w, int[] v) {
		return solve(n, W, w, v);
	}
	
}

public class Knapsack {
	
	/**
	 * @param n the number of items
	 * @param W the maximum weight
	 * @param w the weight of the items, indexed w[1] to w[n].
	 * @param v the value of the items, indexed v[1] to v[n];
	 * @return the maximum obtainable value.
	 */
	public static int solve(int n, int W, int[] w, int[] v) {
		int[][] mem = new int[n + 1][W + 1];
		
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= W; j++) {
				if (w[i] > j) {
					mem[i][j] = mem[i-1][j];
					continue;
				}
				mem[i][j] = Math.max(mem[i-1][j], mem[i-1][j-w[i]] + v[i]);
			}
		}
		
		return mem[n][W];
	}

}
