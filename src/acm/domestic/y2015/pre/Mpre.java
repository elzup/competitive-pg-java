package acm.domestic.y2015.pre;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Mpre {
    public static int INF = Integer.MAX_VALUE;
    static Scanner sc;
    static PrintWriter pw;
    static String id = "M";
    static String input = "/Users/hiro/Downloads/" + id;
    static String output = "src/acm/tsukuba2015/out_" + id + ".txt";

    public static void main(String[] args) {
        init();

        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            int a = ni();
            if (a == 0) {
                break;
            }
            list.add(a);
        }
        list.add(1000000);
        Collections.sort(list);
        int l = list.size();
        int pre = 0;
        for (int v : list) {
            int d = v - pre;
            System.out.println((pre + 1) + "," + d);
            pre = v;
        }

        // pw.println("smaller");
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

