package com.hugomfcruz.algodesign.chapter1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ThreeNPlusOneTest {
	@Test
	public void test1to10is20(){
		assertEquals(20, ThreeNPlusOne.calculateMaximumCycleLength(1, 10));
	}
	
	@Test
	public void test100to200is125(){
		assertEquals(125, ThreeNPlusOne.calculateMaximumCycleLength(100, 200));
	}
	
	@Test
	public void test201to210is89(){
		assertEquals(89, ThreeNPlusOne.calculateMaximumCycleLength(201, 210));
	}
	
	@Test
	public void test900to1000is174(){
		assertEquals(174, ThreeNPlusOne.calculateMaximumCycleLength(900, 1000));
	}
}
