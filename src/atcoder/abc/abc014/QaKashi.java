package atcoder.abc.abc014;

import java.util.Scanner;

public class QaKashi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println((b - a % b) % b);
    }
}
