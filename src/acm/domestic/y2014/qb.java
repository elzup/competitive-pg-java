package acm.domestic.y2014;

import java.util.Scanner;

public class qb {
    static int[][] k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String[] hw = sc.nextLine().split(" ");
            int h = Integer.parseInt(hw[0]);
            if (h == 0) {
                break;
            }
            k = new int[h][5];
            int sum = 0;
            for (int i = 0; i < h; i++) {
                String[] line = sc.nextLine().split(" ");
                for (int j = 0; j < 5; j++) {
                    k[i][j] = Integer.parseInt(line[j]);
                    sum += k[i][j];
                }
            }
            boolean isDel = true;
            while (isDel) {
                if (!deleteCheck()) {
                    break;
                }
                fall();
            }
            int endSum = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < 5; j++) {
                    endSum += k[i][j];
                }
            }
            System.out.println(sum - endSum);
        }
    }

    public static void dumpArray(int[][] k) {
        for (int i = 0; i < k.length; i++) {
            for (int j = 0; j < k[i].length; j++) {
                System.out.print(k[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---");
    }

    public static boolean deleteCheck() {
        boolean isDel = false;
        for (int i = 0; i < k.length; i++) {
            int c = 1;
            int pre = 0;
            for (int j = 0; j < 5; j++) {
                if (pre == k[i][j]) {
                    c++;
                    if (k[i][j] != 0 && c >= 3 && (j == 4 || (j < 4 && k[i][j + 1] != k[i][j]))) {
                        isDel = true;
                        for (int id = -c + 1; id <= 0; id++) {
                            k[i][j + id] = 0;
                        }
                        c = 1;
                    }
                } else {
                    c = 1;
                }
                pre = k[i][j];
            }
        }
        return isDel;
    }

    public static void fall() {
        int kl = k.length;
        for (int j = 0; j < 5; j++) {
            for (int i = kl - 1; i >= 1; i--) {
                if (k[i][j] == 0) {
                    for (int id = i; id >= 0; id--) {
                        if (k[id][j] != 0) {
                            k[i][j] = k[id][j];
                            k[id][j] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }
}
