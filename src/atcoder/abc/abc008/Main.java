package atcoder.abc.abc008;

import java.util.*;

public class Main {
    public static int w, h, n;
    public static int[][] points;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        w = sc.nextInt();
        h = sc.nextInt();
        n = sc.nextInt();
        if (w > 80 || h > 80 || n > 8) {
            System.out.println("\\(^o^)/");
        }
        points = new int[n][2];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            points[i][0] = x;
            points[i][1] = y;
        }
        Permutation perms = new Permutation(n);
        int m = 0;
        while (perms.isNext()) {
            int[] p = perms.nextPerm();
            m = Math.max(m, score(p));
        }
        System.out.println(m + n);
    }

    public static int score(int[] order) {
        int[][] map = new int[h][w];
        int t = 0;
        for (int i: order) {
            int x = points[i][0], y = points[i][1];
            map[y][x] = 1;
        }
        // arrayDump(map);
        for (int i: order) {
            int x = points[i][0], y = points[i][1];
            for (int px = x + 1; px < w && map[y][px] == 0; px++) {
                map[y][px] = 1;
                t ++;
            }
            for (int px = x - 1; px >= 0 && map[y][px] == 0; px--) {
                map[y][px] = 1;
                t ++;
            }
            for (int py = y + 1; py < h && map[py][x] == 0; py++) {
                map[py][x] = 1;
                t ++;
            }
            for (int py = y - 1; py >= 0 && map[py][x] == 0; py--) {
                map[py][x] = 1;
                t ++;
            }
            // arrayDump(map);
            // System.out.println(t + "\n--------");
        }
        return t;
    }

    public static void arrayDump(int[][] m) {
        System.out.println();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] == 0 ? "." : "#");
            }
            System.out.println();
        }

    }

    public static class Permutation {
        private int     number, list_size, searched, next_index;
        private int[][] perm_list;

        /**
         * 引数の長さの順列を生成する
         * @param num
         */
        public Permutation(int num) {
            this.number     = num;
            this.list_size  = this.fact(this.number);
            this.searched   = 0;
            this.next_index = 0;
            this.perm_list  = new int[this.list_size][this.number];

            this.create(0, new int[this.number], new boolean[this.number]);
        }

        /**
         * 生成された順列をint配列で返す
         * @return int[]
         */
        public int[] nextPerm() {
            this.next_index++;
            return perm_list[this.next_index-1];
        }

        /**
         * 取り出せる順列が存在する場合にtrue、存在しない場合はfalseを返す
         * @return boolean
         */
        public boolean isNext() {
            if(this.next_index < this.list_size) {
                return true;
            } else {
                this.next_index = 0;
                return false;
            }
        }

        /** 引数の階乗を返す **/
        private int fact(int n) {
            return n == 0 ? 1 : n * fact(n-1);
        }

        /** 順列を作る **/
        private void create(int _num, int[] _list, boolean[] _flag) {
            if(_num == this.number) {
                copyArray(_list, perm_list[this.searched]);
                this.searched++;
            }
            for(int i=0; i < number; i++) {
                if (_flag[i]) continue;
                _list[_num] = i;
                _flag[i] = true;
                this.create(_num + 1, _list, _flag);
                _flag[i] = false;
            }

        }
    }

    /** int配列をコピーする **/
    private static void copyArray(int[] _from, int[] _to) {
        for(int i=0; i<_from.length; i++) _to[i] = _from[i];
    }

    /** int配列を標準出力する **/
    private static void printNum(int[] _nums) {
        for(int n : _nums) System.out.print(n);
        System.out.println();
    }
}

