package codeiq.weelky;

import java.util.Scanner;

public class LimitJunken {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputs = sc.nextLine().split(",");
        int a = Integer.valueOf(inputs[0]);
        int b = Integer.valueOf(inputs[1]);
        int n = Integer.valueOf(inputs[2]);
        int l = a + b - 1;
        int[] m = new int[l];
        m[a - 1] = 1;
        // arrayDump(m);
        int s = 0;
        for (int i = 0; i < n - 1; i++) {
            int[] mn = new int[l];
            mn[0] = m[0] + m[1];
            for (int j = 1; j < l - 1; j++) {
                mn[j] = m[j - 1] + m[j] + m[j + 1];
            }
            mn[l - 1] = m[l - 1] + m[l - 2];
            // arrayDump(mn);
            s += mn[0] + mn[l - 1];
            m = mn;
        }
        System.out.println(s);
    }

    public static void arrayDump(int[] a) {
        for (int i : a) {
            System.out.printf("%3d", i);
        }
        System.out.println();
    }
}
