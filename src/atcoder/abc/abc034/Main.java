package atcoder.abc.abc034;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        int k = (w + h - 1);
        int min = Math.min(w, h);
        int max = Math.max(w, h);
        int[] pre = new int[]{ 1 };
        for (int i = 2; i <= k; i++) {
            int ii = (i  + 1) / 2;
            int[] a = new int[ii];
            a[0] = 1;
            if (ii ==  1) {
                continue;
            }
            int ib = Math.max(1, i - max);
            int ie = Math.min(ii, min);
            // System.out.println(i + "(" + ii + "): " + ib + " -> " + (ie - 1));
            for (int j = ib; j < ie; j++) {
                if (j == ii - 1) {
                    if (i % 2 == 1) {
                        // System.out.println("---");
                        a[ii - 1] = (pre[ii - 2] * 2) % 1000000007;
                    } else {
                        a[ii - 1] = (pre[ii - 2] + pre[ii - 1]) % 1000000007;
                    }
                } else {
                    a[j] = (pre[j] + pre[j - 1]) % 1000000007;
                }
            }
            // printArray(a);
            pre = a;
        }
        System.out.println(pre[min - 1]);
    }

    static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
