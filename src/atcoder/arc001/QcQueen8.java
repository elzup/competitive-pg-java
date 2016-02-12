package atcoder.arc001;

import java.util.Scanner;

public class QcQueen8 {
    public static String[][] lib;

    /* Eight Queen 8 queen エイト クイーン */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] map = new String[8];
        for (int i = 0; i < 8; i++) {
            map[i] = sc.next();
        }
        lib = lib();

    }

    public static String[] flip(String[] map) {
        String[] newmap = new String[8];
        return newmap;
    }

    public static String[] rotate90(String[] map) {
        String[] newmap = new String[8];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < 8; j++) {
                newmap[i] += map[i].charAt(j);
            }
        }
        return newmap;
    }

    public static String[][] lib() {
        return new String[][]{
                {
                        "...Q....",
                        "......Q.",
                        "..Q.....",
                        ".......Q",
                        ".Q......",
                        "....Q...",
                        "Q.......",
                        ".....Q.."
                }, {
                "...Q....",
                ".Q......",
                "......Q.",
                "..Q.....",
                ".....Q..",
                ".......Q",
                "....Q...",
                "Q......."
        }, {
                "....Q...",
                ".Q......",
                "...Q....",
                "......Q.",
                "..Q.....",
                ".......Q",
                ".....Q..",
                "Q......."
        }, {
                "...Q....",
                ".....Q..",
                ".......Q",
                "..Q.....",
                "Q.......",
                "......Q.",
                "....Q...",
                ".Q......"
        }, {
                "..Q.....",
                ".....Q..",
                ".......Q",
                "Q.......",
                "...Q....",
                "......Q.",
                "....Q...",
                ".Q......"
        }, {
                "....Q...",
                "..Q.....",
                ".......Q",
                "...Q....",
                "......Q.",
                "Q.......",
                ".....Q..",
                ".Q......"
        }, {
                "....Q...",
                "......Q.",
                "...Q....",
                "Q.......",
                "..Q.....",
                ".......Q",
                ".....Q..",
                ".Q......"
        }, {
                "...Q....",
                "Q.......",
                "....Q...",
                ".......Q",
                ".....Q..",
                "..Q.....",
                "......Q.",
                ".Q......"
        }, {
                "..Q.....",
                ".....Q..",
                "...Q....",
                "Q.......",
                ".......Q",
                "....Q...",
                "......Q.",
                ".Q......"
        }, {
                ".....Q..",
                ".Q......",
                "......Q.",
                "Q.......",
                "...Q....",
                ".......Q",
                "....Q...",
                "..Q....."
        }, {
                "...Q....",
                "......Q.",
                "Q.......",
                ".......Q",
                "....Q...",
                ".Q......",
                ".....Q..",
                "..Q....."
        }, {
                ".....Q..",
                "...Q....",
                "......Q.",
                "Q.......",
                ".......Q",
                ".Q......",
                "....Q...",
                "..Q....."
        }
        };
    }
}
