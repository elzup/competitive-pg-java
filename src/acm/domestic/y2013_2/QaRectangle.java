package acm.domestic.y2013_2;

import java.util.Scanner;

public class QaRectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            if ((h | w) == 0) {
                break;
            }
            int m = h * h + w * w;
            int ah = Integer.MAX_VALUE;
            int aw = Integer.MAX_VALUE;
            int mMin = Integer.MAX_VALUE;

            for (int i = 1; i <= 150; i++) {
                for (int j = i + 1; j <= 150; j++) {
                    int mk = i * i + j * j;
                    if (i == h && j == w) {
                        continue;
                    }
                    if (mk < m || (mk == m && i < h)) {
                        continue;
                    }
                    if (mMin > mk || (mMin == mk && ah > i)) {
                        mMin = mk;
                        ah = i;
                        aw = j;
                    }
                }
            }
            System.out.println(ah + " " + aw);
        }
    }
}
