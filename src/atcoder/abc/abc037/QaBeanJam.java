package atcoder.abc.abc037;

import java.util.Scanner;

public class QaBeanJam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(c / Math.min(a, b));
    }
}
