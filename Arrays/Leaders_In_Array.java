package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Leaders_In_Array {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.print("Leader in Array: ");
        getLeaders(arr, n);
    }

    static void getLeaders(int[] arr, int n) {
        int curr_lead = arr[n-1];
        System.out.print(curr_lead + " ");
        for (int i=n-2; i>=0; i--)  {
            if (arr[i] > curr_lead) {
                System.out.print(arr[i] + " ");
                curr_lead = arr[i];
            }
        }
    }
}
