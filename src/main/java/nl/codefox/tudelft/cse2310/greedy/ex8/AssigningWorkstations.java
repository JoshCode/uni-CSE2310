package nl.codefox.tudelft.cse2310.greedy.ex8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class AssigningWorkstations {
	
	/**
	 * @param n        number of researchers
	 * @param m        number of minutes after which workstations lock themselves
	 * @param start    start times of jobs 1 through n. NB: you should ignore start[0]
	 * @param duration duration of jobs 1 through n. NB: you should ignore duration[0]
	 * @return the number of unlocks that can be saved.
	 */
	public static int solve(int n, int m, int[] start, int[] duration) {
		ArrayList<Job> jobs = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			jobs.add(new Job(start[i], duration[i], m));
		}
		jobs.sort(Comparator.comparingInt(o -> o.start));
		
		PriorityQueue<Job> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.lock));
		
		int unlockSaved = 0;
		for (int i = 0; i < n; i++) {
			Job job = jobs.get(i);
			
			if (!queue.isEmpty() && job.start >= queue.peek().end) {
				while (!queue.isEmpty()) {
					Job finished = queue.poll();
					if (job.start <= finished.lock) {
						unlockSaved++;
						break;
					}
				}
			}
			queue.offer(job);
		}
		
		return unlockSaved;
	}
	
	private static class Job {
		public final int start;
		public final int duration;
		public final int end;
		public final int lock;
		
		public Job(int start, int duration, int lockTime) {
			this.start = start;
			this.duration = duration;
			this.end = start + duration;
			this.lock = this.end + lockTime;
		}
		
		@Override
		public String toString() {
			return "Job{" +
					"start=" + start +
					", end=" + end +
					", lock=" + lock +
					'}';
		}
	}
	
}