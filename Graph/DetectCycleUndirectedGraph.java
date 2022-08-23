package Graph;

import java.util.ArrayList;

public class DetectCycleUndirectedGraph {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

//          0               4               7
//       /     \         /     \         /     \
//      1       2       5       6       8       9
//       \     /
//          3

        adj.add(new ArrayList<>() {{
            add(1);
            add(2);
        }});

        adj.add(new ArrayList<>() {{
            add(0);
            add(3);
        }});

        adj.add(new ArrayList<>() {{
            add(0);
            add(3);
        }});

        adj.add(new ArrayList<>() {{
            add(1);
            add(2);
        }});

        System.out.println(DFSDetectCycle(adj, adj.size()));
    }

    static boolean DFSDetectCycle(ArrayList<ArrayList<Integer>> adj, int size) {
        boolean[] visited = new boolean[size];

        for (int i=0; i<size; i++) {
            if (!visited[i]) {
                if (cycle(adj, i, visited, -1)) return true;
            }
        }

        return false;
    }

    static boolean cycle(ArrayList<ArrayList<Integer>> adj, int src, boolean[] visited, int parent) {
        visited[src] = true;

        for (int data : adj.get(src)) {
            if (!visited[data]) {
                if (cycle(adj, data, visited, src)) return true;
            }
            else if (data != parent) return true;
        }

        return false;
    }
}
