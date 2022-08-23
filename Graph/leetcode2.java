package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class leetcode2 {
    public static void main(String[] args) {

        int[][] edges = {
                {0,1},
                {0,2},
                {0,5},
                {0,4},
                {3,2},
                {6,5}
        };

        int[] restricted = {4, 2, 1};

        HashSet<Integer> hs = new HashSet<>();

        for (int j : restricted) {
            hs.add(j);
        }

            ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();

        for (int i=0; i<=edges.length; i++) {
            adj2.add(new ArrayList<>());
        }

        for (int[] edge : edges) {

            adj2.get(edge[0]).add(edge[1]);
            adj2.get(edge[1]).add(edge[0]);
        }

//        for (int i=0; i<adj2.size(); i++) {
//            System.out.println(adj2.get(i));
//        }

        System.out.println(reachableNodes(adj2.size(), edges, restricted));
    }

    public static int reachableNodes(int n, int[][] edges, int[] restricted) {

        HashSet<Integer> hs = new HashSet<>();

        for (int j : restricted) hs.add(j);

        ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();

        for (int i=0; i<=edges.length; i++) adj2.add(new ArrayList<>());

        for (int[] edge : edges) {
            adj2.get(edge[0]).add(edge[1]);
            adj2.get(edge[1]).add(edge[0]);
        }

        DFSTraversal(adj2, 0, adj2.size(), hs);

        return 0;
    }

    static void DFSTraversal(ArrayList<ArrayList<Integer>> adj, int s, int v, HashSet<Integer> hs) {
        boolean[] visited = new boolean[v];
        DFSPrint(adj, s, visited, hs);
        System.out.println(Arrays.toString(visited));
    }

    static void DFSPrint(ArrayList<ArrayList<Integer>> list, int s, boolean[] visited, HashSet<Integer> hs) {
        visited[s] = true;

        for (int adj : list.get(s)) {
            if (!visited[adj] && !hs.contains(adj)) {
                DFSPrint(list, adj, visited, hs);
            }
        }

    }
}
