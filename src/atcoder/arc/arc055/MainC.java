package atcoder.arc.arc055;

import java.util.Scanner;

public class MainC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int l = s.length();
        int res = 0;
        for (int i = l / 2 + 1; i < l - 1; i++) {
            String t = s.substring(i);
            // System.out.println();
            // System.out.println(t);
            for (int j = 1; j < t.length(); j++) {
                int cl = t.length() - j;
                String aj = t.substring(0, j);
                String cj = t.substring(t.length() - cl);

                String as = s.substring(0, j);
                String cs = s.substring(i - cl, i);
                // System.out.println(aj + ", " + cj + ", " + as + ", " + cs);
                if (aj.equals(as) && cj.equals(cs)) {
                    res ++;
                }
            }
        }
        System.out.println(res);
    }
}
