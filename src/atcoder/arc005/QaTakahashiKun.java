package atcoder.arc005;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QaTakahashiKun {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> lib = new ArrayList<String>();
        lib.add("takahashikun");
        lib.add("Takahashikun");
        lib.add("TAKAHASHIKUN");
        int c = 0;
        for (int i = 0; i < n; i++) {
            String w = sc.next();
            if (i == n - 1) {
                w = w.substring(0, w.length() - 1);
            }
            // System.out.println(w);
            if (lib.contains(w)) {
                c ++;
            }
        }
        System.out.println(c);
    }
}
