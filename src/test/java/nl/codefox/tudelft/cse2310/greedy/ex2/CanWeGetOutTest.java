package nl.codefox.tudelft.cse2310.greedy.ex2;

import nl.codefox.tudelft.cse2310.util.WebLab;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.TimeUnit;

class CanWeGetOutTest {
	
	static class ProblemInstance {
		
		Set<Node> nodes;
		
		Node s, t;
		
		public ProblemInstance(Set<Node> nodes, Node s, Node t) {
			this.nodes = nodes;
			this.s = s;
			this.t = t;
		}
	}
	
	private void runTestWithFile(String fileName) {
		ProblemInstance i = parseFile(new ByteArrayInputStream(WebLab.getData(fileName + ".in").getBytes(StandardCharsets.UTF_8)));
		boolean expectedResult = WebLab.getData(fileName + ".out").trim().equals("yes");
		Assertions.assertEquals(expectedResult, CanWeGetOut.solve(i.nodes, i.s, i.t));
	}
	
	public ProblemInstance parseFile(InputStream in) {
		Scanner sc = new Scanner(in);
		/* Read the first line */
		int n = sc.nextInt();
		int m = sc.nextInt();
		int s = sc.nextInt();
		int t = sc.nextInt();
		/* Create the nodes */
		Map<Integer, Node> nodes = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			nodes.put(i, new Node());
		}
		/* Add all the edges */
		for (int i = 1; i <= m; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			sc.nextInt();
			nodes.get(from).outgoingEdges.add(nodes.get(to));
		}
		sc.close();
		return new ProblemInstance(new HashSet<>(nodes.values()), nodes.get(s), nodes.get(t));
	}
	
	@Test
	@Timeout(500)
	public void example() {
		int n = 7;
		Node[] nodesArr = new Node[n + 1];
		Set<Node> nodes = new HashSet<>();
		for (int i = 1; i <= n; i++) {
			nodesArr[i] = new Node();
			nodes.add(nodesArr[i]);
		}
		Node s = nodesArr[1];
		Node t = nodesArr[5];
		nodesArr[1].outgoingEdges.add(nodesArr[2]);
		nodesArr[2].outgoingEdges.add(nodesArr[3]);
		nodesArr[3].outgoingEdges.add(nodesArr[4]);
		nodesArr[4].outgoingEdges.add(nodesArr[5]);
		nodesArr[2].outgoingEdges.add(nodesArr[6]);
		nodesArr[6].outgoingEdges.add(nodesArr[7]);
		nodesArr[7].outgoingEdges.add(nodesArr[4]);
		Assertions.assertTrue(CanWeGetOut.solve(nodes, s, t));
	}
	
	@Test
	@Timeout(value = 10000, unit = TimeUnit.MILLISECONDS)
	public void set7() {
		runTestWithFile("dataset7");
	}
	
}