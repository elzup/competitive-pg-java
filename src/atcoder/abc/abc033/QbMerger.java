package atcoder.abc.abc033;

import java.util.Scanner;

public class QbMerger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 0;
        String maxS = "";
        int sum = 0;
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int p = sc.nextInt();
            if (max < p) {
                max = p;
                maxS = name;
            }
            sum += p;
        }
        // System.out.println(sum);
        // System.out.println(sum / 2);
        // System.out.println(max);
        if (sum / 2 < max) {
            System.out.println(maxS);
        } else {
            System.out.println("atcoder");
        }
    }
}
