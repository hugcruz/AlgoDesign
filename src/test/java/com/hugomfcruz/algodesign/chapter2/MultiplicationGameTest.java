package com.hugomfcruz.algodesign.chapter2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MultiplicationGameTest {
	@Test
	public void test162() {
		assertEquals("Stan", MultiplicationGame.findWinner(162));
	}

	@Test
	public void test17() {
		assertEquals("Ollie", MultiplicationGame.findWinner(17));
	}

	@Test
	public void test34012226() {
		assertEquals("Stan", MultiplicationGame.findWinner(34012226));
	}

	@Test
	public void test35() {
		assertEquals("Stan", MultiplicationGame.findWinner(35));
	}

	@Test
	public void test190() {
		assertEquals("Ollie", MultiplicationGame.findWinner(190));
	}

	@Test
	public void test771() {
		assertEquals("Stan", MultiplicationGame.findWinner(771));
	}

	@Test
	public void test20() {
		assertEquals("Stan", MultiplicationGame.findWinner(20));
	}

	@Test
	public void test3480() {
		assertEquals("Ollie", MultiplicationGame.findWinner(3480));
	}

	@Test
	public void test1589() {
		assertEquals("Stan", MultiplicationGame.findWinner(1589));
	}

	@Test
	public void test5768() {
		assertEquals("Ollie", MultiplicationGame.findWinner(5768));
	}

	@Test
	public void test36() {
		assertEquals("Stan", MultiplicationGame.findWinner(36));
	}

	@Test
	public void test2222() {
		assertEquals("Stan", MultiplicationGame.findWinner(2222));
	}

	@Test
	public void test3489() {
		assertEquals("Ollie", MultiplicationGame.findWinner(3489));
	}
}
