package acm.kyusyu2011;

import java.util.ArrayList;
import java.util.Scanner;

public class QaChebichef {
    static ArrayList<Integer> primes;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            primes = new ArrayList<>();
            int c = 0;
            for (int i = 1; i <= n * 2; i++) {
                boolean isP = isPrime(i);
                if (isP) {
                    primes.add(i);
                }
                if (n < i && isP) {
                    c++;
                }
            }
            System.out.println(c);
        }
    }

    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (int p: primes) {
            if (p > n * n) {
                break;
            }
            if (n % p == 0) {
                return false;
            }
        }
        return true;
    }
}
