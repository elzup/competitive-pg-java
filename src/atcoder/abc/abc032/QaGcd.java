package atcoder.abc.abc032;

import java.util.Scanner;

public class QaGcd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        int t = a * b / gcd(a, b);
        int k = (n - 1) / t;
        System.out.println((k + 1) * t);
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
