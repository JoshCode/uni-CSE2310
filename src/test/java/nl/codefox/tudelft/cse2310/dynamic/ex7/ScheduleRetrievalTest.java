package nl.codefox.tudelft.cse2310.dynamic.ex7;

import nl.codefox.tudelft.cse2310.util.WebLab;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.*;

class ScheduleRetrievalTest {
	
	private static class ProblemInstance {
		
		int n;
		
		int[] s;
		
		int[] f;
		
		int[] v;
		
		int[] mem;
		
		int[] p;
		
		ProblemInstance(int[][] jobs, int[] p) {
			this.n = jobs.length;
			this.s = new int[this.n + 1];
			this.f = new int[this.n + 1];
			this.v = new int[this.n + 1];
			this.mem = new int[this.n + 1];
			for (int i = 1; i <= this.n; i++) {
				this.s[i] = jobs[i - 1][0];
				this.f[i] = jobs[i - 1][1];
				this.v[i] = jobs[i - 1][2];
				this.mem[i] = jobs[i - 1][3];
			}
			this.p = p;
		}
	}
	
	private static ProblemInstance parseInput(String in) {
		// Reading the input through the use of a Scanner.
		Scanner sc = new Scanner(in);
		// Read the amount of jobs.
		int n = sc.nextInt();
		int[][] jobs = new int[n][4];
		// Read the data for every job.
		for (int i = 0; i < n; i++) {
			jobs[i][0] = sc.nextInt();
			jobs[i][1] = sc.nextInt();
			jobs[i][2] = sc.nextInt();
			jobs[i][3] = sc.nextInt();
		}
		// Close the scanner.
		sc.close();
		// Sort the jobs on ascending End time order.
		Arrays.sort(jobs, Comparator.comparingInt((int[] o) -> o[1]));
		// Find the predecessor for every job. If a job j has no predecessor then p[j] = -1
		int[] p = new int[n + 1];
		Arrays.fill(p, -1);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (jobs[i][0] >= jobs[j][1]) {
					p[i + 1] = j + 1;
				}
			}
		}
		return new ProblemInstance(jobs, p);
	}
	
	private static List<Integer> parseOutput(String out) {
		// Reading the input through the use of a Scanner.
		Scanner sc = new Scanner(out);
		// Read the amount of jobs.
		int n = sc.nextInt();
		// Read the id's of the jobs.
		ArrayList<Integer> output = new ArrayList<>(n);
		for (int i = 0; i < n; i++) output.add(sc.nextInt());
		// Close the scanner.
		sc.close();
		return output;
	}
	
	private static void runTestWithFile(String fileName) {
		ProblemInstance x = parseInput(WebLab.getData(fileName + ".in"));
		List<Integer> expected = parseOutput(WebLab.getData(fileName + ".out").trim());
		Assertions.assertEquals(expected, Solution.solve(x.n, x.s, x.f, x.v, x.p, x.mem));
	}
	
	@Test
	@Timeout(100)
	public void example() {
		int[] s = {0, 0, 1, 3};
		int[] f = {0, 3, 4, 8};
		int[] v = {0, 3, 5, 7};
		int[] p = {0, -1, -1, 1};
		int[] mem = {0, 3, 5, 10};
		LinkedList<Integer> expected = new LinkedList<>();
		expected.add(1);
		expected.add(3);
		Assertions.assertEquals(expected, Solution.solve(3, s, f, v, p, mem));
	}
	
	
}