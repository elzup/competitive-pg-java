package atcoder.abc.abc035;

import java.util.Scanner;

public class QaTv {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        int gcd = (int) gcd(w, h);
        System.out.println((w / gcd) + ":" + (h / gcd));
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
