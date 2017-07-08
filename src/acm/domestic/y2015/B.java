package acm.domestic.y2015;

import java.util.Scanner;

public class B {
    public static int INF = Integer.MAX_VALUE;
    static Scanner sc;

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
                System.out.println(i + 1);
            }
        }
        end();
    }

    public static void init() {
        sc = new Scanner(System.in);
    }

    public static void end() {
        sc.close();
    }

    public static int ni() {
        return sc.nextInt();
    }

    public static String nl() {
        return sc.nextLine();
    }
}
