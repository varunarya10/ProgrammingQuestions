// Graph DFS and BFS algorithms implemented on adjacency list

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

public class GraphBFSDFS {
	
	private LinkedList<Integer>[] adj;
	private int V;
	@SuppressWarnings("unchecked")
	public GraphBFSDFS(int v) {
		V = v;
		// Need to initialize the data structure
		adj = new LinkedList[V];
		for(int i = 0; i< V; i++) {
			// Need to initialize individual list
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int src, int dst) {
		adj[src].add(dst);
	}
	
	public void deleteEdge(int u, int v) {
		adj[u].remove(v);
	}
	
	public void printGraph() {
		for(int i = 0; i < V; i++) {
			System.out.println(i + " " + adj[i].toString());
		}
	}
	
	private void DFSUtil(int node, boolean[] visited) {
		visited[node] = true;
		System.out.println(node);
		
		ListIterator<Integer> iter = adj[node].listIterator();
		while(iter.hasNext()) {
			Integer elem = iter.next();
			if(visited[elem] == false) {
				DFSUtil(elem, visited);
			}
		}
		
	}
	
	public void DFS(int start) {
		boolean[] visited = new boolean[V];
		DFSUtil(start, visited);
	}
	
	public void BFS(int start) {
		boolean[] visited = new boolean[V];
		for(int i=0; i<V; i++) {
			visited[i] = false;
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		
		while(q.size() > 0) {
			Integer item = q.remove();
			visited[item] = true;
			System.out.println(item);
			ListIterator<Integer> it = adj[item].listIterator();
			
			while(it.hasNext()) {
				Integer elem = it.next();
				// System.out.println("Element in Queue " + elem);
				if(visited[elem] == false) {
					q.add(elem);
					// System.out.println("Element add Queue " + elem);
				}
			}
		}
		
	}

	public static void main(String[] args) {
		GraphBFSDFS g = new GraphBFSDFS(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		g.printGraph();
		g.BFS(2);
		g.DFS(2);

	}

}
