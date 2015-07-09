package aoj.v0;

import java.util.Scanner;

public class Q0005GCDandLCM {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        while (sn.hasNext()) {
            long a = sn.nextLong();
            long b = sn.nextLong();
            System.out.printf("%d %d\n", gcd(a, b), lcm(a, b));
        }
    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
}
