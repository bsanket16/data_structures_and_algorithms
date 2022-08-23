package Searching;

public class UnboundedBinarySearch {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int target = 20;

        if (arr[0] == target) {
            System.out.println(0);
        }
        else if (arr[1] == target) {
            System.out.println(1);
        }

        int i = 1;
        while (arr[i] < target) {
            i = i * 2;
            if (arr[i] == target) {
                System.out.println(i);
                break;
            }
        }

        if (arr[i] != target) System.out.println(binarySearch(arr, (i/2)+1, i-1, target));
    }

    static int binarySearch(int[] arr, int l, int r, int x) {
        while (l<=r) {
            int m = (l+r)/2;

            if (arr[m]==x) {
                return m;
            }
            else if (arr[m] > x) {
                r = m-1;
            }
            else {
                l = m+1;
            }
        }
        return -1;
    }
}
