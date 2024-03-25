package nl.codefox.tudelft.cse2310.greedy.ex5;

public class PackingTrucks {
	
	/**
	 * @param n         the number of packages
	 * @param weights   the weights of all packages 1 through n. Note that weights[0] should be ignored!
	 * @param maxWeight the maximum weight a truck can carry
	 * @return the minimal number of trucks required to ship the packages _in the given order_.
	 */
	public static int minAmountOfTrucks(int n, int[] weights, int maxWeight) {
		
		if (n == 0) {
			return 0;
		}
		int numTrucks = 1;
		int currentWeight = 0;
		for (int i = 1; i <= n; i++) {
			if (currentWeight + weights[i] <= maxWeight) {
				currentWeight += weights[i];
			} else {
				numTrucks++;
				currentWeight = weights[i];
			}
		}
		return numTrucks;
//		throw new UnsupportedOperationException("Not implemented yet.");
	}
	
}
