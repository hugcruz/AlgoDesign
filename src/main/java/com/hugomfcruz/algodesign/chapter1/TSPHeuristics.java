package com.hugomfcruz.algodesign.chapter1;

import java.util.ArrayList;
import java.util.List;

import com.hugomfcruz.algodesign.utils.Point;

public class TSPHeuristics {
	public static List<Point> NearestNeighbor(List<Point> points) {
		// copy of input (points will not be changed)
		List<Point> unvisitedPoints = new ArrayList<>(points);

		List<Point> orderedPoints = new ArrayList<>(points.size());
		orderedPoints.add(unvisitedPoints.remove(0));

		while (!unvisitedPoints.isEmpty()) {
			int nearestIndex = findNearestNeighbor(unvisitedPoints, orderedPoints.get(orderedPoints.size() - 1));
			orderedPoints.add(unvisitedPoints.remove(nearestIndex));
		}
		return orderedPoints;
	}

	private static int findNearestNeighbor(List<Point> points, Point target) {
		int nearestIndex = 0;
		double minimumDistance = Double.MAX_VALUE;
		for (int i = 0; i < points.size(); ++i) {
			double dist = distance(target, points.get(i));
			if (dist < minimumDistance) {
				minimumDistance = dist;
				nearestIndex = i;
			}
		}
		return nearestIndex;
	}

	private static double distance(Point point1, Point point2) {
		return Math.sqrt(
				Math.pow(point1.getLeft() - point2.getLeft(), 2) +
				Math.pow(point1.getRight() - point2.getRight(), 2));
	}
}
