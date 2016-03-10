package atcoder.abc.abc018;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder s = new StringBuilder(sc.nextLine());
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            s = flip(s, l - 1, r - 1);
        }
        System.out.println(s);
    }

    public static StringBuilder flip(StringBuilder s, int l, int r) {
        return s.replace(l, r + 1, (new StringBuilder(s.substring(l, r + 1)).reverse().toString()));
    }
}
