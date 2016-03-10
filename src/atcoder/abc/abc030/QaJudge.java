package atcoder.abc.abc030;

import java.util.Scanner;

public class QaJudge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int con = new Integer(a * d).compareTo(c * b);
        System.out.println(con == 0 ? "DRAW" : (con == 1 ? "AOKI" : "TAKAHASHI"));
    }
}
