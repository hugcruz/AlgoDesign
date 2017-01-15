package com.hugomfcruz.algodesign.chapter2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LightMoreLightTest {
	@Test
	public void test3() {
		assertEquals(false, LightMoreLight.isLastLightOn(3));
	}

	@Test
	public void test6241() {
		assertEquals(true, LightMoreLight.isLastLightOn(6241));
	}

	@Test
	public void test8191() {
		assertEquals(false, LightMoreLight.isLastLightOn(8191));
	}
}
