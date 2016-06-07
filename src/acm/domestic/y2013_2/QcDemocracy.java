package acm.domestic.y2013_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// DFS(深さ優先探索), parse
public class QcDemocracy {
    static String line;
    static int p;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            line = sc.next();
            p = 0;
            System.out.println(dfs());
        }
    }

    static int dfs() {
        ArrayList<Integer> points = new ArrayList<>();
        while (true) {
            if (p == line.length() || line.charAt(p) == ']') {
                break;
            }
            if (line.charAt(p) == '[') {
                p++;
                points.add(dfs());
                p++;
            } else {
                int n = 0;
                while ("1234567890".contains(line.charAt(p) + "")) {
                    n = n * 10 + Integer.parseInt(line.charAt(p) + "");
                    p++;
                }
                return n / 2 + 1;
            }
        }
        Collections.sort(points);
        int sum = 0;
        for (int i = 0; i < points.size() / 2 + 1; i++) {
            sum += points.get(i);
        }
        return sum;
    }
}
