package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;

class TopologicalSortDFS
{
    //Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        ArrayDeque<Integer> stack = new ArrayDeque<>(V);
        boolean[] visited = new boolean[V];
        int[] list = new int[V];
        int index = 0;

        for (int i=0; i<V; i++) {
            if (!visited[i]) {
                DFS(adj, visited, stack, i);
            }
        }

        while (!stack.isEmpty()) {
            list[index++] = stack.pop();
        }

        return list;
    }

    static void DFS(ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayDeque<Integer> stack, int s) {
        visited[s] = true;

        for (int v : adj.get(s)) {
            if (!visited[v]) {
                DFS(adj, visited, stack, v);
            }
        }

        stack.push(s);
    }
}
