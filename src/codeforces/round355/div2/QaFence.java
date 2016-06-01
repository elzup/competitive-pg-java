package codeforces.round355.div2;


import java.util.Scanner;

public class QaFence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();
        int c = 0;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            c += a % h == 0 ? a / h: a / h + 1;
        }
        System.out.println(c);
    }
}
