package Sorting;

public class TripletWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, 8};
//        1 4 6 8 10 45
        int x = 986;

        System.out.println(findTriplet(arr, x));
        System.out.println(findTripletOptimized(arr, x));
    }

    static int findTriplet(int[] arr, int x) {
        int n = arr.length;

        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                for (int k=j+1; k<n; k++) {
                    if (arr[i] + arr[j] + arr[k] == x) return 1;
                }
            }
        }
        return 0;
    }

    static int findTripletOptimized(int[] arr, int x) {
        int n = arr.length;

        for (int i=n-1; i>=1; i--) {
            if (arr[i] > x) continue;
            int l=0, r = i-1;
            while (l<r) {
                if (arr[l] + arr[r] + arr[i] == x) return 1;
                else if (arr[l] + arr[r] + arr[i] > x) r--;
                else l++;
            }
        }
        return 0;
    }
}
