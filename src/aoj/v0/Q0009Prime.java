package aoj.v0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q0009Prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        primeLib = new ArrayList<>();
        primeLib.add(2);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(primeCountFor(n));
        }
    }

    public static ArrayList<Integer> primeLib;
    public static int checkedMax = 0;

    public static int primeCountFor(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        int l = primeLib.get(primeLib.size() - 1);
        // System.out.println(n + ":" + l);
        if (n <= l) {
            int i = Arrays.binarySearch(primeLib.toArray(), n);
            // System.out.println("under: " + n);
            // System.out.println(i);
            if (i < 0) {
                return ~i;
            }
            return i + 1;
        }
        int c = primeLib.size();
        for (int i = l + 1; i <= n; i++) {
            if (isPrime(i)) {
                c++;
            }
        }
        return c;
    }

    public static boolean isPrime(int n) {
        if (n <= checkedMax) {
            return primeLib.contains(n);
        }
        if (n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        int l = (int) Math.sqrt(n);
        for (int i = 3; i <= l; i += 2) {
            if (n % i == 0) {
                checkedMax = Math.max(checkedMax, n);
                return false;
            }
        }
        primeLib.add(n);
        return true;

    }
}
