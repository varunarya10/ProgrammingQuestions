// Implementation of Graph using Adjecency List
import java.util.LinkedList;

public class Graph {
	
	private LinkedList<Integer>[] nodes;
	private int V;
	@SuppressWarnings("unchecked")
	public Graph(int v) {
		V = v;
		// Need to initialize the data structure
		nodes = new LinkedList[V];
		for(int i = 0; i< V; i++) {
			// Need to initialize individual list
			nodes[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int src, int dst) {
		nodes[src].add(dst);
	}
	
	public void deleteEdge(int u, int v) {
		nodes[u].remove(v);
	}
	
	public void printGraph() {
		for(int i = 0; i < V; i++) {
			System.out.println(i + " " + nodes[i].toString());
		}
	}

	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(0, 4);
		g.addEdge(1, 0);
		g.addEdge(1, 4);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		g.addEdge(3, 4);
		g.addEdge(3, 2);
		g.addEdge(4, 3);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.printGraph();

	}

}
