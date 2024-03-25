package nl.codefox.tudelft.cse2310.divideconquer.ex7;

public class MergeAndCount {
	
	public static int countInversions(int[] array) {
		return sortCount(array, 0, array.length - 1);
	}
	
	private static int sortCount(int[] arr, int lo, int hi) {
		if (lo >= hi)
			return 0;
		
		int mid = (lo + hi) / 2;
		int result = sortCount(arr, lo, mid);
		result += sortCount(arr, mid + 1, hi);
		result += mergeCount(arr, lo, mid, hi);
		return result;
	}
	
	private static int mergeCount(int[] arr, int lo, int mid, int hi) {
		int inversions = 0;
		int i = 0;
		int j = lo;
		int k = mid + 1;
		int[] sort = new int[hi - lo + 1];
		
		while (j <= mid && k <= hi) {
			if (arr[j] <= arr[k]) {
				sort[i] = arr[j];
				j++;
				i++;
			} else {
				sort[i] = arr[k];
				k++;
				i++;
				inversions += (mid - j) + 1;
			}
		}
		while (j <= mid) {
			sort[i] = arr[j];
			j++;
			i++;
		}
		while (k <= hi) {
			sort[i] = arr[k];
			k++;
			i++;
		}
		
		for (i = 0; i < sort.length; i++) {
			arr[i + lo] = sort[i];
		}
		
		return inversions;
	}
	
}
