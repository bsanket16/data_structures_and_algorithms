package String;

public class NthNumberMadeOfPrimeDigits {
    public static void main(String[] args) {
        int n = 75;
        System.out.println(primeDigits(n));
    }

    public static int primeDigits(int n)
    {
        StringBuilder res = new StringBuilder();

        while (n > 0) {
            int k = n % 4;

            switch(k) {
                case 1:
                    res.append('2');
                    break;

                case 2:
                    res.append('3');
                    break;

                case 3:
                    res.append('5');
                    break;

                default:
                    res.append('7');
                    break;
            }

            n--;
            n = n/4;
        }

        res.reverse();
        return Integer.parseInt(res.toString());
    }
}
