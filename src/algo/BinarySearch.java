package algo;

import java.util.Scanner;

// 二分探索 BinarySearch
public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
        }
        int q = sc.nextInt();
        int[] t = new int[n];
        for (int i = 0; i < q; i++) {
            t[i] = sc.nextInt();
        }
        int c = 0;
        for (int i = 0; i < q; i++) {
            // if (Arrays.binarySearch(s, t[i]) >= 0) {
            //     c++;
            // }
            int left = -1;
            int right = n;
            while (right - left > 1) {
                int mid = left + (right - left) / 2;
                if (s[mid] == t[i]) {
                    c++;
                    break;
                } else if (s[mid] > t[i]) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
        }
        System.out.println(c);
    }
}
