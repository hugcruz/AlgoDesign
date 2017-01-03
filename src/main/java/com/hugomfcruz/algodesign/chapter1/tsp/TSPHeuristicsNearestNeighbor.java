package com.hugomfcruz.algodesign.chapter1.tsp;

import java.util.ArrayList;
import java.util.List;

import com.hugomfcruz.algodesign.utils.Point;

public class TSPHeuristicsNearestNeighbor {
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
			double dist = target.distance(points.get(i));
			if (dist < minimumDistance) {
				minimumDistance = dist;
				nearestIndex = i;
			}
		}
		return nearestIndex;
	}
}
