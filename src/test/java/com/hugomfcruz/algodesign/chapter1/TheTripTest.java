package com.hugomfcruz.algodesign.chapter1;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.Test;


public class TheTripTest {
	@Test
	public void testSimpleExchange(){
		assertTrue(new BigDecimal("10").compareTo(
				TheTrip.calculateTotalMoneyExchangedToEvenExpenses(Arrays.asList(
						new BigDecimal("10"),
						new BigDecimal("20"),
						new BigDecimal("30"))))
				== 0);
	}
	
	@Test
	public void testTwoStepExchange(){
		assertTrue(new BigDecimal("12").compareTo(
				TheTrip.calculateTotalMoneyExchangedToEvenExpenses(
						Arrays.asList(
								new BigDecimal("15"),
								new BigDecimal("15.01"),
								new BigDecimal("3"),
								new BigDecimal("3.01"))))
				== 0);
	}
}
