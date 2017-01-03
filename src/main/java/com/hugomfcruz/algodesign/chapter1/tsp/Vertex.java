package com.hugomfcruz.algodesign.chapter1.tsp;

import com.hugomfcruz.algodesign.utils.Point;

public class Vertex {
	private Point point;
	private VertexChain chain;
	
	public Vertex(Point point, VertexChain chain) {
		this.point = point;
		this.chain = chain;
	}
	
	public Point getPoint(){
		return point;
	}
	
	public VertexChain getChain(){
		return chain;
	}
	
	public void setChain(VertexChain chain){
		this.chain = chain;
	}
	
	public double distance(Vertex otherVertex) {
		return point.distance(otherVertex.getPoint());
	}

	public void connect(Vertex v2) {
		if(chain.getVertexes().size() == 1){
			if(v2.isFirst()){
				chain = chain.connectRight(v2.chain);
			} else {
				chain = v2.chain.connectRight(chain);
			}
			return;
		}
		
		if(isFirst() && v2.isLast()){
			chain = v2.chain.connectRight(chain);
			return;
		}
		
		if(isFirst() && v2.isFirst()){
			v2.chain.reverse();
			chain = chain.connectRight(v2.chain);
			return;
		}
		
		if(isLast() && v2.isFirst()){
			chain = chain.connectRight(v2.chain);
			return;
		}
		
		if(isLast() && v2.isLast()){
			v2.chain.reverse();
			chain = chain.connectRight(v2.chain);
			return;
		}
		
		chain = chain.connectRight(v2.chain);
	}

	private boolean isLast() {
		return chain.getVertexes().get(chain.getVertexes().size() - 1) == this;
	}

	private boolean isFirst() {
		return chain.getVertexes().get(0) == this;
	}
	
	@Override
	public String toString() {
		return "x:" + point.left + " y:" + point.right;
	}
}