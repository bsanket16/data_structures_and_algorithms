package Matrix;

import java.util.HashMap;
import java.util.Map;

public class NodeWithHighestScore {
    public static void main(String[] args) {

        int[] edges = {3, 0,0,0,0};
        System.out.println(edgeScore(edges));
    }

    private static int edgeScore(int[] edges) {

        HashMap<Integer, Long> hm = new HashMap<>();

        for (int i=0; i<edges.length; i++) {
            if (hm.containsKey(edges[i])) {
                long val = hm.get(edges[i]);
                hm.put(edges[i], val + i);
            } else {
                hm.put(edges[i], (long) i);
            }
        }

        long mx = 0;
        int curr = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Long> e : hm.entrySet()) {

            if (mx < e.getValue()) {
                mx = e.getValue();
                curr = e.getKey();
            } else if (mx == e.getValue()) {
                if (curr > e.getKey()) {
                    curr = e.getKey();
                }
            }
        }

        return curr;
    }
}
