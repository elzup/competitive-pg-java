package aoj.intoroduction.itp1;

import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Q8BSumOfNumbers {

    static InputStream is;
    static PrintWriter out;
    static String INPUT = "";

    final int INF = Integer.MAX_VALUE;
    final int MIN = Integer.MIN_VALUE;

    static void solve() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String line = sc.nextLine();
            int sum = 0;
            for (int i = 0, l = line.length(); i < l; i++) {
                sum += Integer.parseInt("" + line.charAt(i));
            }
            if (sum == 0) {
                break;
            }
            System.out.println(sum);
        }
    }

    public static void main(String[] args) throws Exception {
        solve();
    }

}

