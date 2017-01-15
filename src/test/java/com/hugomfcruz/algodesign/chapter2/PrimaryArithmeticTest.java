package com.hugomfcruz.algodesign.chapter2;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class PrimaryArithmeticTest {
	@Test
	public void testNoCarryOperations() {
		assertEquals(0, PrimaryArithmetic.carryOperations(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6)));
	}

	@Test
	public void testOneCarryOperation() {
		assertEquals(1, PrimaryArithmetic.carryOperations(Arrays.asList(1, 2, 3), Arrays.asList(5, 4, 9)));
	}

	@Test
	public void testThreeCarryOperations() {
		assertEquals(3, PrimaryArithmetic.carryOperations(Arrays.asList(5, 5, 5), Arrays.asList(5, 5, 5)));
	}

	@Test
	public void testCarryCausingNewCarryOperation() {
		assertEquals(2, PrimaryArithmetic.carryOperations(Arrays.asList(5, 5), Arrays.asList(4, 5)));
	}

}
