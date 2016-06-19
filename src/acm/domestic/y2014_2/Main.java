package acm.domestic.y2014_2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.next();
            if ("#".equals(s)) {
                break;
            }
            int l = 1 << s.length();
//            Queue<String> pq = new PriorityQueue<>();
            ArrayList<String> pq = new ArrayList<>();
            int cc = 0;
            for (int i = 0; i < l; i++) {
                String t = shift(s, i);
                if (encrypt(t).equals(s)) {
                    cc ++;
                    if (cc <= 5 && !pq.contains(t)) {
                        pq.add(t);
                        if (cc >= 10) {
                            pq.remove(5);
                        }
                    }
                }
            }
            int kk = 0;
            for (int i = l; i >= 0; i--) {
                String t = shift(s, i);
                if (encrypt(t).equals(s)) {
                    kk ++;
                    if (!pq.contains(t)) {
                        pq.add(t);
                    }
                    if (kk == 5) {
                        break;
                    }
                }
            }
            Collections.sort(pq);

            // int b = pq.size();
            System.out.println(cc);
            for (String res: pq) {
                System.out.println(res);
            }
            // System.out.println(encrypt(s));
        }
    }

    static String shift(String s, int k) {
        String t = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(s.length() - i - 1);
            if (c != 'z' && ((k >> i) & 1) == 1) {
                t = ((char) (c + 1)) + t;
            } else {
                t = c + t;
            }
        }
        return t;
    }

    static String encrypt(String s) {
        for (char c = 'b'; c <= 'z'; c++) {
            int i = s.indexOf(c + "");
            if (i == -1) {
                continue;
            }
            s = s.substring(0, i) + ((char) (c - 1)) + s.substring(i + 1);
        }
        return s;
    }
}
