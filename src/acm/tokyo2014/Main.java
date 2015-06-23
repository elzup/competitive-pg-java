package acm.tokyo2014;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String[] hw = sc.nextLine().split(" ");
            int x = Integer.parseInt(hw[0]);
            int y = Integer.parseInt(hw[1]);
            int s = Integer.parseInt(hw[2]);
            // System.out.println(x + ", " + y + ", " + z);
            int max = 0;
            if (x + y + s == 0) {
                break;
            }
            for (int i = 1; i < 1000; i ++) {
                int ia = (int) Math.floor(i + i * x / 100);
                for (int j = 1; j < 1000; j ++) {
                    int ja = (int) Math.floor(j + j * x / 100);
                    if (ia + ja == s) {
                        int ib = (int) Math.floor(i + i * y / 100);
                        int jb = (int) Math.floor(j + j * y / 100);
                        max = Math.max(max, ib + jb);
                    }
                }
            }
            System.out.println(max);
        }
    }
}
