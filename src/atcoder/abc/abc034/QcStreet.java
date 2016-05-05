package atcoder.abc.abc034;

import java.util.Scanner;

public class QcStreet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt() - 1;
        int h = sc.nextInt() - 1;
        System.out.println(modComb(w + h, w, 1000000007));
    }

    // mod combination
    static long modComb(long a, long b, long mod) {
        long res = 1;
        for (long i = a; i > a - b; i--) {
            res = (res * i) % mod;
        }
        for (long i = b; i > 1; i--) {
            res = (res * inv(i, mod)) % mod;
        }
        return res;
    }

    static long inv(long a, long mod) {
        return powMod(a, mod - 2, mod);
    }

    // a ^ b (mod p)
    static long powMod(long a, long b, long p) {
        if (b == 0) {
            return 1;
        }
        if (b % 2 == 0) {
            long d = powMod(a, b / 2, p);
            return d * d % p;
        }
        return a * powMod(a, b - 1, p) % p;
    }
}
