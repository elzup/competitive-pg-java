package atcoder.abc.abc040;

import java.util.Scanner;

public class QaRedBlue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        System.out.println(Math.min(n - x, x - 1));
    }
}
