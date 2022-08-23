package Arrays;

import java.util.Scanner;

public class Frequencies_In_A_Sorted_Array {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }

        getFrequencies(arr, n);
    }

    static void getFrequencies(int[] arr, int n) {
        int freq = 1;
        for (int i=1; i<n; i++) {
            if (arr[i] == arr[i-1]) {
                freq++;
            } else {
                System.out.println(arr[i-1] + " " + freq);
                freq = 1;
            }
        }
        System.out.println(arr[n-1] + " " + freq);
    }
}
