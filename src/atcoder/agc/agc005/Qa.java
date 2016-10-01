package atcoder.agc.agc005;

import java.util.Scanner;

public class Qa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.next();
        int len = x.length();
        int sstack = 0;
        int c = 0;
        for (int i = 0; i < len; i++) {
            if (x.charAt(i) == 'S') {
                sstack ++;
            }
            if (x.charAt(i) == 'T') {
                if (sstack > 0) {
                    sstack --;
                    c += 2;
                }
            }
        }
        System.out.println(len - c);
    }
}

