package nl.codefox.tudelft.cse2310.dynamic.ex14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class SequenceAlignmentTest {
	
	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
	public void example() {
		String a = "kitten";
		String b = "sitting";
		Assertions.assertEquals(3, Solution.solve(a, b));
	}

}