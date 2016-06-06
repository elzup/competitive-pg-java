package aoj.alds1;

import java.util.Arrays;
import java.util.Scanner;

public class QbBinarySearch {
    static int[] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int q = sc.nextInt();
        int c = 0;
        for (int i = 0; i < q; i++) {
            int t = sc.nextInt();
            // Original
            c += binarySearchContains(t) ? 1 : 0;

            // Arrays.binarySearch
            // c += Arrays.binarySearch(a, t) >= 0 ? 1 : 0;
        }
        System.out.println(c);
    }

    public static boolean binarySearchContains(int v) {
        int l = 0; // left
        int r = a.length - 1; // right
        while (l <= r) {
            int m = (r + l) / 2;
            if (a[m] == v) {
                return true;
            }
            if (a[m] > v) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }
}
