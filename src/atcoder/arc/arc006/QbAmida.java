package atcoder.arc.arc006;

import java.util.Scanner;

public class QbAmida {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        sc.nextLine();
        int[][] routes = new int[l][n - 1];
        for (int i = 0; i < l; i++) {
            String line = sc.nextLine();
            // System.out.println(line);
            for (int j = 0; j < n - 1; j++) {
                int jp = j * 2 + 1;
                if (line.charAt(jp) == '-') {
                    routes[i][j] = 1;
                }
            }
        }
        // printArray(routes);
        String lastLine = sc.nextLine();
        int goal = (lastLine.indexOf('o')) / 2;
        // System.out.println(goal);
        sc.close();

        int pos = goal;
        for (int i = l - 1; i >= 0; i--) {
            // check left turn
            if (pos > 0 && routes[i][pos - 1] == 1) {
                pos --;
            } else if (pos < n - 1 && routes[i][pos] == 1) {
                pos ++;
            }
            // System.out.println(pos);
        }
        System.out.println(pos + 1);
    }

    public static void printArray(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }
}
