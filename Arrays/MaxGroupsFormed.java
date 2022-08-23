package Arrays;

import java.util.PriorityQueue;

public class MaxGroupsFormed {
    public static void main(String[] args) {
        int[] grades = {10,6,12,7,3,5,5};
        System.out.println(maximumGroups(grades));
    }

    public static int maximumGroups(int[] grades) {

        int res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int grade : grades) {
            pq.offer(grade);
        }
        int cnt = 1;

        while (!pq.isEmpty()) {

            int popper = cnt;

            while (!pq.isEmpty() && popper > 0) {
                pq.poll();
                popper--;
            }

            cnt++;
            if (popper==0) res++;
        }

        return res;
    }
}
