package Searching;

public class SearchInSortedRoatedArray {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 5, 8};
        int target = 5;

        System.out.println(search(arr, target));
    }

    static int search(int[] arr, int target) {
        int low = 0, high = arr.length-1;

        while (low<=high) {
            int mid = (low+high) / 2;

            if (arr[mid] == target) return mid;

            else if (arr[low] < arr[mid]) {
                if (arr[low] <= target && arr[mid] > target) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            else {
                if (arr[mid] < target && arr[high] >= target) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
