package atcoder.mujin2016;

import java.util.Scanner;

public class QbArmRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int sum = a + b + c;
        int da = a - (b + c);
        int db = b - (c + a);
        int dc = c - (a + b);
        int d = Math.max(
                Math.max(0, da), Math.max(db, dc)
        );
        System.out.println((sum * sum - d * d) * Math.PI);
    }
}
