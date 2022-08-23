package Stack;

import java.util.ArrayDeque;

public class LargestRectangularAreaInHistogram {
    public static void main(String[] args) {
        int[] histogram = {6, 2, 5, 4, 1, 5, 6};
        System.out.println(getHistogramAreaNaive(histogram));
        System.out.println(getHistogramAreaBetter(histogram));
        System.out.println(getHistogramAreaEfficient(histogram));
    }

    static int getHistogramAreaNaive(int[] arr) {
        int res = 0;

        for (int i=0; i<arr.length; i++) {
            int curr = arr[i];

            for (int j=i-1; j>=0; j--) {
                if (arr[j] >= arr[i]) {
                    curr += arr[i];
                } else {
                    break;
                }
            }

            for (int j=i+1; j<arr.length; j++) {
                if (arr[j] >= arr[i]) {
                    curr += arr[i];
                } else {
                    break;
                }
            }

            res = Math.max(curr, res);
        }

        return res;
    }

    static int getHistogramAreaBetter(int[] arr) {
        int res = 0;
        int[] ps = previousList(arr);
        int[] ns = nextList(arr);

        for (int i=0; i<arr.length; i++) {
            int curr = (ns[i] - ps[i] - 1) * arr[i];
            res = Math.max(curr, res);
        }

        return res;
    }

    static int[] nextList(int[] arr) {
        ArrayDeque<Integer> s = new ArrayDeque<>();
        int[] res = new int[arr.length];

        res[arr.length-1] = arr.length;
        s.push(arr.length-1);

        for (int i=arr.length-2; i>=0; i--) {
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }

            res[i] = s.isEmpty() ? arr.length : s.peek();
            s.push(i);
        }

        return res;
    }

    static int[] previousList(int[] arr) {
        ArrayDeque<Integer> s = new ArrayDeque<>();
        int[] res = new int[arr.length];

        s.push(0);
        res[0] = -1;

        for (int i=1; i<arr.length; i++) {
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }

            res[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }

        return res;
    }

    static int getHistogramAreaEfficient(int[] arr) {
        ArrayDeque<Integer> s = new ArrayDeque<>();
        int res = 0;
        int top;
        int curr;

        for (int i=0; i<arr.length; i++) {
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                top = s.peek();
                s.pop();
                curr = arr[top] * ((s.isEmpty()) ? i : (i-s.peek()-1));
                res = Math.max(res, curr);
            }
            s.push(i);
        }

        while(!s.isEmpty()) {
            top = s.peek();
            s.pop();
            curr = arr[top] * ((s.isEmpty() ? arr.length : (arr.length - s.peek() - 1)));
            res = Math.max(res, curr);
        }

        return res;

    }
}
