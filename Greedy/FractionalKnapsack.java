package Greedy;

import java.util.Arrays;
import java.util.Comparator;

class Pair
{
    int val;
    int wt;

    Pair(int a, int b) {
        this.val = a;
        this.wt = b;
    }
}

class cmp implements Comparator<Pair>
{
    public int compare(Pair q, Pair o) {
        return (o.val / o.wt) - (q.val / q.wt);
    }
}

public class FractionalKnapsack {

    public static void main(String[] args) {
        int[] value = new int[] { 12, 24, 20, 30, 27, 25 };
        int[] weight = new int[] { 6, 8, 4, 10, 7, 5};

        int knapsack = 30;
        int n = 6;

        System.out.println(getMaxValue(weight, value, knapsack, n));
    }

    static double getMaxValue(int[] weight, int[] value, int knapsack, int n) {
        Pair[] arr = new Pair[n];

        for (int i=0; i<n; i++) {
            arr[i] = new Pair(value[i], weight[i]);
        }

        Arrays.sort(arr, new cmp());

        double res = 0, cap = knapsack;

        for(int index = 0; index < n; index++) {
            if (arr[index].wt <= cap) {
                res += arr[index].val;
                cap -= arr[index].wt;
            } else {
                res += arr[index].val * (cap / (double) arr[index].wt);
                break;
            }
        }

        return res;
    }
}
