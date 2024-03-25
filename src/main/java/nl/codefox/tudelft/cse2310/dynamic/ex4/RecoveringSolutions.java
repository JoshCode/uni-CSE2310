package nl.codefox.tudelft.cse2310.dynamic.ex4;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Solution extends RecoveringSolutions {}

public class RecoveringSolutions {
	
	public static List<Integer> solve(int n, int[] nodes, int result, int[] mem) {
		// TODO
		LinkedList<Integer> path = new LinkedList<>();
		path.addFirst(n);
		for (int i = n; i > 0; i--) {
			for (int j = i - 1; j >= i - 3 && j > 0; j--) {
				if (mem[i] == mem[j] + nodes[i]) {
					i = j;
					path.addFirst(j);
				}
			}
		}
		return path;
	}
	
}
