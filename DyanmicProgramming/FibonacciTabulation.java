package DyanmicProgramming;

public class FibonacciTabulation {
    public static void main(String[] args) {
        int n = 9;
        int[] fib = new int[n+1];
        System.out.println(getFib(n, fib));
    }

    private static int getFib(int n, int[] fib) {

        fib[0] = 0;
        fib[1] = 1;

        for (int i=2; i<=n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }

        return fib[n];
    }
}
