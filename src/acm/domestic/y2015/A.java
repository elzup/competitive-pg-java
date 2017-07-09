package acm.domestic.y2015;

import java.io.*;
import java.util.Scanner;

public class A {
    public static int INF = Integer.MAX_VALUE;
    static Scanner sc;
    static PrintWriter pw;
    static String id = "QaSurbal";
    static String input = "/Users/hiro/Downloads/" + id;
    static String output = "src/acm/tsukuba2015/out_" + id + ".txt";

    public static void main(String[] args) {
        init();

        while (true) {
            int m = ni();
            int nmin = ni();
            int nmax = ni();
            if ((m | nmin | nmax) == 0) {
                break;
            }
            int[] ms = new int[m];
            for (int i = 0; i < m; i++) {
                ms[i] = ni();
            }
            int res = 0;
            int resi = 0;
            for (int i = nmin - 1; i < nmax; i++) {
                int d = ms[i] - ms[i + 1];
                if (res <= d) {
                    res = d;
                    resi = i + 1;
                }
            }
            pw.println(resi);
            // System.out.println(resi);
            // System.out.println(resi);
        }

        end();
    }

    public static void init() {
        try {
            System.setProperty("line.separator", "\r\n");
            sc = new Scanner(new File(input));
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(output)));
            pw = new PrintWriter(bw);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void end() {
        sc.close();
        pw.close();
    }

    public static int ni() {
        return sc.nextInt();

    }
}
