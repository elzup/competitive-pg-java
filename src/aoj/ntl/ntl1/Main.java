package aoj.ntl.ntl1;

import java.util.Scanner;

public class Main {
    public static final long mod7 = 1000000007L;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        System.out.println(power(n, m, mod7));
    }

    public static long power(long n, long k, long mod) {
        if (k == 0) {
            return 1;
        }
        if (k % 2 == 0) {
            long t = power(n, k / 2, mod);
            return ((t % mod) * (t % mod)) % mod;
        }
        return n * power(n, k - 1, mod) % mod;
    }
}
