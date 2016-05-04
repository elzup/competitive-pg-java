package atcoder.abc.abc034;

import java.util.Scanner;

public class QbPair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        System.out.println(((t % 2) * 2 - 1) + t);
    }
}
