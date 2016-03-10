package atcoder.abc.abc033;

import java.util.Scanner;

public class QaSame4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] n = sc.next().toCharArray();
        System.out.println((n[0] == n[1] && n[1] == n[2] && n[2] == n[3]) ? "SAME" : "DIFFERENT");
    }
}
