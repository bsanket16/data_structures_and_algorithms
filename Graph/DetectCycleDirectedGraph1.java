package Graph;

import java.util.ArrayList;

public class DetectCycleDirectedGraph1 {
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

        System.out.println(DFSDetectCycle1(adj, adj.size()));
    }

    static boolean DFSDetectCycle1(ArrayList<ArrayList<Integer>> adj, int size) {
        boolean[] visited = new boolean[size];
        boolean[] rec = new boolean[size];

        for (int i=0; i<size; i++) {
            if (!visited[i]) {
                if (cycle1(adj, i, visited, rec)) return true;
            }
        }

        return false;
    }

    static boolean cycle1(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited, boolean[] rec) {
        visited[s] = true;
        rec[s] = true;

        for (int x : adj.get(s)) {
            if (!visited[x] && cycle1(adj, x, visited, rec)) return true;
            else if (rec[s]) return true;
        }

        rec[s] = false;
        return false;
    }
}
