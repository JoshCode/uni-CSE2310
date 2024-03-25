package nl.codefox.tudelft.cse2310.dynamic.ex12;

class Solution extends TightOnTime {}

public class TightOnTime {
	
	/**
	 * Implement this method
	 *
	 * @param n the number of assignments
	 * @param h the number of hours you can spend
	 * @param f the function in the form of a (n + 1) x (h + 1) matrix.
	 *          Index 0 of the number of assignments should be ignored.
	 *          Index 0 of the number of hours spend is the minimum grade for this assignment.
	 * @return the max grade achievable
	 */
	public static int maxGrade(int n, int h, int[][] f) {
		// This problem is a more specific version of the Knapsack problem of 6.4
		// Contents of mem is Opt(i, t), for courses 1..i up to time t <= h
		int[][] mem = new int[n + 1][h + 1];
		
		// Initialize sum of base grades without any time investment
		for (int i = 1; i <= n; i++) {
			mem[i][0] = f[i][0] + mem[i - 1][0];
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= h; j++) {
				int max = Integer.MIN_VALUE;
				for (int k = 0; k <= j; k++) {
					max = Math.max(max, f[i][k] + mem[i - 1][j - k]);
				}
				mem[i][j] = max;
			}
		}
		return mem[n][h];
	}
	
}
