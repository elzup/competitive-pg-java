package atcoder.arc003;

import java.util.Arrays;
import java.util.Scanner;

public class QbRevSortLib {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = rev(sc.next());
        }
        Arrays.sort(s);
        for (int i = 0; i < n; i++) {
            System.out.println(rev(s[i]));
        }
    }

    public static String rev(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
