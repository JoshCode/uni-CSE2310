package nl.codefox.tudelft.cse2310.dynamic.ex2;

class Solution extends Fibonacci {}

public class Fibonacci {
	
	/**
	 * Returns the n'th Fibonacci number
	 */
	public static int fibonacci(int n) {
		// The array in which you must implement your memoization.
		int[] fibonacci = new int[n + 1];
		fibonacci[0] = 0;
		fibonacci[1] = 1;
		
		// After that, iterate through all fibonacci numbers from index 2 up to n.
		for (int i = 2; i <= n; i++) {
			fibonacci[i] = fibonacci[i-2] + fibonacci[i-1];
		}
		// Returning the obtained fibonacci value at index n.
		return fibonacci[n];
	}
	
}

