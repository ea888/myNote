package interview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Graph {

	class Vertex implements Comparable<Vertex>{
		int id;	
		int minDistance = 65536; //set to infinite
		
		public Vertex(int id){
			this.id = id;
		}
		
		@Override
		public int compareTo(Vertex o) {			
			return Integer.compare(id, o.id);
		}
	}
	
	class Edge{
		int id;
		int from;
		int to;
		int distance;
	}
	
	private List<Vertex> vertexes = new LinkedList<Vertex>(); 
	private List<Vertex> processedVs = new ArrayList<Vertex>(); 
	private List<Edge> edges = new LinkedList<Edge>(); 
	
	//init vertices and edges
	public Graph(){
		
		for(int i=0; i<7; i++){
			Vertex v = new Vertex(i);
			vertexes.add(v);
		}
			
		Edge e = new Edge();
		e.id = 0;
		e.from = 0;
		e.to = 1;
		e.distance = 2;
		edges.add(e);
			
		Edge e1 = new Edge();
		e1.id = 1;
		e1.from = 0;
		e1.to = 2;
		e1.distance = 3;
		edges.add(e1);		
		
		Edge e2 = new Edge();
		e2.id = 2;
		e2.from = 1;
		e2.to = 3;
		e2.distance = 1;
		edges.add(e2);		
		
		Edge e3 = new Edge();
		e3.id = 3;
		e3.from = 3;
		e3.to = 6;
		e3.distance = 7;
		edges.add(e3);		
		
		Edge e4 = new Edge();
		e4.id = 4;
		e4.from = 1;
		e4.to = 5;
		e4.distance = 1;
		edges.add(e4);		
		
		Edge e5 = new Edge();
		e5.id = 5;
		e5.from = 5;
		e5.to = 4;
		e5.distance = 2;
		edges.add(e5);		
		
		Edge e6 = new Edge();
		e6.id = 6;
		e6.from = 4;
		e6.to = 6;
		e6.distance = 4;
		edges.add(e6);		
		
		Edge e7 = new Edge();
		e7.id = 7;
		e7.from = 2;
		e7.to = 4;
		e7.distance = 2;
		edges.add(e7);		
				
	}

	//find min path from one vertex to another
	public void findMinPath(int from, int to){
		boolean run = false;
		Iterator<Vertex> it = this.vertexes.iterator();
		while(it.hasNext()){
			Vertex vFrom = it.next();
			//loop vertices and find the starting point
			if(vFrom.id == from){
				vFrom.minDistance = 0;
				run = true;
			}
			
			//starting vertex found, processing
			if(run){			
				Iterator<Edge> itE = this.edges.iterator();	
				//loop edges
				while(itE.hasNext()){
					Edge e = itE.next();
					if(e.from == vFrom.id){//edge outgoing from current vertex
						Vertex vTo = this.findVertex(e.to);//find connected vertex
						if(null != vTo)
							//the last vertex has no more connections
							//The min distance from starting point is always initialized as infinite
							//the first round of loop will set the a min distance (not necessarily right)
							//then loop all possibilities will find the smallest distance 
							vTo.minDistance = Math.min(vTo.minDistance, vFrom.minDistance+e.distance);
					}
				}
				
				//remove vertex from unprocessed list
				it.remove();
				//add the processed vertex to list
				this.processedVs.add(vFrom);
			}
		}
		
		
	}
	
	//print all vertices including the min distance from starting point
	public void printAllVertexs(){
		System.out.println("Processed vertexes:");
		for(Vertex v: this.processedVs){
			System.out.println("id:"+v.id+" distance:"+v.minDistance);
		}
		
		System.out.println("Unprocessed vertexes:");
		for(Vertex v: this.vertexes){
			System.out.println("id:"+v.id+" distance:"+v.minDistance);
		}
	}
	
	//find vertex based on id
	private Vertex findVertex(int id){
		for(Vertex v: this.vertexes){
			if(v.id == id)
				return v;
		}
		
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph();
		g.findMinPath(1, 6);
		g.printAllVertexs();
	}

}
