package nl.codefox.tudelft.cse2310.dynamic.ex14;

class Solution extends SequenceAlignment {}

public class SequenceAlignment {
	
	public static int solve(String firstString, String secondString) {
		String s1 = firstString;
		String s2 = secondString;
		int n = s1.length();
		int m = s2.length();
		
		int[][] mem = new int[n + 1][m + 1];
		
		for (int i = 0; i <= n; i++)
			mem[i][0] = i;
		for (int j = 0; j <= m; j++)
			mem[0][j] = j;
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				int noMatchMin = Math.min(1 + mem[i][j - 1], 1 + mem[i - 1][j]);
				int matchCost = mem[i - 1][j - 1] + (s1.charAt(i - 1) == s2.charAt(j - 1) ? 0 : 1);
				mem[i][j] = Math.min(noMatchMin, matchCost);
			}
		}
		
		return mem[n][m];
	}
	
}
