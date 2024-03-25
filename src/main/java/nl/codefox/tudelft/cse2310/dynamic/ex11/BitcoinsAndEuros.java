package nl.codefox.tudelft.cse2310.dynamic.ex11;

import java.util.Arrays;

class Solution extends BitcoinsAndEuros {}

public class BitcoinsAndEuros {
	
	/**
	 * Implement this method
	 *
	 * @param t - the number of days you have
	 * @param r - exchange rates of each day. Ignore index 0. I.e. the exchange rate of the first day can be found using r[1].
	 * @return the maximum amount of euros after T days
	 */
	public static double optimalTrade(int t, double[] r) {
		double[] btc = new double[t + 1];
		double[] eur = new double[t + 1];
		
		btc[0] = 0.1;
		
		for (int i = 1; i <= t; i++) {
			btc[i] = Math.max(btc[i - 1], (eur[i - 1] - 5) / r[i]);
			eur[i] = Math.max(eur[i - 1], btc[i - 1] * 0.95 * r[i]);
		}
		
		return eur[t];
	}
}