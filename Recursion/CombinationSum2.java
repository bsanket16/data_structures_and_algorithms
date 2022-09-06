package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {

        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;

        Arrays.sort(candidates);

        List<List<Integer>> combinationList = new ArrayList<>();
        combinationSum(candidates, target, new ArrayList<>(), combinationList, 0);

        System.out.println(combinationList);
    }

    private static void combinationSum(int[] nums, int target, List<Integer> ds, List<List<Integer>> list, int idx) {

        if (target == 0) {
            list.add(new ArrayList<>(ds));
            return;
        }

        for (int i=idx; i<nums.length; i++) {

            if (i != idx && nums[i] == nums[i-1]) continue;

            if (target >= nums[i]) {
                ds.add(nums[i]);
                target -= nums[i];
                combinationSum(nums, target, ds, list, i+1);
                target += ds.get(ds.size()-1);
                ds.remove(ds.size()-1);
            }

        }
    }
}
