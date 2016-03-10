package atcoder.arc.arc039;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        if (n > k) {
            System.out.println();
            return;
        }
        if (n > k) {
            System.out.println(1);
            return;
        }

        int a = k / n;
        int t = (k - a * n);
        int tp = n - t;
        if (tp == 0) {
            System.out.println(1);
            return;
        }
        int tm = Math.max(t, tp);
        int km = Math.min(t, tp);
        long s = 1;

        ArrayList<Integer> kms = new ArrayList<Integer>();
        for (int i = 2; i <= km; i++) {
            kms.add(i);
        }
        for (int i = 0; i < tm; i ++) {
            int ip = (n - i);

            ArrayList<Integer> removes = new ArrayList<Integer>();
            s = (s * ip);
            for (Integer ch : kms) {
                if (s % ch == 0) {
                    s /= ch;
                    removes.add(ch);
//                    System.out.println(":" + ch);
                }
            }
            kms.removeAll(removes);
            s %= 1000000007;
//            System.out.println(s);
        }
        System.out.println(s);
    }
}
