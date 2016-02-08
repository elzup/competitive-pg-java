package atcoder.abc032;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class QcLine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Queue<Integer> queue = new ArrayDeque<>();
        long ss = 1;
        int nl = 0;
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            if (s == 0) {
                System.out.println(n);
                return;
            }
            if (s > k) {
                continue;
            }
            while (ss * s > k) {
                int t = queue.poll();
                ss /= t;
            }
            queue.offer(s);
            ss *= s;
            nl = Math.max(queue.size(), nl);
        }
        System.out.println(nl);
    }
}
