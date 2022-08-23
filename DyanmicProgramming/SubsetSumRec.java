package DyanmicProgramming;

public class SubsetSumRec {
    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 8, 10};
        int sum = 11;
        int n = arr.length;

        System.out.println(isSubsetSum(arr, n, sum));
    }

    private static int isSubsetSum(int[] arr, int n, int sum) {

        if (n==0) {
            return sum==0 ? 1 : 0;
        }

        return isSubsetSum(arr, n-1, sum) + isSubsetSum(arr, n-1, sum - arr[n-1]);
    }
}
