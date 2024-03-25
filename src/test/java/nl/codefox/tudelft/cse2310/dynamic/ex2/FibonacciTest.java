package nl.codefox.tudelft.cse2310.dynamic.ex2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {
	
	@Test
	@Timeout(100)
	public void example() {
		Assertions.assertEquals(8, Solution.fibonacci(6));
	}
	
	@Test
	@Timeout(100)
	public void test15() {
		Assertions.assertEquals(	610, Solution.fibonacci(15));
	}
	
}