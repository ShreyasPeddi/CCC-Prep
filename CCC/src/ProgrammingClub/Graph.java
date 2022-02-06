package ProgrammingClub;

import java.util.LinkedList;

public class Graph {

	// Total number of nodes
	private static int nodes;

	// Adjacency List
	private static LinkedList<Integer> adj[];

	public Graph(int nodes) {

		this.nodes = nodes;

		// Set the size of adj
		adj = new LinkedList[nodes];

		// putting array list inside of the linked list
		for (int i = 0; i < nodes; i++) {

			adj[i] = new LinkedList();

		}

	}

	// Creating edges for undirected edges
	private static void addEdges(int node1, int node2) {

		adj[node1].add(node2);
		adj[node2].add(node1);
	}

	// checking for Eulerian path
	private static boolean checkEulerianPath() {

		//Amount of odd degrees 
		int odd = 0;
		
		// looking for as many nodes
		for (int i = 0; i < nodes; i++) {
			
			if(adj[i].size() % 2 != 1) {
				
				odd++;
				
			}

		}
		
		//checking how many nodes have odd edges
		if(odd>2)
			return false;
		
		//if true, this graph is a eulerian path
		else if(odd==2)
			return true;
		
		//if true, this graph is a eulerian circuit
		else if(odd==0)
			return true;
		
		return false;
	}
	
	public static void main(String[]args) {
		
		//5 nodes because our code assumes that out graphs start at node 0
		Graph g1 = new Graph(5);
		
		g1.addEdges(1, 2);
		g1.addEdges(2, 3);
		g1.addEdges(2, 4);
		g1.addEdges(3, 4);
		g1.addEdges(4, 1);
		g1.addEdges(4, 2);
		
		
		if(checkEulerianPath()) {
			System.out.println("Has a eulerian path");
		}
	}

}
