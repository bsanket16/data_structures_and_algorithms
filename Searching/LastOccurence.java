package Searching;

public class LastOccurence {
    public static void main(String[] args) {
        int[] arr = {1,2, 5, 5, 5, 5, 7, 10};
        int target = 5;

//        recursive way
        int l=0;
        int r=arr.length-1;
        System.out.println(binarySearchR(arr, target, l, r));
        System.out.println(binarySearch(arr, target));
    }

    static int binarySearchR(int[] arr, int target, int l, int r) {

        if (l>r) return -1;

        int mid = (l+r) / 2;

        if (arr[mid] > target) {
            return binarySearchR(arr, target, l, mid-1);
        }
        else if (arr[mid] < target) {
            return binarySearchR(arr, target, mid+1, r);
        }
        else {
            if (mid== arr.length-1 || arr[mid+1] != target) {
                return mid;
            } else {
                return binarySearchR(arr, target, mid+1, r);
            }
        }
    }

    static int binarySearch(int[] arr, int target) {

        int l=0;
        int r=arr.length-1;

        while(l<=r) {
            int mid = (l+r) / 2;

            if (arr[mid] > target) {
                r = mid-1;
            }
            else if (arr[mid] < target) {
                l = mid + 1;
            }
            else {
                if (mid == arr.length-1 || arr[mid+1] != target) {
                    return mid;
                }
                else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }
}
