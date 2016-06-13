package acm.domestic_pre.y2016b;

import java.util.ArrayList;
import java.util.Scanner;

public class QRobot {

    static int W = 0;
    static int H = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.next();
            if ("#".equals(s)) {
                break;
            }
            int y1 = sc.nextInt() - 1;
            int x1 = sc.nextInt() - 1;
            int y2 = sc.nextInt() - 1;
            int x2 = sc.nextInt() - 1;
            int[][] map = parse(s);
            // arrayDump(map);
            map[y1][x1] = 0;
            map[y2][x2] = 1;
            // arrayDump(map);
            System.out.println(serialize(map));
        }
    }

    public static void arrayDump(int[][] a) {
        for (int i = 0, l = a.length; i < l; i++) {
            for (int j = 0, l2 = a[0].length; j < l2; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] parse(String s) {
        String[] lines = s.split("/");
        ArrayList<ArrayList<Integer>> map = new ArrayList<>();
        for (String line : lines) {
            ArrayList<Integer> l = new ArrayList<>();
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if ('0' <= c && c <= '9') {
                    int n = Integer.valueOf(c + "");
                    for (int j = 0; j < n; j++) {
                        l.add(0);
                    }
                } else {
                    l.add(1);
                }
            }
            map.add(l);
        }
        int[][] mm = new int[lines.length][map.get(0).size()];
        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < map.get(0).size(); j++) {
                mm[i][j] = map.get(i).get(j);
            }
        }
        return mm;
    }

    public static String serialize(int[][] a) {
        String[] lines = new String[a.length];
        for (int i = 0; i < a.length; i++) {
            String line = "";
            int k = 0;
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 0) {
                    k++;
                } else {
                    if (k > 0) {
                        line += String.valueOf(k);
                        k = 0;
                    }
                    line += "b";
                }
            }
            if (k > 0) {
                line += String.valueOf(k);
            }
            lines[i] = line;
        }
        return String.join("/", lines);
    }
}
