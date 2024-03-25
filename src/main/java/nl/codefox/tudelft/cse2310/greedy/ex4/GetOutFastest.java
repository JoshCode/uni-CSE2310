package nl.codefox.tudelft.cse2310.greedy.ex4;

import java.util.*;

public class GetOutFastest {
	
	/**
	 * @param n     the number of nodes
	 * @param m     the number of edges
	 * @param s     the starting vertex (1 <= s <= n)
	 * @param t     the ending vertex (1 <= t <= n)
	 * @param edges the set of edges of the graph, with endpoints labelled between 1 and n inclusive.
	 * @return the time required to get out, or -1 if it is not possible to get out.
	 */
	public static int getMeOuttaHere(int n, int m, int s, int t, Set<Edge> edges) {
		Map<Integer, Set<Edge>> outgoingEdges = getOutgoingEdges(n, edges);
		
		int[] previous = new int[n + 1], distance = new int[n + 1];
		Arrays.fill(previous, 0);
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		Set<Integer> visited = new HashSet<>();
		PriorityQueue<DijkstraDistance> queue = new PriorityQueue<>();
		
		queue.offer(new DijkstraDistance(0, s));
		distance[s] = 0;
		while (!queue.isEmpty()) {
			DijkstraDistance currentDD = queue.remove();
			int current = currentDD.node;
			if (visited.contains(current))
				continue;
			visited.add(current);
			
			
			Set<Edge> outgoingHere = outgoingEdges.get(current);
			for (Edge edge : outgoingHere) {
				if (!visited.contains(edge.to)) {
					int dist = distance[current] + outgoingHere.size() + edge.weight;
					if (dist < distance[edge.to]) {
						distance[edge.to] = dist;
						previous[edge.to] = current;
						queue.offer(new DijkstraDistance(dist, edge.to));
					}
				}
			}
		}
		return distance[t];
//		throw new UnsupportedOperationException();
	}
	
	private static Map<Integer, Set<Edge>> getOutgoingEdges(int n, Set<Edge> edges) {
		Map<Integer, Set<Edge>> outgoingEdges = new HashMap<>();
		for (int i = 1; i < n + 1; i++) {
			outgoingEdges.put(i, new HashSet<>());
		}
		for (Edge e : edges) {
			if (outgoingEdges.containsKey(e.from))
				outgoingEdges.get(e.from).add(e);
		}
		return outgoingEdges;
	}
}

class Edge {
	
	int from, to, weight;
	
	public Edge(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Edge edge = (Edge) o;
		return from == edge.from && to == edge.to && weight == edge.weight;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(from, to, weight);
	}
}

class DijkstraDistance implements Comparable<DijkstraDistance> {
	public final int distance;
	public final int node;
	
	public DijkstraDistance(int distance, int node) {
		this.distance = distance;
		this.node = node;
	}
	
	@Override
	public int compareTo(DijkstraDistance o) {
		return java.lang.Integer.compare(this.distance, o.distance);
	}
}