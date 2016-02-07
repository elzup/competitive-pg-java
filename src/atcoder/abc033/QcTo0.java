package atcoder.abc033;

import java.util.Scanner;

public class QcTo0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int c = 0;
        for (String t : s.split("\\+")) {
            if (t.indexOf("0") == -1) {
                c ++;
            }
        }
        System.out.println(c);
    }
}
