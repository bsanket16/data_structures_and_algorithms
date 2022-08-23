package Graph;

import java.util.*;
import java.lang.*;

class Kosaraju
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());

            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<>());

            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                int v = Integer.parseInt(sc.next());

                // adding directed edgese between
                // vertex 'u' and 'v'
                adj.get(u).add(v);
            }

            Solutions ob = new Solutions();
            System.out.println(ob.kosaraju(V, adj));
        }
    }
}


class Solutions
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        ArrayDeque<Integer> st = new ArrayDeque<>(V);
        boolean[] visited = new boolean[V];
        int res = 0;

        for (int i=0; i<V; i++){
            if (!visited[i]) {
                DFSs(adj, visited, st, i);
            }
        }


        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();

        for (int i=0; i<V; i++){
            transpose.add(new ArrayList<>());
        }

        for (int i=0; i<V; i++) {
            visited[i] = false;

            for (Integer it : adj.get(i)) {
                transpose.get(it).add(i);
            }
        }

        while (!st.isEmpty()) {
            int x = st.pop();
            if (!visited[x]) {
                res++;
                DFSRev(transpose, visited, x);
            }
        }

        return res;
    }

    public void DFSRev(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int s) {
        visited[s] = true;

        for (int v : adj.get(s)) {
            if (!visited[v]) {
                DFSRev(adj, visited, v);
            }
        }
    }

    public void DFSs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayDeque<Integer> st, int s) {
        visited[s] = true;

        for (int v : adj.get(s)) {
            if (!visited[v]) {
                DFSs(adj, visited, st, v);
            }
        }

        st.push(s);
    }
}
