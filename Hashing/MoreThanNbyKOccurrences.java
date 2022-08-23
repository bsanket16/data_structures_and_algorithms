package Hashing;

import java.util.HashMap;
import java.util.Map;

public class MoreThanNbyKOccurrences {
    public static void main(String[] args) {
        int[] arr = {30, 10, 20, 20, 10, 20, 30, 30};
        int k = 4;
        printNumbers(arr, k);
        printNByK(arr, arr.length, k);
    }

    static void printNumbers(int[] arr, int k) {
        for (int i=0; i<arr.length; i++) {
            boolean run = true;
            for (int p=0; p<i; p++) {
                if (arr[p] == arr[i]) {
                    run = false;
                    break;
                }
            }
            if (run) {
                int cnt = 0;
                for (int j=0; j<arr.length; j++) {
                    if (arr[i] == arr[j]) cnt++;
                }
                if (cnt > arr.length/k) System.out.print(arr[i] + " ");
            }
        }
    }

    static void printNByK(int arr[], int n, int k)
    {
        HashMap<Integer,Integer> m=new HashMap<Integer,Integer>();

        for(int i=0;i<n;i++){
            if(m.containsKey(arr[i])){
                int count=m.get(arr[i]);
                m.put(arr[i],count+1);
            }
            else if(m.size()<k-1)
                m.put(arr[i],1);
            else
                for(Map.Entry x:m.entrySet()){
                    Integer c=(Integer)x.getValue();
                    m.put((Integer)x.getKey(),c-1);
                    if((Integer)x.getKey()==0)
                        m.remove(x.getKey());}
        }
        for(Map.Entry x:m.entrySet()){
            int count=0;
            for(int i=0;i<n;i++){
                if((Integer)x.getKey()==arr[i])
                    count++;

            }
            if(count>n/k)
                System.out.print(x.getKey()+" ");
        }
    }
}
