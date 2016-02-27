package atcoder.arc006;

import java.util.ArrayList;
import java.util.Scanner;

public class QaLottey {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> e = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            e.add(sc.nextInt());
        }
        int b = sc.nextInt();
        int[] l = new int[6];
        for (int i = 0; i < 6; i++) {
            l[i] = sc.nextInt();
        }

        // match check
        boolean bonus = false;
        int p = 0;
        for (int i = 0; i < 6; i++) {
            if (e.contains(l[i])) {
                p++;
            } else if (l[i] == b) {
                bonus = true;
            }
        }
        int rank = 7 - p;
        if (p < 5 || (p == 5 && !bonus)) {
            rank ++;
        }
        if (rank >= 6) {
            rank = 0;
        }
        System.out.println(rank);
    }
}
