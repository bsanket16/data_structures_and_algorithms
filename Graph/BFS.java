package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
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

//        printGraph(adj);

        BFSTraversal(adj, 0, adj.size());
    }

    static void BFSTraversal (ArrayList<ArrayList<Integer>> list, int s, int v) {
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(s);
        visited[s] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.print(curr + " ");

            for (int adj : list.get(curr)) {
                if (!visited[adj]) {
                    queue.add(adj);
                    visited[adj] = true;
                }
            }
        }
    }

    static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        for (ArrayList<Integer> list : adj) {
            System.out.println(list);
        }
    }
}
