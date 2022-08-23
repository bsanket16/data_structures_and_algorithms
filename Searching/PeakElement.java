package Searching;

public class PeakElement {
    public static void main(String[] args) {
        int[] arr = {29, 28, 27, 26, 25, 20, 10, 60, 75};

        System.out.println(findPeak(arr));
    }

    static int findPeak(int[] arr) {
        int low = 0;
        int high = arr.length-1;

        while (low<=high) {
            int mid = (low+high)/2;

            if ((mid==0 || arr[mid-1] <= arr[mid]) && (mid== arr.length-1 || arr[mid+1] <= arr[mid])) {
                return arr[mid];
            }
            else {
                if (mid > 0 && arr[mid-1] >= arr[mid]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}
