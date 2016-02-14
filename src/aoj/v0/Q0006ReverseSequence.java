package aoj.v0;

import java.util.Scanner;

public class Q0006ReverseSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println((new StringBuilder(s)).reverse().toString());
    }
}
