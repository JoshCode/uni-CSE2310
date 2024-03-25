package nl.codefox.tudelft.cse2310.divideconquer.ex2;

public class MergeSort {
	
	/**
	 * Takes an array and sorts it in an ascending order.
	 *
	 * @param arr - the array that needs to be sorted.
	 */
	public void sort(int[] arr) {
		sort(arr, 0, arr.length - 1);
	}
	
	private void sort(int[] arr, int lo, int hi) {
		if (lo == hi)
			return;
		int mid = (lo + hi) / 2;
		
		if (hi - lo > 1) {
			sort(arr, lo, mid);
			sort(arr, mid + 1, hi);
		}
		
		merge(arr, lo, mid, hi);
	}
	
	private void merge(int[] arr, int lo, int mid, int hi) {
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
	}
	
}
