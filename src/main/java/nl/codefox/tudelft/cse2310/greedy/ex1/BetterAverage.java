package nl.codefox.tudelft.cse2310.greedy.ex1;

class BetterAverage {
	
	public static double solve(int n, double[] list) {
		quickSort(list);
		int mid = (list.length - 1) / 2;
		if (list.length % 2 == 0) {
			return (list[mid] + list[mid + 1]) / 2;
		}
		return list[mid];
	}
	
	private static void quickSort(double[] list) {
		quickSort(list, 0, list.length - 1);
	}
	
	private static void quickSort(double[] list, int lo, int hi) {
		if (lo < hi) {
			int pIdx = partition(list, lo, hi);
			quickSort(list, lo, pIdx - 1);
			quickSort(list, pIdx + 1, hi);
		}
	}
	
	private static int partition(double[] list, int lo, int hi) {
		// Get simple pivot
		int pivotIdx = hi;
		double pivot = list[pivotIdx];
		
		int i = lo;
		int j = hi - 1;
		while (i < j) {
			if (list[i] <= pivot) {
				i++;
			} else if (list[j] >= pivot) {
				j--;
			} else {
				swap(list, i, j);
			}
		}
		
		if (list[i] > pivot) {
			swap(list, i, pivotIdx);
			pivotIdx = i;
		}
		
		return pivotIdx;
	}
	
	private static void swap(double[] list, int a, int b) {
		double t = list[a];
		list[a] = list[b];
		list[b] = t;
	}

//	private static int median(double[] list, int lo, int hi) {
//
//	}

}
