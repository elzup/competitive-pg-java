package acm.domestic.y2006;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QaDhilikre {
    static List<Integer> primes;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        primes = new ArrayList<>();
        primes.add(2);

        while (true) {
            int a = sc.nextInt();
            int d = sc.nextInt();
            int n = sc.nextInt();
            if ((a | d | n) == 0) {
                break;
            }
            int c = 0;
            int i = a;
            while (true) {
                if (isPrime(i)) {
                    // System.out.println(i);
                    c++;
                    if (c == n) {
                        break;
                    }
                }
                i += d;
            }
            System.out.println(i);
        }
    }

    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        } else if (n == 2) {
            return true;
        } else if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
