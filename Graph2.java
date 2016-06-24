// Implementation of Graph using Adjacency matrix


public class Graph2 {
	
	private int V;
	private int[][] adj;
	
	public Graph2(int v) {
		V = v;
		adj = new int[V][V];
		for(int i = 0; i < V; i++) {
			for(int j = 0; j < V; j++) {
				adj[i][j] = 0;
			}
		}
	}
	
	public void addEdge(int u, int v) {
		adj[u][v] = 1;
	}
	
	public void deleteEdge(int u, int v) {
		adj[u][v] = 0;
	}
	
	public void printGraph() {
		for(int i = 0; i < V; i++) {
			for(int j = 0; j < V; j++) {
				System.out.print(adj[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Graph2 g = new Graph2(5);
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
