package nl.codefox.tudelft.cse2310.greedy.ex3;

import java.util.*;

public class TrainRouting {
	
	/**
	 * @param n     the number of nodes
	 * @param m     the number of edges
	 * @param edges the set of edges, with endpoints labelled between 1 and n inclusive.
	 * @param s     the starting point
	 * @return true iff there is a cycle reachable from s
	 */
	public static boolean isThereACycle(int n, int m, Set<Edge> edges, int s) {
		// Get all edges in a format that's faster to query
		Map<Integer, Set<Integer>> outgoingEdges = new HashMap<>();
		for (int i = 1; i < n + 1; i++) {
			outgoingEdges.put(i, new HashSet<>());
		}
		for (Edge e : edges) {
			if (outgoingEdges.containsKey(e.from))
				outgoingEdges.get(e.from).add(e.to);
		}
		
		boolean[] inCurrentPath = new boolean[n + 1];
		Set<Integer> visited = new HashSet<>();
		Stack<Integer> toExplore = new Stack<>();
		
		toExplore.push(s);
		while (!toExplore.isEmpty()) {
			int current = toExplore.pop();
			visited.add(current);
			inCurrentPath[current] = true;
			
			Set<Integer> nodes = outgoingEdges.get(current);
			boolean deadEnd = true;
			for (int node : nodes) {
				if (inCurrentPath[node])
					return true;
				if (!visited.contains(node)) {
					deadEnd = false;
					toExplore.push(node);
				}
			}
			if (deadEnd) {
				inCurrentPath[current] = false;
			}
		}
		return false;
	}
}

class Edge {
	int from, to;
	
	public Edge(int from, int to) {
		this.from = from;
		this.to = to;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Edge edge = (Edge) o;
		return from == edge.from && to == edge.to;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(from, to);
	}
}