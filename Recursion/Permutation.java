package Recursion;

import java.util.*;

public class Permutation {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        permute(nums);
    }

    static void permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];

        allPermutations(nums, ds, ans, freq);
        System.out.println(ans);
    }

    static void allPermutations(int[] nums, List<Integer> ds, List<List<Integer>> ans, boolean[] freq) {
        if (ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (!freq[i]) {
                freq[i] = true;
                ds.add(nums[i]);
                allPermutations(nums, ds, ans, freq);
                freq[i] = false;
                ds.remove(ds.size()-1);
            }
        }
    }
}
