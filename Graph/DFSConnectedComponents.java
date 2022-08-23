package Graph;

import java.util.ArrayList;

public class DFSConnectedComponents {
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

        System.out.println("Count: " + DFSConnectedComponentTraversal(adj, adj.size()));
    }

    static int DFSConnectedComponentTraversal(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean[] visited = new boolean[v];
        int count = 0;

        for (ArrayList<Integer> list : adj){
            for (int item : list) {
                if (!visited[item]) {
                    DFSPrint(adj, item, visited);
                    count++;
                }
            }
        }

        return count;
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
