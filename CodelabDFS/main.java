package CodelabDFS;

import java.util.*;

class DFSTraversal {
    private LinkedList<Integer> adj[];
    private boolean visited[];

    DFSTraversal(int V){
        adj = new LinkedList[V];
        visited = new boolean[V];

        for (int i = 0; i < V; i++)
            adj[i] = new LinkedList<Integer>();
    }

    void insertEdge(int src, int dest){
        adj[src].add(dest);
        adj[dest].add(src);  // Since it's an undirected graph, add both edges
    }

    void DFS(int vertex){
        visited[vertex] = true;
        System.out.print(vertex + " ");

        Iterator<Integer> it = adj[vertex].listIterator();
        while (it.hasNext()) {
            int n = it.next();
            if (!visited[n])
                DFS(n);
        }
    }

    public static void main(String args[]){
        DFSTraversal graph = new DFSTraversal(6); // There are 6 nodes, from 0 to 5

        graph.insertEdge(0, 1);
        graph.insertEdge(0, 4);
        graph.insertEdge(0, 5);
        graph.insertEdge(1, 2);
        graph.insertEdge(1, 5);
        graph.insertEdge(2, 3);
        graph.insertEdge(3, 2); // Note: in the graph, each edge should only be inserted once
        graph.insertEdge(4, 5);

        System.out.println("Depth First Traversal starting from node 3:");
        graph.DFS(3);
    }
}
