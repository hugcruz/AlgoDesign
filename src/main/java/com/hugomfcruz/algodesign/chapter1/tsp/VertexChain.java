package com.hugomfcruz.algodesign.chapter1.tsp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.hugomfcruz.algodesign.utils.Point;

public class VertexChain{
	private List<Vertex> vertexes = new ArrayList<>();
	
	public VertexChain() { }
	
	public VertexChain(Point point) {
		vertexes.add(new Vertex(point, this));
	}

	public List<Vertex> getVertexes(){
		return vertexes;
	}
	
	public void connectLeft(Vertex newPoint){
		vertexes.add(0, newPoint);
		newPoint.setChain(this);
	}
	
	public void connectRight(Vertex newPoint){
		vertexes.add(newPoint);
		newPoint.setChain(this);
	}
	
	public VertexChain connectLeft(VertexChain otherChain){
		return otherChain.connectRight(this);
	}
	
	public VertexChain connectRight(VertexChain otherChain){
		vertexes.addAll(otherChain.getVertexes());
		for (Vertex vertex : vertexes) {
			vertex.setChain(this);
		}
		return this;
	}
	
	public List<Vertex> getEdges(){
		
		return vertexes.size() == 1 ?
				Arrays.asList(vertexes.get(0)):
				Arrays.asList(vertexes.get(0), vertexes.get(vertexes.size()-1));
	}

	public VertexChain reverse() {
		Collections.reverse(vertexes);
		return this;
	}

	public List<Point> getPoints() {
		return vertexes.stream().map(v -> v.getPoint()).collect(Collectors.toList());
	}
	
	@Override
	public String toString() {
		return vertexes.stream().map(v -> v.getPoint()).collect(Collectors.toList()).toString();
	}
}
