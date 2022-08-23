package Graph;

import java.util.*;


public class ShortestPathInUnweightedGraph {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        addEdge(adj,0, 1);
        addEdge(adj,0, 2);
        addEdge(adj,1, 2);
        addEdge(adj,1, 3);
        addEdge(adj,2, 3);

        System.out.println(Arrays.toString(shortestDistance(adj, V)));
    }

    static int[] shortestDistance(ArrayList<ArrayList<Integer>> adj, int V) {
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[0] = 0;

        while(!queue.isEmpty()) {
            int u = queue.poll();

            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    dist[v] = dist[u] + 1;
                    queue.offer(v);
                }
            }
        }

        return dist;
    }
}
