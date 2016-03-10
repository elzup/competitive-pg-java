package atcoder.arc.arc009;

import java.util.*;

public class QbAtcoderNumber {
    public static String lib;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        lib = "";
        for (int i = 0; i < 10; i++) {
            lib += sc.next();
        }
        // System.out.println(lib);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            // System.out.println(s);
            a[i] = Integer.valueOf(encode(s));
        }
        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            System.out.println(decode(String.valueOf(a[i])));
        }
    }

    public static String decode(String k) {
        String t = "";
        for (int i = 0; i < k.length(); i++) {
            t += lib.charAt(Integer.valueOf("" + k.charAt(i))) + "";
        }
        return t;
    }

    public static String encode(String k) {
        String t = "";
        for (int i = 0; i < k.length(); i++) {
            t += lib.indexOf(k.charAt(i) + "");
        }
        return t;
    }

}
