package com.hugomfcruz.algodesign.chapter1.tsp;

import java.util.ArrayList;
import java.util.List;

import com.hugomfcruz.algodesign.utils.Point;

public class TSPHeuristicsClosestPair {
	public static List<Point> calculate(List<Point> points){
		boolean done = false;
		
		List<Vertex> vertexes = createInitialVertexes(points);
		
		List<VertexChain> chains = null;
		
		while(!done){
			chains = createChains(vertexes);
			List<Vertex> edges = getChainEdges(chains);
			if(edges.size() == 2){
				done = true;
				break;
			}
			
			double min = Double.MAX_VALUE;
			Vertex v1 = null;
			Vertex v2 = null;
			for (Vertex vertexI : edges) {
				for (Vertex vertexJ : edges) {
					if(vertexI != vertexJ && vertexI.getChain() != vertexJ.getChain()){
						if(vertexI.distance(vertexJ) < min){
							min = vertexI.distance(vertexJ);
							v1 = vertexI;
							v2 = vertexJ;
						}
					}
				}
			}
			
			chains.remove(v2.getChain());
			v1.connect(v2);
		}
		
		return chains.get(0).getPoints();
	}
	
	private static List<Vertex> createInitialVertexes(List<Point> points) {
		List<Vertex> result = new ArrayList<>();
		
		for (Point point : points) {
			VertexChain chain = new VertexChain();
			Vertex vertex = new Vertex(point, chain);
			chain.getVertexes().add(vertex);
			result.add(vertex);
		}
		
		return result;
	}

	private static List<Vertex> getChainEdges(List<VertexChain> chains) {
		List<Vertex> result = new ArrayList<>();
		for (VertexChain vertexChain : chains) {
			result.addAll(vertexChain.getEdges());
		}
		return result;
	}

	private static List<VertexChain> createChains(List<Vertex> vertexes) {
		List<VertexChain> result = new ArrayList<>();
		
		for (Vertex vertex : vertexes) {
			if(!result.contains(vertex.getChain())){
				result.add(vertex.getChain());
			}
		}
		
		return result;
	}
}
