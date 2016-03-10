package atcoder.arc.arc014;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> foregoing = new ArrayList<>();
        String next = ".";
        for (int i = 0; i < n; i++) {
            String w = sc.next();
            // System.out.println(w);
            String first = w.charAt(0) + "";
            String last = w.charAt(w.length() - 1) + "";
            // System.out.println(first + ":" + last);
            if ((i != 0 && !next.equals(first)) || foregoing.contains(w)) {
                System.out.println(new String[]{ "LOSE", "WIN" }[i % 2]);
                System.exit(0);
            }
            next = last;
            foregoing.add(w);
        }
        System.out.println("DRAW");
    }
}
