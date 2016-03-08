package euler;

import java.util.ArrayList;
import java.util.List;

public class Q007a10001stPrime {
    public static void main(String[] args) {
        ArrayList<Integer> primes = new ArrayList<>();
        int t = 10001;
        int c = 1;

        int i = 3;
        primes.add(2);

        while (c < t) {
            if (isPrime(i, primes)) {
                primes.add(i);
                c ++;
            }
            i ++;
        }
        System.out.println(i - 1);
    }

    public static boolean isPrime(int n, List<Integer> primes) {
        int t = (int) Math.floor(Math.sqrt(n));
        for (int p : primes) {
            if (t < p) {
                break;
            }
            if (n % p == 0) {
                return false;
            }
        }
        return true;
    }
}
