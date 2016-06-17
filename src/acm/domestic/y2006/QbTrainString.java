package acm.domestic.y2006;

import java.util.ArrayList;
import java.util.Scanner;

public class QbTrainString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            System.out.println(solve(line));
        }
    }

    static int solve(String s) {
        ArrayList<String> list = new ArrayList<>();
        list.add(s);
        for (int i = 1; i < s.length(); i++) {
            String a = s.substring(0, i);
            String b = s.substring(i);
            String revA = new StringBuilder(a).reverse().toString();
            String revB = new StringBuilder(b).reverse().toString();
            String[] res = new String[] {
                    a + revB,
                    revA + revB,
                    revA + b,
                    b + revA,
                    revB + revA,
                    revB + a,
                    b + a
            };
            for (String r: res) {
                if (!list.contains(r)) {
                    list.add(r);
                }
            }
        }
        return list.size();
    }
}
