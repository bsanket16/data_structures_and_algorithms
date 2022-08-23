package Arrays;

public class MakeArrayZero {
    public static void main(String[] args) {
        int[] nums = {1,5,0,3,5};
        System.out.println(minimumOperations(nums));
    }
    public static int minimumOperations(int[] nums) {

        int res = 0;

        for (int i=0; i<nums.length; i++) {

            int sm = findSmallest(nums);
            if (sm == Integer.MAX_VALUE) return res;
            boolean allZeros = true;

            for (int j=0; j<nums.length; j++) {


                if (nums[j] != 0) {
                    nums[j] -= sm;
                    allZeros = false;
                }

            }

            if (allZeros) break;
            else res++;
        }

        return res;
    }

    public static int findSmallest(int[] nums) {

        int sm = Integer.MAX_VALUE;

        for (int i=0; i<nums.length; i++) {

            if (nums[i] != 0) {

                sm = Math.min(sm, nums[i]);
            }
        }

        return sm;
    }
}
