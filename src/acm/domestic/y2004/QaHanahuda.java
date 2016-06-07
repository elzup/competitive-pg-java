package acm.domestic.y2004;

import java.util.ArrayList;
import java.util.Scanner;

public class QaHanahuda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            int r = sc.nextInt();
            if ((n|r) == 0) {
                break;
            }
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(0, i + 1);

            }
            for (int i = 0; i < r; i++) {
                // for (int j = 0; j < list.size(); j++) {
                //     System.out.print(list.get(j) + " ");
                // }
                // System.out.println();
                int p = sc.nextInt() - 1;
                int c = sc.nextInt();
                for (int j = 0; j < c; j++) {
                    int k = list.remove(j + p);
                    list.add(j, k);
                }
            }
            System.out.println(list.get(0));
        }
    }
}
