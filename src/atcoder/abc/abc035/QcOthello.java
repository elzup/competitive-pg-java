package atcoder.abc.abc035;

import java.util.*;

public class QcOthello {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] ps = new int[n + 1];

        for (int i = 0; i < q; i++) {
            int l = sc.nextInt() - 1;
            int r = sc.nextInt() - 1;
            ps[l]++;
            ps[r + 1]++;
        }

        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0, l = ps.length; i < l - 1; i++) {
            sum += ps[i];
            sb.append(sum % 2 == 0 ? "0" : "1");
        }
        System.out.println(sb);
    }

    static String strRepeat(int n, String str) {
        return new String(new char[n]).replace("\0", str);
    }

    static void printArray(List<Integer> a) {
        for (int n: a) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
