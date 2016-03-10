package atcoder.abc.abc014;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] bl = new int[1000002];
        Map<Integer, Integer> map = new HashMap<>();
        int last = 0;
        int start = 0;
        // ArrayList<Range> ranges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            bl[a] ++;
            bl[b + 1] --;
            // System.out.println(i + ": " + bl[a]);
            start = Math.min(start, a);
            last = Math.max(last, b);
        }
        // System.out.println();
        int k = bl[start];
        for (int i = start + 1; i <= last; i++) {
            bl[i] += bl[i - 1];
            k = Math.max(bl[i], k);
        }
        System.out.println(k);
    }
}
