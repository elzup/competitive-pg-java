package atcoder.arc.arc011;

import java.util.Scanner;

public class QaSuperPencilTailRecursion {
    public static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        int num = sc.nextInt();
        System.out.println(sell(num, num));
    }

    public static int sell(int num, int res) {
        if (num < m) {
            return res;
        }
        int least = num % m;
        int sold = (num / m) * n;
        return sell(sold + least, sold + res);
    }
}
