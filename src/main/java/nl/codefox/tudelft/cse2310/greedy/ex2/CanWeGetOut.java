package nl.codefox.tudelft.cse2310.greedy.ex2;

import java.util.*;

public class CanWeGetOut {
	
	/**
	 * @param nodes the nodes in the graph
	 * @param s     the starting node
	 * @param t     the final node
	 * @return true iff there is a path from the start node to the final node
	 */
	public static boolean solve(Set<Node> nodes, Node s, Node t) {
		Set<Node> seen = new HashSet<>();
		Queue<Node> toExplore = new LinkedList<>();
		toExplore.add(s);
		
		while (!toExplore.isEmpty()) {
			Node current = toExplore.remove();
			if (current.equals(t))
				return true;
			
			current.marked = true;
			for (Node n : current.outgoingEdges) {
				if (!n.marked && !seen.contains(n)) {
					seen.add(n);
					toExplore.add(n);
				}
			}
		}
		return false;
	}
}

class Node {
	
	List<Node> outgoingEdges;
	
	boolean marked;
	
	public Node() {
		this.outgoingEdges = new ArrayList<>();
		this.marked = false;
	}
}