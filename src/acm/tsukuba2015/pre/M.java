package acm.tsukuba2015.pre;

import java.io.*;
import java.util.Scanner;

public class M {
    public static int INF = Integer.MAX_VALUE;
    static Scanner sc;
    static PrintWriter pw;
    static String id = "M";
    static String input = "/Users/hiro/Downloads/" + id;
    static String output = "src/acm/tsukuba2015/out_" + id + ".txt";

    public static void main(String[] args) {
        init();

        // int n = 897158;
        // int n = 256731;
        // int n = 761995;
        // int n = 24179;
        // int n = 24179;
        // int n = 385220;
        // int n = 677376;
        // int n = 497594;
        // int n = 584385;
        // int n = 584385;
        // int n = 75053;
        // int n = 350317;
        // int n = 442010;
        // int n = 542710;
        // int n = 864996;
        // int n = 138404;
        // int n = 197230;
        // int n = 223717;
        // int n = 472588;
        // int n = 836706;
        int[] n = { 897159, 256731, 761995, 677377, 385221, 24180, 497595, 584386, 75054, 542711, 350318, 864997, 442011, 160530, 836707, 972231, 197231, 472589, 223718, 138405, 658668, 735967, 627837, 325376, 126064, 338082, 825352, 648318, 752157, 2709, 118097, 641359, 18191, 12881, 251589, 189504, 113801, 580108, 968415, 194074, 2, 749611, 249083, 10682, 323610, 247402, 823768, 822908, 74327, 251538, 323608, 1 };

        while (true) {
            int a = ni();
            if (a == 0) {
                break;

            }
            pw.println(n[23] >= a ? "smaller" : "larger");
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
