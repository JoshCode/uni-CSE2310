package nl.codefox.tudelft.cse2310.dynamic.ex5;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution extends IntervalPredecessors {}

public class IntervalPredecessors {
	
	public static int[] solve(int n, int[] s, int[] f, int[] v) {
		// TODO
		Pair[] starts = new Pair[n];
		Pair[] ends = new Pair[n];
		for (int i = 1; i <= n; i++) {
			starts[i-1] = new Pair(i, s[i]);
			ends[i-1] = new Pair(i, f[i]);
		}

		Arrays.sort(starts);
		Arrays.sort(ends);

		int[] p = new int[n+1];
		Arrays.fill(p, -1);
		for (int i = 0; i < n; i++) {
			for (int j = n - 1; j >= 0; j--) {
				if (starts[i].time >= ends[j].time) {
					p[starts[i].index] = ends[j].index;
					break;
				}
			}
		}
		return p;
	}
	
	public static int[] solveOld(int n, int[] s, int[] f, int[] v) {
		List<Interval> intervals = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			intervals.add(new Interval(i, s[i], f[i], v[i]));
		}
		
		Comparator<Interval> byIndex = Comparator.comparingInt(o -> o.i);
		Comparator<Interval> byStartTime = Comparator.comparingInt(o -> o.s);
		Comparator<Interval> byFinishTime = Comparator.comparingInt(o -> o.f);
		
		// Sort array on finish time, equal finishes sorted by start time
		// Sort on start time
//		intervals.sort(byIndex);
		// Sort on finish time
		intervals.sort(byFinishTime);
		
		int[] p = new int[n+1];
		Arrays.fill(p, 1, n+1, -1);
		for (int i = 0; i < n; i++) {
			Interval int1 = intervals.get(i);
			for (int j = i - 1; j >= 0; j--) {
				Interval int2 = intervals.get(j);
				if (int1.s >= int2.f) {
					p[int1.i] = int2.i;
					break;
				}
			}
		}
		return p;
//		throw new UnsupportedOperationException();
	}
	
}

class Interval {
	public final int i;
	public final int s;
	public final int f;
	public final int v;
	
	public Interval(int i, int s, int f, int v) {
		this.i = i;
		this.s = s;
		this.f = f;
		this.v = v;
	}
	
	@Override
	public String toString() {
		return "Interval{" +
				"i=" + i +
				", s=" + s +
				", f=" + f +
				'}';
	}
}

class Pair implements Comparable<Pair> {
	
	public final int index;
	public final int time;
	
	public Pair(int index, int time) {
		this.index = index;
		this.time = time;
	}
	
	@Override
	public String toString() {
		return "Pair{" +
				"i=" + index +
				", t=" + time +
				'}';
	}
	
	@Override
	public int compareTo(Pair o) {
		int result = Integer.compare(this.time, o.time);
		return result != 0 ? result : Integer.compare(this.index, o.index);
	}
}