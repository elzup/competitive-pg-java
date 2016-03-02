package atcoder.arc008;

import java.util.Scanner;

public class QbKanban {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String name = sc.next();
        String kit = sc.next();

        int[] list = new int[26];
        int[] list2 = new int[26];
        for (int i = 0; i < n; i++) {
            list[(int) name.charAt(i) - 65]++;
        }
        for (int i = 0; i < m; i++) {
            list2[(int) kit.charAt(i) - 65]++;
        }
        int max = 0;
        for (int i = 0; i < 26; i++) {
            if (list[i] == 0) {
                continue;
            } else if (list2[i] == 0) {
                System.out.println(-1);
                System.exit(0);
            }
            int rate = (int) Math.ceil((float)list[i] / list2[i]);
            max = Math.max(max, rate);
        }
        System.out.println(max);
    }
}

/*
10 4
AAAAABBBBB
AABB
 */