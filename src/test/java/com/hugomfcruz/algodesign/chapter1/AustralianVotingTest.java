package com.hugomfcruz.algodesign.chapter1;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;


public class AustralianVotingTest {
	@Test
	public void testEasyWinner(){
		List<String> candidates = Arrays.asList(
				"John Doe",
				"Jane Smith",
				"Jane Austen");
		List<List<Integer>> ballots = Arrays.asList(
				Arrays.asList(2, 2, 3),
				Arrays.asList(2, 2, 3),
				Arrays.asList(2, 3, 1),
				Arrays.asList(1, 2, 3),
				Arrays.asList(3, 1, 2)
				);
		
		
		assertEquals(
				"Jane Smith",
				AustralianVoting.getWinner(candidates, ballots)
				);
	}
	
	@Test
	public void testFromExample(){
		List<String> candidates = Arrays.asList(
				"John Doe",
				"Jane Smith",
				"Jane Austen");
		List<List<Integer>> ballots = Arrays.asList(
				Arrays.asList(1, 2, 3),
				Arrays.asList(2, 1, 3),
				Arrays.asList(2, 3, 1),
				Arrays.asList(1, 2, 3),
				Arrays.asList(3, 1, 2)
				);
		
		
		assertEquals(
				"John Doe",
				AustralianVoting.getWinner(candidates, ballots)
				);
	}
}
