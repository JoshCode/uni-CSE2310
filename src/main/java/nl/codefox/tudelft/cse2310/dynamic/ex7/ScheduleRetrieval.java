package nl.codefox.tudelft.cse2310.dynamic.ex7;

import java.util.LinkedList;
import java.util.List;

class Solution extends ScheduleRetrieval {}

public class ScheduleRetrieval {
	
	/**
	 * Using the memoized values from an iterative dynamic programming solution,
	 * retrieve the schedule with the highest total weight.
	 * NB: You may assume the jobs are sorted by ascending finishing time.
	 *
	 * @param n   the number of jobs
	 * @param s   the start times of the jobs for jobs 1 through n. Note that s[0] should be ignored.
	 * @param f   the finish times of the jobs for jobs 1 through n. Note that f[0] should be ignored.
	 * @param v   the values of the jobs for jobs 1 through n. Note that v[0] should be ignored.
	 * @param p   the predecessors of the jobs for jobs 1 through n. Note that p[0] should be ignored and that -1 represents there being no predecessor.
	 * @param mem where the ith element is the maximum weight of a schedule using the first i jobs.
	 * @return list containing the id of the jobs used in the optimal schedule, ordered by ascending finishing time.
	 */
	public static List<Integer> solve(int n, int[] s, int[] f, int[] v, int[] p, int[] mem) {
		LinkedList<Integer> result = new LinkedList<>();
		if (n == 0) return result;
		
		for (int i = n; i >= 0; ) {
			int mem_p = 0;
			if (p[i] != -1) mem_p = mem[p[i]];
			// If [including i] is of greater value than [excluding i]
			if (v[i] + mem_p > mem[i - 1]) {
				result.addFirst(i);
				i = p[i];
			} else {
				i--;
			}
		}
		return result;
	}
	
}
