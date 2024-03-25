package nl.codefox.tudelft.cse2310.divideconquer.ex1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

class DepthFirstSearchTest {
	
	static BinaryTree hugeTree = buildCompleteTree(1_000_000);
	
	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
	public void testNull() {
		DepthFirstSearch s = new DepthFirstSearch();
		BinaryTree tree = null;
		Assertions.assertFalse(s.search(tree, 42));
	}
	
	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
	public void testTiny() {
		DepthFirstSearch s = new DepthFirstSearch();
		BinaryTree tree = new BinaryTree(42);
		Assertions.assertTrue(s.search(tree, 42));
	}
	
	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
	public void testSimple() {
		SolutionImpl s = new SolutionImpl();
		BinaryTree tree = new BinaryTree(50, new BinaryTree(30, new BinaryTree(20), new BinaryTree(10)), new BinaryTree(600, new BinaryTree(200), new BinaryTree(100)));
		Assertions.assertFalse(s.search(tree, 999));
		Assertions.assertTrue(s.count > 6);
	}
	
	@Test
	@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
	public void testLarge() {
		SolutionImpl s = new SolutionImpl();
		int n = 10;
		BinaryTree tree = buildCompleteTree(n);
		for (int i = 1; i <= n; i++) {
			Assertions.assertTrue(s.search(tree, i));
		}
		for (int i = n + 1; i <= 2 * n; i++) {
			Assertions.assertFalse(s.search(tree, i));
		}
	}
	
	@Test
	@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
	public void testDepthFirst() {
		SolutionImpl s = new SolutionImpl();
		BinaryTree tree = new BinaryTree(1, new BinaryTree(2, new BinaryTree(24, new BinaryTree(100, new BinaryTree(999), new BinaryTree(1337)), new BinaryTree(101)), new BinaryTree(42)), new BinaryTree(42));
		Assertions.assertTrue(s.search(tree, 42));
		Assertions.assertTrue(s.count > 7);
	}
	
	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	public void testHugeTree() {
		SolutionImpl s = new SolutionImpl();
		Assertions.assertTrue(s.search(hugeTree, 4242));
		Assertions.assertFalse(s.search(hugeTree, 42424242));
		// Not gonna bother counting. Sorry. XD
		Assertions.assertTrue(s.count > 1_000_000);
	}
	
	public static BinaryTree buildCompleteTree(int nodes) {
		if (nodes == 0)
			return null;
		BinaryTree root = new BinaryTree(1);
		Queue<BinaryTree> q = new LinkedList<>();
		q.add(root);
		int i = 2;
		while (i <= nodes) {
			BinaryTree p = q.poll();
			p.setLeft(new BinaryTree(i));
			q.add(p.getLeft());
			i++;
			if (i <= nodes) {
				p.setRight(new BinaryTree(i));
				q.add(p.getRight());
			}
			i++;
		}
		return root;
	}
	
	class SolutionImpl extends DepthFirstSearch {
		
		int count;
		
		SolutionImpl() {
			count = 0;
		}
		
		public boolean search(BinaryTree tree, int element) {
			count++;
			return super.search(tree, element);
		}
	}
	
}