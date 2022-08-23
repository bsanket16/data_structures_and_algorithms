package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Pair implements Comparable<Pair> {
    int val;
    int idx;

    Pair (int a, int b) {
        val = a;
        idx = b;
    }

    public int compareTo(Pair o) {
        return this.val - o.val;
    }
}

public class MinimumNumberOfSwapsToSort {
    public static void main(String[] args) {
        int[] num = {10, 19, 6, 3, 5};
        int n = num.length;

        System.out.println(getMinSwaps(num, n));
        System.out.println(getMinSwapsDup(num, n));
    }

    static int getMinSwapsDup(int[] num, int n) {
        Pair[] p = new Pair[n];
        boolean[] visited = new boolean[n];

        for (int i=0; i<n; i++){
            p[i] = new Pair(num[i], i);
        }

        Arrays.sort(p);

        int res = 0;

        for (int i=0; i<n; i++) {
            if (visited[i] || p[i].idx == i) {
                continue;
            }

            int cycleLen = 0;
            int j =i;
            while (!visited[j]) {
                visited[j] = true;
                cycleLen++;
                j = p[j].idx;
            }

            res+= cycleLen-1;
        }

        return res;
    }

    static int getMinSwaps(int[] num, int n) {
        ArrayList<Pair> pair = new ArrayList<>();

        for (int i=0; i<n; i++){
            pair.add(new Pair(num[i], i));
        }

        Collections.sort(pair);

        int cnt = 0;
        for (int i=0; i<n; i++) {
            if (pair.get(i).idx != i) {
                cnt++;
                Pair temp1 = pair.get(i);
                Pair temp2 = pair.get(pair.get(i).idx);
                pair.set(i, temp2);
                pair.set(temp1.idx, temp1);
                i--;
            }
        }

        return cnt;
    }
}
