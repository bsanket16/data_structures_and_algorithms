package Graph;

import java.util.Arrays;

public class Dijkstra {
    public static void main(String[] args)
    {
        int[][] graph = new int[][] {
                    { 0, 50, 100, 0},
                    { 50, 0, 30, 200 },
                    { 100, 30, 0, 20 },
                    { 0, 200, 20, 0 },
                };

        int[] op = getShortestPath(graph);
        System.out.println(Arrays.toString(op));

    }

    static int[] getShortestPath(int[][] graph) {

        int[] dist = new int[graph.length];
        boolean[] fin = new boolean[graph.length];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        for (int count = 0; count < graph.length-1; count++) {
            int u = -1;

            for (int i=0; i<graph.length; i++) {
                if (!fin[i] && (u==-1 || dist[i] < dist[u])) {
                    u = i;
                }
            }

            fin[u] = true;

            for (int i=0; i<graph.length; i++){
                if (graph[u][i] != 0 && !fin[i]) {
                    dist[i] = Math.min(dist[i], dist[u] + graph[u][i]);
                }
            }
        }

        return dist;
    }
}
