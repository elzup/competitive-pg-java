package paiza;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A014Nikaku {
    public static String[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int W = sc.nextInt();
        int N = sc.nextInt();
        map = new String[H + 2][W + 2];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = ".";
            }
        }
        sc.nextLine();
        for (int i = 1; i <= H; i++) {
            String[] cs = sc.nextLine().split(" ");
            for (int j = 1; j <= W; j++) {
                map[i][j] = cs[j - 1];
            }
        }
        int[][] lib = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < N; i++) {
            Vec sv = new Vec(sc.nextInt(), sc.nextInt());
            Vec ev = new Vec(sc.nextInt(), sc.nextInt());
            if (!(map[sv.y][sv.x].equals(map[ev.y][ev.x]))) {
                System.out.println("no");
                continue;
            }
            ArrayList<Vec> avs = new ArrayList<>();
            ArrayList<Vec> bvs = new ArrayList<>();
            avs.add(sv);
            bvs.add(ev);
            for (int[] dire : lib) {
                for (int j = 1; j < H + W; j++) {
                    int my = dire[0] * j + sv.y;
                    int mx = dire[1] * j + sv.x;
                    if (my < 0 || H + 2 <= my || mx < 0 || W + 2 <= mx) {
                        break;
                    }
                    // System.out.println("[" + my + "," + mx + "]");
                    // System.out.println(map[my][mx]);
                    // System.out.println(!(".".equals(map[my][mx])));
                    if (!(".".equals(map[my][mx]))) {
                        break;
                    }
                    avs.add(new Vec(my, mx));
                }
                for (int j = 1; j < H + W; j++) {
                    int my = dire[0] * j + ev.y;
                    int mx = dire[1] * j + ev.x;
                    if (my < 0 || H + 2 <= my || mx < 0 || W + 2 <= mx) {
                        break;
                    }
                    if (!(".".equals(map[my][mx]))) {
                        break;
                    }
                    bvs.add(new Vec(my, mx));
                }
            }
            // System.out.println("avs");
            // for (int j = 0; j < avs.size(); j++){
            //     System.out.println(avs.get(j).x + ":" + avs.get(j).y);
            // }
            // System.out.println("bvs");
            // for (int j = 0; j < bvs.size(); j++){
            //     System.out.println(bvs.get(j).x + ":" + bvs.get(j).y);
            // }

            System.out.println(checkAll(avs, bvs) ? "yes" : "no");
        }
    }

    public static boolean checkAll(List<Vec> as, List<Vec> bs) {
        for (Vec a : as) {
            for (Vec b : bs) {
                if (check(a, b)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean check(Vec a, Vec b) {
        if (a.equals(b)) {
            return true;
        }
        if (a.x == b.x) {
            int sy = a.y;
            int ey = b.y;
            if (sy > ey) {
                sy = b.y;
                ey = a.y;
            }
            for (int i = sy + 1; i < ey; i++) {
                if (!".".equals(map[i][a.x])) {
                    return false;
                }
            }
        } else if (a.y == b.y) {
            int sx = a.x;
            int ex = b.x;
            if (sx > ex) {
                sx = b.x;
                ex = a.x;
            }
            for (int i = sx + 1; i < ex; i++) {
                if (!".".equals(map[a.y][i])) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
}

class Vec {
    public int y;
    public int x;
    public Vec (int y, int x) {
        this.y = y;
        this.x = x;
    }

    public boolean eqals(Vec v) {
        return v.x == this.x && v.y == this.y;
    }

    public boolean onLine(Vec v) {
        return (v.x == this.x) || (v.y == this.y);
    }
}


