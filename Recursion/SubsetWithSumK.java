package Recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetWithSumK {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        int sum = 2;
        System.out.println(subsets(nums, sum));
    }

    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums, int sum) {

        List<Integer> temp = new ArrayList<>();
        int currSum = 0;
        subset(nums, 0, nums.length, temp, sum, currSum);
        return res;
    }

    static void subset(int[] nums, int i, int n, List<Integer> temp, int sum, int currSum) {
        if (i == n) {
            if (sum == currSum) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }

        temp.add(nums[i]);
        currSum += nums[i];

        subset(nums, i+1, n, temp, sum, currSum);

        currSum -= temp.get(temp.size() - 1);
        temp.remove(temp.size() - 1);

        subset(nums, i+1, n, temp, sum, currSum);
    }
}
