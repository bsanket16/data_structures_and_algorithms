package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationOptimized {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        permute(nums);
    }

    static void permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        allPermutations(0, nums, ans);
        System.out.println(ans);
    }

    static void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }

    static void allPermutations(int ind, int[] nums, List<List<Integer>> ans) {
        if (ind == nums.length) {
            List<Integer> ds = new ArrayList<>();
            for (int num : nums) ds.add(num);
            ans.add(ds);
            return;
        }

        for (int i=ind; i<nums.length; i++) {
            swap(nums, ind, i);
            allPermutations(ind+1, nums, ans);
            swap(nums, ind, i);
        }
    }
}
