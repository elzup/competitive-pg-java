package acm.domestic.y2015;

import java.io.*;
import java.util.Scanner;

public class B {
    public static int INF = Integer.MAX_VALUE;
    static Scanner sc;
    static PrintWriter pw;
    static String id = "B";
    static String input = "/Users/hiro/Downloads/" + id;
    static String output = "src/acm/tsukuba2015/out_" + id + ".txt";

    public static void main(String[] args) {
        init();

        while (true) {
            int a = ni();
            // System.out.println("-- " + a);
            if (a == 0) {
                break;
            }
            int[] words = new int[a];
            nl();
            for (int i = 0; i < a; i++) {
                words[i] = nl().length();
            }
            int i = 0;
            for (i = 0; i < a; i++) {
                int[] ks = { 5, 7, 5, 7, 7};
                int ki = 0;
                int t = 0;
                // System.out.println("c: " + i);
                for (int j = i; j < a; j++) {
                    t += words[j];
                    if (t == ks[ki]) {
                        ki++;
                        t = 0;
                        if (ki == 5) {
                            break;
                        }
                    } else if (t > ks[ki]) {
                        break;
                    }
                }
                if (ki == 5) {
                    break;
                }
            }
            if (i != a) {
                // System.out.println(i + 1);
                pw.println(i + 1);
            }
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

    public static String nl() {
        return sc.nextLine();
    }
}
