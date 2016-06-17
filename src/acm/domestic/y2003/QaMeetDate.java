package acm.domestic.y2003;

import java.util.ArrayList;
import java.util.Scanner;

public class QaMeetDate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            if ((n | q) == 0) {
                break;
            }
            int[] counts = new int[150];
            for (int i = 0; i < n; i++) {
                int m = sc.nextInt();
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = 0; j < m; j++) {
                    int p = sc.nextInt();
                    if (list.contains(p)) {
                        continue;
                    }
                    list.add(p);
                    counts[p]++;
                }
            }
            int min = -1;
            int minI = -1;
            for (int i = 0; i < counts.length; i++) {
                if (min < counts[i]) {
                    min = counts[i];
                    minI = i;
                }
            }
            if (min < q) {
                System.out.println(0);
            } else {
                System.out.println(minI);
            }
        }
    }
}
