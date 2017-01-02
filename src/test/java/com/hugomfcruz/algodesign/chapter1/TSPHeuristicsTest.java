package com.hugomfcruz.algodesign.chapter1;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.hugomfcruz.algodesign.utils.Point;


public class TSPHeuristicsTest {
	@Test
	public void testNearestNeighborLinear(){
		List<Point> input = Arrays.asList(
				new Point(0,0),
				new Point(0,10),
				new Point(0,1),
				new Point(0,6),
				new Point(0,3)
				);
		
		List<Point> expected = Arrays.asList(
				new Point(0,0),
				new Point(0,1),
				new Point(0,3),
				new Point(0,6),
				new Point(0,10)
				);
		
		assertEquals(expected, TSPHeuristics.NearestNeighbor(input));
	}
	
	@Test
	public void testNearestNeighborLeftAndRight(){
		List<Point> input = Arrays.asList(
				new Point(0,0),
				new Point(0,-25),
				new Point(0,-6),
				new Point(0,-1),
				new Point(0,3),
				new Point(0,12)
				);
		
		List<Point> expected = Arrays.asList(
				new Point(0,0),
				new Point(0,-1),
				new Point(0,3),
				new Point(0,-6),
				new Point(0,12),
				new Point(0,-25)
				);
		
		assertEquals(expected, TSPHeuristics.NearestNeighbor(input));
	}
	
	@Test
	public void testNearestNeighborLeftAndRightStartAtLeft(){
		List<Point> input = Arrays.asList(
				new Point(0,-21),
				new Point(0,0),
				new Point(0,3),
				new Point(0,-6),
				new Point(0,-1),
				new Point(0,11)
				);
		
		List<Point> expected = Arrays.asList(
				new Point(0,-21),
				new Point(0,-6),
				new Point(0,-1),
				new Point(0,0),
				new Point(0,3),
				new Point(0,11)
				);
		
		assertEquals(expected, TSPHeuristics.NearestNeighbor(input));
	}
}
