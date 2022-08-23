package Arrays;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        int m = 3, n = 3;

        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int gap = (int) Math.ceil((double) (m+n) / 2.0);

        while (gap > 0) {

            int i=0, j=gap;

            while (j < m+n) {

                if (j < m && nums1[i] > nums1[j]) {

                    int temp = nums1[i];
                    nums1[i] = nums1[j];
                    nums1[j] = temp;

                }

                else if (i >= m && j >= m && nums2[i-n] > nums2[j-n]) {

                    int temp = nums2[i-n];
                    nums2[i-n] = nums2[j-n];
                    nums2[j-n] = temp;

                }

                else if (i < m && j>=m && nums1[i] > nums2[j-n]) {

                    int temp = nums1[i];
                    nums1[i] = nums2[j-n];
                    nums2[j-n] = temp;

                }

                i++;
                j++;
            }

            if (gap == 1) gap = 0;
            else gap = (int) Math.ceil((double) gap/2.0);
        }

        if (n >= 0) System.arraycopy(nums2, 0, nums1, m, n);
    }
}
