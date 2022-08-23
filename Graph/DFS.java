package Graph;

import java.util.ArrayList;

public class DFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

//             1 -- 3
//           /        \
//          0 - - - -  5
//           \        /
//             2 -- 4

        adj.add(new ArrayList<>() {{
            add(1);
            add(2);
            add(5);
        }});

        adj.add(new ArrayList<>() {{
            add(0);
            add(3);
        }});

        adj.add(new ArrayList<>() {{
            add(0);
            add(4);
        }});

        adj.add(new ArrayList<>() {{
            add(1);
            add(5);
        }});

        adj.add(new ArrayList<>() {{
            add(2);
            add(5);
        }});

        adj.add(new ArrayList<>() {{
            add(0);
            add(3);
            add(4);
        }});

        DFSTraversal(adj, 0, adj.size());
    }

    static void DFSTraversal(ArrayList<ArrayList<Integer>> adj, int s, int v) {
        boolean[] visited = new boolean[v];
        DFSPrint(adj, s, visited);
    }

    static void DFSPrint(ArrayList<ArrayList<Integer>> list, int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s + " ");

        for (int adj : list.get(s)) {
            if (!visited[adj]) {
                DFSPrint(list, adj, visited);
            }
        }
    }
}
