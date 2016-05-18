package acm.tokyo2014_2;

import java.util.ArrayList;
import java.util.Scanner;

public class QdCrypt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        lib = "abcdefghijklmnopqrstuvwxyz";
        while (true) {
            String s = sc.next();
            if (s.equals("#")) {
                break;
            }
            solve(s);
        }
    }

    public static ArrayList<String> data;
    public static String lib;
    public static void solve(String s) {
        data = new ArrayList<>();
    }

    public static void dp(String s, boolean[] replaced, int k) {
        if (k == 0) {
            data.add(s);
        }
        String c = "" + lib.charAt(k);
    }
}
