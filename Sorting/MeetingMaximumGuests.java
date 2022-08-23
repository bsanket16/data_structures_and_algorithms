package Sorting;

import java.util.Arrays;

public class MeetingMaximumGuests {
    public static void main(String[] args) {
        int[] arr = {900, 940};
        int[] dept = {1000, 1030};

        System.out.println(meetGuests(arr, dept));
    }

    static int meetGuests(int[] arr, int[] dept) {
        Arrays.sort(arr);
        Arrays.sort(dept);

        int n = arr.length, m = dept.length;
        int i = 1, j = 0, mx = 1, curr = 1;

        while (i < n && j < m) {
            if (arr[i] <= dept[j]) {
                curr++;
                i++;
            }
            else {
                curr--;
                j++;
            }
            mx = Math.max(mx, curr);
        }
        return mx;
    }
}
