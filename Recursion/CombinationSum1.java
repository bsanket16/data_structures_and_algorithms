package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum1 {
    public static void main(String[] args) {
        int[] candidates = {2, 3 ,5 ,7};
        Arrays.sort(candidates);
        int target = 7;

        List<List<Integer>> combinationList = new ArrayList<>();
        combinationSum(candidates, target, new ArrayList<>(), combinationList, 0);

        System.out.println(combinationList);
    }

    private static void combinationSum(int[] nums, int target, List<Integer> ds, List<List<Integer>> list, int idx) {

        if (target == 0) list.add(new ArrayList<>(ds));

        for (int i=idx; i<nums.length; i++) {

            if (i != idx && nums[i] == nums[i-1]) continue;

            if (target >= nums[i]) {
                ds.add(nums[i]);
                target -= nums[i];
                combinationSum(nums, target, ds, list, i);
                target += ds.get(ds.size()-1);
                ds.remove(ds.size()-1);
            }

        }
    }
}
