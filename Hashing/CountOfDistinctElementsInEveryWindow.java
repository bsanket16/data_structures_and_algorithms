package Hashing;

import java.util.HashMap;

public class CountOfDistinctElementsInEveryWindow {
    public static void main(String[] args) {
        int[] arr = {10, 20, 20, 10, 30, 40, 10};
        int k = 4;
        printDistinct(arr, arr.length, k);
        System.out.println();
        printDistinctOptimized(arr, arr.length, k);
    }

    static void printDistinct(int[] arr, int n, int k) {
        for(int i=0;i<=n-k;i++){
            int count=0;
            for(int j=0;j<k;j++){
                boolean flag=false;
                for(int p=0;p<j;p++){
                    if(arr[i+j]==arr[i+p])
                    {
                        flag=true;break;
                    }
                }
                if(!flag)count++;

            }
            System.out.print(count+" ");
        }
    }

    static void printDistinctOptimized(int[] arr, int n, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i=0; i<k; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }

        System.out.print(hm.size() + " ");

        for (int i=k; i<n; i++) {
            hm.put(arr[i-k], hm.get(arr[i-k]) - 1);

            if (hm.get(arr[i-k]) == 0) hm.remove(arr[i-k]);

            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);

            System.out.print(hm.size() + " ");
        }
    }
}