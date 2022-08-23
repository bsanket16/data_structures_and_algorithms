package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSConnectedComponents {
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

        adj.add(new ArrayList<>() {{
            add(5);
            add(6);
        }});

        adj.add(new ArrayList<>() {{
            add(4);
        }});

        adj.add(new ArrayList<>() {{
            add(4);
        }});

        adj.add(new ArrayList<>() {{
            add(8);
            add(9);
        }});

        adj.add(new ArrayList<>() {{
            add(7);
        }});

        adj.add(new ArrayList<>() {{
            add(7);
        }});

        System.out.println("Count: " + BFSConnectedComponentTraversal(adj, adj.size()));
    }

    static int BFSConnectedComponentTraversal(ArrayList<ArrayList<Integer>> list, int v) {
        boolean[] visited = new boolean[v];
        int count = 0;

        for (int i = 0; i<v; i++) {
            if (!visited[i]) {
                count++;
                BFSTraversalForCC(list, i, visited);
            }
        }

        return count;
    }

    static void BFSTraversalForCC (ArrayList<ArrayList<Integer>> list, int s, boolean[] visited) {
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
}
