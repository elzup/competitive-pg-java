package atcoder.arc.arc047;

import java.util.Scanner;

public class QaTabQlash {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        String s = sc.next();

        int cur = 1;
        int c = 0;
        for (int i = 0; i < n; i++) {
            char q = s.charAt(i);
            if (q == '+') {
                cur ++;
                if (cur == l + 1) {
                    c ++;
                    cur = 1;
                }
            } else {
                cur --;
            }
        }
        System.out.println(c);
    }
}
