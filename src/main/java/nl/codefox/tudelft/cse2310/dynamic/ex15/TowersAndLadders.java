package nl.codefox.tudelft.cse2310.dynamic.ex15;

import java.util.Arrays;

class Solution extends TowersAndLadders {}

public class TowersAndLadders {
	
	public static int solve(int n, int m, int[][] graph) {
		int[][] mem = new int[n][m];
		for (int[] row : mem) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}
		
		// i == x,  n == number of rows
		// j == y,  m == number of columns
		
		// Base case
		mem[0][0] = 0;
		
		// Iterate for n*m times, because the shortest path could at most be of length n*m,
		// which would be a path that traverses every square.
		for (int k = 0; k < n * m; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (i == 0 && j == 0) continue;
					
					// North
					mem[i][j] = i - 1 < 0 ? mem[i][j] : Math.min(mem[i][j], Math.max(mem[i - 1][j], graph[i][j] - graph[i - 1][j]));
					// West
					mem[i][j] = j - 1 < 0 ? mem[i][j] : Math.min(mem[i][j], Math.max(mem[i][j - 1], graph[i][j] - graph[i][j - 1]));
					// South
					mem[i][j] = i + 1 >= n ? mem[i][j] : Math.min(mem[i][j], Math.max(mem[i + 1][j], graph[i][j] - graph[i + 1][j]));
					// East
					mem[i][j] = j + 1 >= m ? mem[i][j] : Math.min(mem[i][j], Math.max(mem[i][j + 1], graph[i][j] - graph[i][j + 1]));
				}
			}
		}
		
		return mem[n - 1][m - 1];
	}
	
}
