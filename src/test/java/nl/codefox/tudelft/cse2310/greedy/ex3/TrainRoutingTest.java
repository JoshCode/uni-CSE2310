package nl.codefox.tudelft.cse2310.greedy.ex3;

import nl.codefox.tudelft.cse2310.util.WebLab;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

class TrainRoutingTest {
	
	private static void runTestWithFile(String fileName) {
		ProblemInstance p = parseInput(new ByteArrayInputStream(WebLab.getData(fileName + ".in").getBytes(StandardCharsets.UTF_8)));
		Assertions.assertEquals(WebLab.getData(fileName + ".out").trim().equals("yes"), TrainRouting.isThereACycle(p.n, p.m, p.edges, p.s));
	}
	
	private static ProblemInstance parseInput(ByteArrayInputStream input) {
		Scanner sc = new Scanner(input);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int s = sc.nextInt();
		Set<Edge> edges = new HashSet<>();
		for (int i = 1; i <= m; i++) {
			edges.add(new Edge(sc.nextInt(), sc.nextInt()));
			sc.nextInt();
		}
		sc.close();
		return new ProblemInstance(n, m, s, edges);
	}
	
	static class ProblemInstance {
		int n;
		int m;
		int s;
		Set<Edge> edges;
		
		public ProblemInstance(int n, int m, int s, Set<Edge> edges) {
			this.n = n;
			this.m = m;
			this.s = s;
			this.edges = edges;
		}
	}
	
	@Test
	@Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
	public void example() {
		int n = 5;
		int m = 6;
		int s = 1;
		Set<Edge> edges = new HashSet<>();
		edges.add(new Edge(1, 2));
		edges.add(new Edge(3, 2));
		edges.add(new Edge(1, 3));
		edges.add(new Edge(4, 5));
		edges.add(new Edge(2, 4));
		edges.add(new Edge(5, 3));
		Assertions.assertTrue(TrainRouting.isThereACycle(n, m, edges, s));
	}
	
	@Test
	@Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
	public void case1() {
		runTestWithFile("case1");
	}
	
	@Test
	@Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
	public void case2() {
		runTestWithFile("case2");
	}
	
	@Test
	@Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
	public void case3() {
		runTestWithFile("case3");
	}
	
	@Test
	@Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
	public void case4() {
		runTestWithFile("case4");
	}
}