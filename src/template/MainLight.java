package template;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by hiro on 6/27/15.
 */
public class MainLight {

    static Scanner sc;
    static PrintWriter out;
    static String INPUT = "";

    final int INF = Integer.MAX_VALUE;
    final int MIN = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        sc = new Scanner(System.in);
        out = new PrintWriter(System.out);
    }

    public static int ni() {
        return sc.nextInt();
    }
}
