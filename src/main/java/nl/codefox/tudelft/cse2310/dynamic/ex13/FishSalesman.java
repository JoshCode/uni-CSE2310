package nl.codefox.tudelft.cse2310.dynamic.ex13;

class Solution extends FishSalesman {}

public class FishSalesman {
	
	/**
	 * @param n the number of days
	 * @param P the profits that can be made on day 1 through n on location P are stored in P[1] through P[n].
	 * @param Q the profits that can be made on day 1 through n on location Q are stored in Q[1] through Q[n].
	 * @return the maximum obtainable profit.
	 */
	public static int solve(int n, int[] P, int[] Q) {
		int[][] mem = new int[2][n + 1];
		
		mem[0][0] = Integer.MIN_VALUE;
		mem[1][0] = Integer.MIN_VALUE;
		mem[0][1] = P[1];
		mem[1][1] = Q[1];
		
		for (int i = 2; i <= n; i++) {
			mem[0][i] = Math.max(P[i] + mem[0][i-1], mem[1][i-1]);
			mem[1][i] = Math.max(Q[i] + mem[1][i-1], mem[0][i-1]);
		}
		
		return Math.max(mem[0][n], mem[1][n]);
	}
	
}
