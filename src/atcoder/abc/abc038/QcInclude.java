package atcoder.abc.abc038;

import java.util.Scanner;

public class QcInclude {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        long c = 0;
        long k = 0;
        for (int i = 1; i < n; i++) {
            k++;
            if (a[i] <= a[i - 1]) {
                // System.out.println(c);
                c += (k * (k + 1) / 2);
                k = 0;
            }
            // if (a[i + 1] <= a[i]) {
            //     continue;
            // }
            // // int k = a[i + 1] - a[i];
            // for (int j = i + 1; j < n; j++) {
            //     if (a[j] > a[j - 1]) {
            //         c++;
            //     } else {
            //         break;
            //     }
            // }
        }
        k ++;
        // System.out.println(c);
        // System.out.println(k);
        c += (k * (k + 1) / 2);
        System.out.println(c);
    }
}
