package Graph;

import java.util.ArrayList;

public class BridgesInGraph {
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        addEdge(adj,0, 1);
        addEdge(adj,1, 2);
        addEdge(adj,1, 3);
        addEdge(adj,2, 3);
        addEdge(adj,1, 0);
        addEdge(adj,1, 1);
        addEdge(adj,3, 1);
        addEdge(adj,3, 2);

        printBridges(adj, V);
    }

    static void printBridges(ArrayList<ArrayList<Integer>> adj, int V) {
        int[] time = new int[V];
        int[] link = new int[V];
        boolean[] visited = new boolean[V];

        int timer = 0;

        for (int i=0; i<V; i++){
            if (!visited[i]) {
                DFSBridge(adj, i, -1, visited, time, link, timer);
            }
        }
    }

    static void DFSBridge(ArrayList<ArrayList<Integer>> adj, int u, int parent, boolean[] visited, int[] time, int[] link, int timer) {
        visited[u] = true;
        time[u] = link[u] = timer++;

        for (int v : adj.get(u)) {

            if (v == parent) continue;

            if (visited[v]) {
                link[u] = Math.min(link[u], time[v]);
            }

            else {
                DFSBridge(adj, v, u, visited, time, link, timer);
                link[u] = Math.min(link[u], link[v]);

                if (link[v] > time[u]) {
                    System.out.println("Bridge: " + u + " to " + v);
                }

            }
        }
    }
}
