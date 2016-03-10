package atcoder.arc.arc019;

import java.util.Scanner;

public class QbAnagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();

        long t = 0;
        int sl = s.length();
        boolean isOdd = false;

        if (sl % 2 == 1) {
            s = s.substring(0, sl / 2) + s.substring(sl / 2 + 1, sl);
            sl -= 1;
            isOdd = true;
        }
        // System.out.println(s);

        int p = 0;
        for (int i = 0; i < sl / 2; i++) {
            if (s.charAt(i) == s.charAt(sl - i - 1)) {
                p += 1;
            }
        }
        t += 25 * sl;
        if (sl / 2 - p == 1) {
            t -= 2;
        }
        if (sl / 2 - p != 0 && isOdd) {
            t += 25;
        }
        System.out.println(t);
    }
}

