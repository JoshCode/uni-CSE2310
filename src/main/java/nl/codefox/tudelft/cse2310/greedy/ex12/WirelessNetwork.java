package nl.codefox.tudelft.cse2310.greedy.ex12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class WirelessNetwork {
	
	public long cost, number;
	
	public WirelessNetwork(long cost, long number) {
		this.cost = cost;
		this.number = number;
	}
	
	public static WirelessNetwork setUpTheNetwork(int n, int m, int b, Edge[] edges) {
		// Build MST (network) using Kruskal and UnionFind
		// Meanwhile we calculate totalCost to save an additional linear pass after MST creation
		UnionFind uf = new UnionFind(n);
		Arrays.sort(edges, 1, edges.length, Comparator.comparingInt(e -> e.l));
		List<Edge> network = new ArrayList<>();
		
		int totalCost = 0;
		for (Edge e : edges) {
			if (e == null) continue;
			if (uf.union(e.x, e.y)) {
				network.add(e);
				totalCost += e.l;
			}
		}
		
		// Calculate number of edges we can build right now
		// List<Edge> network is already sorted from low to high by the MST build step
		int count = 0;
		int cost = 0;
		for (Edge e : network) {
			if (cost + e.l <= b) {
				cost += e.l;
				count++;
			} else {
				break;
			}
		}
		
		return new WirelessNetwork(totalCost, count);
	}
	
}

class UnionFind {
	
	int[] parent;
	int[] rank;
	
	public UnionFind(int n) {
		parent = new int[n];
		rank = new int[n];
		for (int i = 0; i < n; i++) parent[i] = i;
	}
	
	public boolean union(int i, int j) {
		int parentI = find(i);
		int parentJ = find(j);
		
		if (parentI == parentJ) {
			return false;
		}
		
		if (rank[parentI] > rank[parentJ]) {
			parent[parentJ] = parentI;
		} else if (rank[parentJ] > rank[parentI]) {
			parent[parentI] = parentJ;
		} else {
			parent[parentJ] = parentI;
			rank[parentI]++;
		}
		return true;
	}
	
	public int find(int i) {
		if (parent[i] != i) {
			parent[i] = find(parent[i]);
		}
		return parent[i];
	}
}

class Edge {
	
	// from, to and length
	int x, y, l;
	
	public Edge(int from, int to, int length) {
		x = from;
		y = to;
		l = length;
	}
}
