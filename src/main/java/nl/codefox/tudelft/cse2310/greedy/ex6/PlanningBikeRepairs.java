package nl.codefox.tudelft.cse2310.greedy.ex6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PlanningBikeRepairs {
	
	public static int fixMyBikesPlease(int n, int[] starttimes, int[] durations) {
		return mySolve(n, starttimes, durations);
	}
	
	public static int mySolve(int n, int[] starttimes, int[] durations) {
		ArrayList<Interval> intervals = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			intervals.add(new Interval(starttimes[i], durations[i]));
		}
		
		Comparator<Interval> byEnd = (o1, o2) -> Integer.compare(o1.end, o2.end);
		Comparator<Interval> byStart = (o1, o2) -> Integer.compare(o1.start, o2.start);
		intervals.sort(byStart);
		
		int maxConcurrent = 0;
		PriorityQueue<Interval> selection = new PriorityQueue<>(byEnd);
		for (int i = 0; i < n; i++) {
			Interval interval = intervals.get(i);
			selection.add(interval);
			
			while (selection.size() > 0 && selection.peek().end <= interval.start) {
				selection.poll();
			}
			maxConcurrent = selection.size() > maxConcurrent ? selection.size() : maxConcurrent;
		}
		return maxConcurrent;
	}
	
	private static class Interval {
		
		public final int start;
		public final int duration;
		public final int end;
		
		private Interval(int start, int duration) {
			this.start = start;
			this.duration = duration;
			this.end = start + duration;
		}
		
		@Override
		public String toString() {
			return "Interval{" +
					"start=" + start +
					", duration=" + duration +
					", end=" + end +
					'}';
		}
	}
	
	public static int answer(int n, int[] starts, int[] durations) {
		int[] ends = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			ends[i] = starts[i] + durations[i];
		}
		Arrays.sort(starts, 1, n + 1);
		Arrays.sort(ends, 1, n + 1);
		int i = 1;
		int j = 1;
		int cnt = 0;
		int m = 0;
		while (i <= n && j <= n) {
			if (starts[i] < ends[j]) {
				cnt += 1;
				m = Math.max(cnt, m);
				i++;
			} else {
				cnt -= 1;
				j++;
			}
		}
		return m;
	}
}
