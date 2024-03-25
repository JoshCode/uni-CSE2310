package nl.codefox.tudelft.cse2310.greedy.ex7;

import java.util.Arrays;

public class ParallelProcessing {
	
	/**
	 * @param n         the number of jobs
	 * @param m         the number of processors
	 * @param deadlines the deadlines of the jobs 1 through n. NB: you should ignore deadlines[0]
	 * @return the minimised maximum lateness.
	 */
	public static int solve(int n, int m, int[] deadlines) {
		if (m == 0)
			throw new UnsupportedOperationException("No processors");
		Arrays.sort(deadlines, 1, n + 1);
		int time = 0;
		int count = 0;
		int late = 0;
		
		for (int i = 1; i <= n; i++) {
			int startingTime = (i - 1) / m;
			late = Math.max(late, startingTime + 1 - deadlines[i]);
		}
		return late;
	}
	
}
