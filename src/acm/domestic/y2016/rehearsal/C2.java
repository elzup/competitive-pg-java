package acm.domestic.y2016.rehearsal;

import java.util.Scanner;

public class C2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int MAX = 10000000;
        int[] map = new int[MAX];
        int t = 0;
        int i = 0;
        for (i = m; i < MAX; i++) {
            if (map[i] == 0) {
                if (t == n) {
                    break;
                }
                for (int j = i; j < MAX; j += i) {
                    map[j] = 1;
                }
                t++;
            }
        }
        System.out.println(i);
    }
}
