package nl.codefox.tudelft.cse2310.divideconquer.ex4;

public class FastBinaryExponentiation {
	
	/**
	 * Computes the matrix C, containing the values for a^b, for all values in a and b.
	 *
	 * @param a array containing the bases
	 * @param b array containing the exponents
	 * @return matrix C
	 */
	public static int[][] computeC(int[] a, int[] b) {
		int[][] result = new int[a.length][b.length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				result[i][j] = fbe(a[i], b[j]);
			}
			
		}
		return result;
	}
	
	private static int fbe(int a, int b) {
		if (b == 0)
			return 1;
		int result = fbe(a, b / 2);
		if (b % 2 == 0)
			return result * result;
		else
			return result * result * a;
	}
	
}
