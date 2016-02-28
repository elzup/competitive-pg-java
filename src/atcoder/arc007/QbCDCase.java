package atcoder.arc007;

import java.util.Scanner;

public class QbCDCase {

    public static int[] caseList;
    public static int out;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() + 1;
        int m = sc.nextInt();
        caseList = new int[n];
        for (int i = 0; i < n; i++) {
            caseList[i] = i;
        }
        out = 0;
        for (int i = 0; i < m; i++) {
            int d = sc.nextInt();
            play(d);
        }
        // printArray(caseList);
        int[] order = new int[n];
        for (int i = 0; i < n; i++) {
            order[caseList[i]] = i;
        }
        for (int i = 1; i < n; i++) {
            System.out.println(order[i]);
        }
    }

    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void play(int i) {
        caseList[out] = caseList[i];
        caseList[i] = 0;
        out = i;
    }
}
