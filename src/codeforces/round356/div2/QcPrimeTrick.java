package codeforces.round356.div2;
import java.util.Scanner;

public class QcPrimeTrick {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};
        String COMPOSITE = "composite";
        String PRIME = "prime";
        int c = 0;
        for (int p : primes) {
            System.out.println(p);
            if (sc.next().equals("yes")) {
                if (p <= 7) {
                    System.out.println(p * p);
                    if (sc.next().equals("yes")) {
                        c++;
                    }
                }
                c++;
                if (c >= 2) {
                    answer(COMPOSITE);
                }
            }
        }
        answer(PRIME);
        // 10
        // 47, 41, 37 - 2
        // 31, 29, 23
        //
        //
    }

    public static void answer(String s) {
        System.out.flush();
        System.out.println(s);
        System.exit(0);
    }
}
