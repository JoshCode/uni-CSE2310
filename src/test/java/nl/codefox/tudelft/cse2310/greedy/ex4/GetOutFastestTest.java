package nl.codefox.tudelft.cse2310.greedy.ex4;

import nl.codefox.tudelft.cse2310.util.WebLab;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class GetOutFastestTest {
	
	private static void runTestWithFile(String fileName) {
		ProblemInstance p = parseInput(new ByteArrayInputStream(WebLab.getData(fileName + ".in").getBytes(StandardCharsets.UTF_8)));
		Assertions.assertEquals(Integer.valueOf(WebLab.getData(fileName + ".out").trim()), GetOutFastest.getMeOuttaHere(p.n, p.m, p.s, p.t, p.edges));
	}
	
	private static ProblemInstance parseInput(ByteArrayInputStream input) {
		Scanner sc = new Scanner(input);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int s = sc.nextInt();
		int t = sc.nextInt();
		Set<Edge> edges = new HashSet<>();
		for (int i = 1; i <= m; i++) {
			edges.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		sc.close();
		return new ProblemInstance(n, m, s, t, edges);
	}
	
	static class ProblemInstance {
		int n;
		int m;
		int s;
		int t;
		Set<Edge> edges;
		
		public ProblemInstance(int n, int m, int s, int t, Set<Edge> edges) {
			this.n = n;
			this.m = m;
			this.s = s;
			this.t = t;
			this.edges = edges;
		}
	}
	
	@Test
	public void example() {
		int n = 7;
		int m = 7;
		int s = 1;
		int t = 5;
		
		Set<Edge> edges = new HashSet<>();
		edges.add(new Edge(1, 2, 2));
		edges.add(new Edge(2, 3, 100));
		edges.add(new Edge(3, 4, 10));
		edges.add(new Edge(4, 5, 10));
		edges.add(new Edge(2, 6, 10));
		edges.add(new Edge(6, 7, 10));
		edges.add(new Edge(7, 4, 80));
		
		Assertions.assertEquals(118, GetOutFastest.getMeOuttaHere(n, m, s, t, edges));
	}
	
	@Test
	public void exampleFile() {
		runTestWithFile("example");
	}
	
	@Test
	public void dataset7() {
		runTestWithFile("dataset7");
	}
	
	
}