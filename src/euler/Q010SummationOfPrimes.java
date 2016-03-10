package euler;

import java.util.ArrayList;

public class Q010SummationOfPrimes {
    public static void main(String[] args) {
        int n = 10;
        n = 2000000;
        primes = new ArrayList<>();
        primes.add(2);
        primes.add(3);

        long sum = 5;

        for (int i = 5; i < n; i += 2) {
            if (isPrime(i)) {
                sum += i;
            }
            if (i % 1000 == 1) {
                System.out.println(sum);
            }
        }
        System.out.println(sum);
    }

    public static ArrayList<Integer> primes;

    public static boolean isPrime(int n) {
        int t = (int) Math.ceil(Math.sqrt(n));
        for (int i : primes) {
            if (i > t) {
                break;
            }
            if (n % i == 0) {
                return false;
            }
        }
        primes.add(n);
        return true;
    }
}
