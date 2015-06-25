package template;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Utils {
    public static void dumpArray(int[][] k) {
        for (int i = 0; i < k.length; i++) {
            for (int j = 0; j < k[i].length; j++) {
                System.out.print(k[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---");
    }

    public static int max(int[] ns) {
        int max = 0;
        for (int n : ns) {
            max = Math.max(max, n);
        }
        return max;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n % 2 == 0) {
            return n == 2;
        }
        for (int i = 3, l = (int) Math.floor(Math.sqrt(n)); i <= l; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // isPrime test
        for (int i = 0; i < 100; i++) {
            System.out.println(i + ":" + isPrime(i));
        }
    }
}

class UnionFind {
    int[] par;
    int n;

    UnionFind(int n) {
        this.n = n;
        par = new int[n];
        for (int i = 0; i < n; i++) par[i] = i;
    }

    public int find(int x) {
        if (par[x] == x) return x;
        return par[x] = find(par[x]);
    }

    public boolean same(int x, int y) {
        return find(x) == find(y);
    }

    public void unite(int x, int y) {
        if (find(x) == find(y)) return;
        par[find(x)] = find(y);
    }
}

class DijkstraMatrix {
    int[][] a;
    boolean[] b;
    PriorityQueue<int[]> q;

    public DijkstraMatrix(int n) {
        a = new int[n + 1][n + 1];
        b = new boolean[n + 1];
        q = new PriorityQueue<int[]>(n + 1, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
    }

    public void set(int i, int j, int cost) {
        a[i][j] = cost;
    }

    public int getCost(int s, int e) {
        Arrays.fill(b, false);
        q.clear();
        b[s] = true;
        int c = 0;
        for (int i = 0; i < a.length; ++i) {
            int[] t = q.poll();
            if (t[0] == e) {
                c = t[1];
                break;
            }
            b[t[0]] = true;
            for (int k = 0; k < a.length; k++) {

                if (!b[k] && a[t[0]][k] > 0) {
                    q.add(new int[]{k, t[1] + a[t[0]][k]});
                }
            }
        }
        return c;
    }
}


class Dice {
    static int[] dice;
    static int[][] dice_table =
            {{0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 3, 5, 2, 4, 0},
                    {0, 4, 0, 1, 6, 0, 3},
                    {0, 2, 6, 0, 0, 1, 5},
                    {0, 5, 1, 0, 0, 6, 2},
                    {0, 3, 0, 6, 1, 0, 4},
                    {0, 0, 4, 2, 5, 3, 0}

            };

    Dice(int x, int y) {
        dice = new int[6];
        dice[0] = x;
        dice[1] = y;
        dice[2] = dice_table[x][y];
        dice[3] = 7 - y;
        dice[4] = dice_table[y][x];
        dice[5] = 7 - x;
    }

    // http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0502
    static int[] roll(int dir) {
        int[] b = new int[6];
        if (dir == 1) {// South
            b[0] = dice[3];
            b[1] = dice[0];
            b[2] = dice[2];
            b[3] = dice[5];
            b[4] = dice[4];
            b[5] = dice[1];
        } else if (dir == 2) {// East
            b[0] = dice[4];
            b[1] = dice[1];
            b[2] = dice[0];
            b[3] = dice[3];
            b[4] = dice[5];
            b[5] = dice[2];
        } else if (dir == 3) {// North
            b[0] = dice[1];
            b[1] = dice[5];
            b[2] = dice[2];
            b[3] = dice[0];
            b[4] = dice[4];
            b[5] = dice[3];
        } else if (dir == 4) {// West
            b[0] = dice[2];
            b[1] = dice[1];
            b[2] = dice[5];
            b[3] = dice[3];
            b[4] = dice[0];
            b[5] = dice[4];
        } else if (dir == 5) {// Left
            b[0] = dice[0];
            b[1] = dice[4];
            b[2] = dice[1];
            b[3] = dice[2];
            b[4] = dice[3];
            b[5] = dice[5];
        } else {// Right
            b[0] = dice[0];
            b[1] = dice[2];
            b[2] = dice[3];
            b[3] = dice[4];
            b[4] = dice[1];
            b[5] = dice[5];
        }
        return b;
    }
}
