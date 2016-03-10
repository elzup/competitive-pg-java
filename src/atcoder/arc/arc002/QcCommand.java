package atcoder.arc.arc002;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class QcCommand {
    public static String s;
    public static int n;
    public static Map<String, Integer> memo;

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
        int res = Integer.MAX_VALUE;
        for (int i = 0, l = li.size(); i < l; i++) {
            String as = li.get(i);
            System.out.println(as);
            for (int j = i + 1; j < l; j++) {
                String bs = li.get(j);
                if (as.equals(bs)) {
                    continue;
                }
                memo = new HashMap<>();
                res = Math.min(res, dp(as, bs, 0, 0));
            }
        }
        System.out.println(res);

    }

    public static int dp(String a, String b, int pos, int t) {
        String key = pos + ":" + t;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (pos == n) {
            return t;
        }
        if (pos == n - 1) {
            return dp(a, b, pos + 1, t + 1);
        }
        int min = Integer.MAX_VALUE;
        String targ = s.substring(pos, pos + 2);
        if (targ.equals(a) || targ.equals(b)) {
            min = Math.min(min, dp(a, b, pos + 2, t + 1));
        }
        min = Math.min(min, dp(a, b, pos + 1, t + 1));
        memo.put(key, min);
        return min;
    }
}

/*
8
ABABBABA

13
ABABABABXBXBX
 */