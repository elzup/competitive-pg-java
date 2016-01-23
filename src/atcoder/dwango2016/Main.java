package atcoder.dwango2016;

import java.util.Scanner;

public class Main {
    public static int[][] map;
    public static int[][] smap;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        map = new int[n][m];
        smap = new int[n][m];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                map[j][i] = sc.nextInt();
                smap[j][i] = map[j][i];
                if (i > 0) {
                    smap[j][i] += smap[j][i - 1];
                }
                if (j > 0) {
                    smap[j][i] += smap[j - 1][i];
                }
                if (i > 0 && j > 0) {
                    smap[j][i] -= smap[j - 1][i - 1];
                }
            }
        }
        // rmap = new int[n][m][n][m];
        // arrayDump(smap);
        int max = Integer.MIN_VALUE;
        int[] jmax_a = new int[n - 1];
        int[] jmax_b = new int[n - 1];
        for (int j = 0; j < n - 1; j++) {
            jmax_a[j] = sqmax_js(0, 0, j, m - 1);
            jmax_b[j] = sqmax_je(n - j - 1, 0, n - 1, m - 1);
            // System.out.println(sqmax(0, 0, j, m - 1) + ": " + 0 + "," + 0 + "," + j + "," + (m - 1));
            // System.out.println(sqmax(0, j + 1, n - 1, m - 1) + ": " + 0 + "," + (j + 1) + "," + (n - 1) + "," + (m - 1));
        }
        for (int i = 1; i < n - 1; i++) {
            jmax_a[i] = Math.max(jmax_a[i - 1], jmax_a[i]);
            jmax_b[i] = Math.max(jmax_b[i - 1], jmax_b[i]);
            System.out.println(jmax_a[i]);
        }
        for (int i = 0; i < n - 1; i++) {
            System.out.println(jmax_a[i]);
            System.out.println(jmax_b[i]);
            // max = Math.max(jmax_a[i] + jmax_b[n - 1 - i], max);
        }
        for (int i = 0; i < m - 1; i++) {
            max = Math.max(max, sqmax(0, 0, n - 1, i) + sqmax(0, i + 1, n - 1, m - 1));
        }
        System.out.println(max);

    }

    public static int sqmax(int sy, int sx, int ey, int ex) {
        int max = Integer.MIN_VALUE;
        for (int js = sy; js <= ey; js++) {
            for (int is = sx; is <= ex; is++) {
                for (int je = js; je <= ey; je++) {
                    for (int ie = is; ie <= ex; ie++) {
                        int o = smap[je][ie];
                        if (js > 0) {
                            o -= smap[js - 1][ie];
                        }
                        if (is > 0) {
                            o -= smap[je][is - 1];
                        }
                        if (js > 0 && is > 0) {
                            o += smap[js - 1][is - 1];
                        }
                        max = Math.max(max, o);
                    }
                }
            }
        }
        return max;
    }

    public static int sqmax_is(int sy, int sx, int ey, int ex) {
        int max = Integer.MIN_VALUE;
        for (int js = sy; js <= ey; js++) {
            int is = sx;
            for (int je = js; je <= ey; je++) {
                for (int ie = is; ie <= ex; ie++) {
                    int o = smap[je][ie];
                    if (js > 0) {
                        o -= smap[js - 1][ie];
                    }
                    if (is > 0) {
                        o -= smap[je][is - 1];
                    }
                    if (js > 0 && is > 0) {
                        o += smap[js - 1][is - 1];
                    }
                    max = Math.max(max, o);
                }
            }
        }
        return max;
    }

    public static int sqmax_ie(int sy, int sx, int ey, int ex) {
        int max = Integer.MIN_VALUE;
        for (int js = sy; js <= ey; js++) {
            for (int is = sx; is <= ex; is++) {
                int je = ex;
                for (int ie = is; ie <= ex; ie++) {
                    int o = smap[je][ie];
                    if (js > 0) {
                        o -= smap[js - 1][ie];
                    }
                    if (is > 0) {
                        o -= smap[je][is - 1];
                    }
                    if (js > 0 && is > 0) {
                        o += smap[js - 1][is - 1];
                    }
                    max = Math.max(max, o);
                }
            }
        }
        return max;
    }

    public static int sqmax_js(int sy, int sx, int ey, int ex) {
        int max = Integer.MIN_VALUE;
        int js = sy;
        for (int is = sx; is <= ex; is++) {
            for (int je = js; je <= ey; je++) {
                for (int ie = is; ie <= ex; ie++) {
                    int o = smap[je][ie];
                    if (js > 0) {
                        o -= smap[js - 1][ie];
                    }
                    if (is > 0) {
                        o -= smap[je][is - 1];
                    }
                    if (js > 0 && is > 0) {
                        o += smap[js - 1][is - 1];
                    }
                    max = Math.max(max, o);
                }
            }
        }
        return max;
    }

    public static int sqmax_je(int sy, int sx, int ey, int ex) {
        int max = Integer.MIN_VALUE;
        for (int js = sy; js <= ey; js++) {
            for (int is = sx; is <= ex; is++) {
                int je = ey;
                for (int ie = is; ie <= ex; ie++) {
                    int o = smap[je][ie];
                    if (js > 0) {
                        o -= smap[js - 1][ie];
                    }
                    if (is > 0) {
                        o -= smap[je][is - 1];
                    }
                    if (js > 0 && is > 0) {
                        o += smap[js - 1][is - 1];
                    }
                    max = Math.max(max, o);
                }
            }
        }
        return max;
    }

    public static void arrayDump(int[][] k) {
        for (int i = 0; i < k.length; i++) {
            for (int j = 0; j < k[i].length; j++) {
                System.out.print(k[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---");
    }
}
