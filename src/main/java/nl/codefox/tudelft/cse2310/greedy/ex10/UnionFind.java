package nl.codefox.tudelft.cse2310.greedy.ex10;

public class UnionFind {
	
	private final int[] parent;
	
	private final int[] rank;
	
	// Union Find structure implemented with two arrays for Union by Rank
	public UnionFind(int size) {
		parent = new int[size];
		rank = new int[size];
		for (int i = 0; i < size; i++) parent[i] = i;
	}
	
	/**
	 * Merge two subtrees if they have a different parent, input is array indices
	 *
	 * @param i a node in the first subtree
	 * @param j a node in the second subtree
	 * @return true iff i and j had different parents.
	 */
	boolean union(int i, int j) {
		int iParent = find(i);
		int jParent = find(j);
		if (iParent == jParent)
			return false;
		
		if (rank[iParent] < rank[jParent]) {
			parent[iParent] = jParent;
		} else if (rank[jParent] < rank[iParent]) {
			parent[jParent] = iParent;
		} else {
			parent[jParent] = iParent;
			rank[iParent] += 1;
		}
		return true;
	}
	
	/**
	 * NB: this function should also do path compression
	 *
	 * @param i index of a node
	 * @return the root of the subtree containg i.
	 */
	int find(int i) {
		if (parent[i] != i) {
			parent[i] = find(parent[i]);
		}
		return parent[i];
	}
	
	// Return the rank of the trees
	public int[] getRank() {
		return rank;
	}
	
	// Return the parent of the trees
	public int[] getParent() {
		return parent;
	}
	
}
