package acm.domestic.y2005;

import java.util.Scanner;

public class QcMCXI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String k1 = sc.next();
            String k2 = sc.next();
            int r = toDec(k1) + toDec(k2);
            // System.out.println(toDec(k1));
            // System.out.println(toDec(k2));
            // System.out.println(r);
            System.out.println(toMc(r));
        }
    }

    public static int toDec(String s) {
        int t = 1;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'm') {
                sum += t * 1000;
                t = 1;
            } else if (c == 'c') {
                sum += t * 100;
                t = 1;
            } else if (c == 'x') {
                sum += t * 10;
                t = 1;
            } else if (c == 'i') {
                sum += t;
                t = 1;
            } else {
                t = Integer.valueOf(c + "");
            }
        }
        return sum;
    }

    public static String toMc(int n) {
        int mn = n / 1000 % 10;
        int cn = n / 100 % 10;
        int xn = n / 10 % 10;
        int in = n % 10;
        String k = "";
        if (mn > 1) {
            k += String.valueOf(mn) + "m";
        } else if (mn == 1) {
            k += "m";
        }
        if (cn > 1) {
            k += String.valueOf(cn) + "c";
        } else if (cn == 1) {
            k += "c";
        }
        if (xn > 1) {
            k += String.valueOf(xn) + "x";
        } else if (xn == 1) {
            k += "x";
        }
        if (in > 1) {
            k += String.valueOf(in) + "i";
        } else if (in == 1) {
            k += "i";
        }
        return k;
    }
}
