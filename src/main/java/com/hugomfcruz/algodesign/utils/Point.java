package com.hugomfcruz.algodesign.utils;

import org.apache.commons.lang3.tuple.MutablePair;

@SuppressWarnings("serial")
public class Point extends MutablePair<Integer, Integer> {

	public Point(int x, int y) {
		super(x, y);
	}

	public double distance(Point otherPoint) {
		return Math.sqrt(
				Math.pow(getLeft() - otherPoint.getLeft(), 2) +
				Math.pow(getRight() - otherPoint.getRight(), 2));
	}
	
}
