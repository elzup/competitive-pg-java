package atcoder.arc002;

import java.util.ArrayList;
import java.util.Scanner;

public class QcCommand2 {

    public static String s;
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.next();
        // int res = dp("AB", "BA", 0, 0);
        ArrayList<String> li = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            String t = s.substring(i, i + 2);
            if (!li.contains(t)) {
                li.add(t);
            }
        }
        li.add("ZZ");
        int res = Integer.MAX_VALUE;
        for (int i = 0, l = li.size(); i < l; i++) {
            String as = li.get(i);
            for (int j = 0; j < l; j++) {
                String bs = li.get(j);
                res = Math.min(res, count(as, bs));
            }
        }
        System.out.println(res);

    }

    public static int count(String a, String b) {
        String t = s;
        t = t.replace(a, "_");
        t = t.replace(b, "_");
        return t.length();
    }

}

/*
8
ABABBABA

18
ABABBABAYYBABAABAB

__BB_A
YY
B

8
AAAAAAAA

13
ABABABABXBXBX
 */

