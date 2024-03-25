package nl.codefox.tudelft.cse2310.dynamic.ex6;

class Solution extends ChoosingBetweenWork {}

public class ChoosingBetweenWork {
	
	/**
	 * Come up with an iterative dynamic programming solution to the weighted interval scheduling problem.
	 * NB: You may assume the jobs are sorted by ascending finishing time.
	 *
	 * @param n the number of jobs
	 * @param s the start times of the jobs for jobs 1 through n. Note that s[0] should be ignored.
	 * @param f the finish times of the jobs for jobs 1 through n. Note that f[0] should be ignored.
	 * @param v the values of the jobs for jobs 1 through n. Note that v[0] should be ignored.
	 * @param p the predecessors of the jobs for jobs 1 through n. Note that p[0] should be ignored and that -1 represents there being no predecessor.
	 * @return the weight of the maximum weight schedule.
	 */
	public static int solve(int n, int[] s, int[] f, int[] v, int[] p) {
		int[] mem = new int[n + 1];
		if (n == 0) return 0;
		if (n == 1) return v[1];
		
		mem[0] = 0;
		
		for (int i = 1; i <= n; i++) {
			int mem_p = 0;
			if (p[i] != -1) mem_p = mem[p[i]];
			mem[i] = Math.max(v[i] + mem_p, mem[i-1]);
		}
		
		// Returning the obtained value at index n.
		return mem[n];
	}

}
