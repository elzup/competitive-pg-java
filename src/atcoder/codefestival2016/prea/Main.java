package atcoder.codefestival2016.prea;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        int[] a = new int[s.length()];
        String res = "";
        for (int i = 0; i < s.length() - 1; i++) {
            int n = toI(s.charAt(i));
            int fn = flipNeed(n) ;
            if (k >= 26) {
                res += "a";
                k -= fn;
            } else {
                if (fn <= k) {
                    k -= fn;
                    a[i] = 0;
                    res += "a";
                } else {
                    res += s.charAt(i);
                }
            }
        }

        k %= 26;
        res += toC((toI(s.charAt(s.length() - 1)) + k) % 26);
        System.out.println(res);

    }

    static String toC(int n) {
        return ((char) (n + 97)) + "";
    }

    static int toI(char c) {
        return (int) c - 97;
    }

    static int flipNeed(int n) {
        return 26 - n;
    }
}
