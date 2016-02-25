package atcoder.arc005;

import java.util.Scanner;

public class QbPassposMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x =  sc.nextInt() - 1;
        int y =  sc.nextInt() - 1;
        String W =  sc.next();
        int size = 9;
        String[] map = new String[size];
        for (int i = 0; i < size; i++) {
            map[i] = sc.next();
            // System.out.println(i);
        }
        int vx = 0;
        int vy = 0;
        if (W.contains("R")) {
            vx = 1;
        } else if (W.contains("L")) {
            vx = -1;
        }
        if (W.contains("U")) {
            vy = -1;
        } else if (W.contains("D")) {
            vy = 1;
        }
        // System.out.println(x + ":" + y);
        String pass = String.valueOf(map[y].charAt(x));
        for (int i = 0; i < 3; i++) {
            if (x + vx == -1 || x + vx == size) {
                vx *= -1;
            }
            if (y + vy == -1 || y + vy == size) {
                vy *= -1;
            }
            x += vx;
            y += vy;
            // System.out.println(x + ":" + y);
            pass += map[y].charAt(x);
        }
        System.out.println(pass);
    }
}
