package aoj.intoroduction.itp1;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Q8CCountingCharacters {

    static InputStream is;
    static PrintWriter out;
    static String INPUT = "";

    final int INF = Integer.MAX_VALUE;
    final int MIN = Integer.MIN_VALUE;

    static void solve() {
        Scanner sc = new Scanner(System.in);
        String line = "";
        while (sc.hasNext()) {
            line += sc.nextLine();
        }
        line = line.toLowerCase();

        int[] res = new int[26];
        for (int i = 0; i < line.length(); i++) {
            int a = ((int)line.charAt(i)) - 97;
            if (a >= 28 || a < 0) {
                continue;
            }
            res[a]++;
        }
        for (int i = 0; i < 26; i++) {
            System.out.println((char) (i + 97) + " : " + res[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        long S = System.currentTimeMillis();
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        solve();
        out.flush();
        long G = System.currentTimeMillis();
    }
}
