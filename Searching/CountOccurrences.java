package Searching;

public class CountOccurrences {
    public static void main(String[] args) {
        int[] arr = {10, 10, 10, 10, 10};
        int target = 10;

        System.out.println(getCount(arr, target));
    }

    static int getCount(int[] arr, int target) {

        int first = getFirstOccurrenceIndex(arr, target);

        if (first == -1) return 0;
        else return ((getSecondOccurrenceIndex(arr, target) - first) + 1);
    }

    static int getFirstOccurrenceIndex(int[] arr, int target) {
        int low = 0;
        int high = arr.length-1;

        while (low<=high) {
            int mid = (low + high) / 2;
            if (arr[mid] > target) {
                high = mid - 1;
            }
            else if (arr[mid] < target) {
                low = mid + 1;
            }
            else {
                if (mid == 0 || arr[mid-1] != target) {
                    return mid;
                }
                else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    static int getSecondOccurrenceIndex(int[] arr, int target) {
        int low = 0;
        int high = arr.length-1;

        while (low<=high) {
            int mid = (low + high) / 2;
            if (arr[mid] > target) {
                high = mid - 1;
            }
            else if (arr[mid] < target) {
                low = mid + 1;
            }
            else {
                if (mid == arr.length-1 || arr[mid+1] != target) {
                    return mid;
                }
                else {
                    low = mid + 1;
                }
            }
        }

        return -1;
    }
}
