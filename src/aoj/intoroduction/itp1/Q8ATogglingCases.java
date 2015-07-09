package aoj.intoroduction.itp1;

import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Q8ATogglingCases {

    static InputStream is;
    static PrintWriter out;
    static String INPUT = "";

    final int INF = Integer.MAX_VALUE;
    final int MIN = Integer.MIN_VALUE;

    static void solve() {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int ia = (int) 'a';
        int iz = (int) 'z';
        int iA = (int) 'A';
        int iZ = (int) 'Z';
        int d = iA - ia;
        String res = "";
        for (int i = 0, l = line.length(); i < l; i++) {
            char c = line.charAt(i);
            int ci = (int) c;
            String r = c + "";
            if (ia <= ci && ci <= iz) {
                r = ((char) (ci + d)) + "";
            } else if (iA <= c && c <= iZ) {
                r = ((char) (ci - d)) + "";
            }
            res += r;
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws Exception {
        solve();
    }

}
