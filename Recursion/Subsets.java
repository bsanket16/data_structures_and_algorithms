package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2};
        System.out.println(subsets(nums));
    }

    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums) {

        List<Integer> temp = new ArrayList<>();
        subset(nums, 0, nums.length, temp);
        return res;
    }

    static void subset(int[] nums, int i, int n, List<Integer> temp) {
        if (i == n) {
            res.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[i]);

        subset(nums, i+1, n, temp);

        temp.remove(temp.size() - 1);

        subset(nums, i+1, n, temp);
    }
}
