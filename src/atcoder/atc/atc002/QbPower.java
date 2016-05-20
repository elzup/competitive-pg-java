package atcoder.atc.atc002;

import java.util.Scanner;

public class QbPower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        long p = sc.nextLong();
        System.out.println(power(n, p, m));
    }

    public static long power(long n, long k, long mod) {
        if (k == 0) {
            return 1;
        } else if (k % 2 == 0) {
            long t = power(n, k / 2, mod);
            return ((t % mod) * (t % mod)) % mod;
        }
        return n * power(n, k - 1, mod) % mod;
    }
}
