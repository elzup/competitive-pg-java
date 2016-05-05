package atcoder.abc.abc035;

import java.util.*;

public class QcOthello {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        ArrayList<Integer> points = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            int l = sc.nextInt() - 1;
            int r = sc.nextInt() - 1;
            if (points.contains(l)) {
                points.remove(new Integer(l));
            } else {
                points.add(l);
            }
            if (points.contains(r + 1)) {
                points.remove(new Integer(r + 1));
            } else {
                points.add(r + 1);
            }
        }
        Collections.sort(points);
        // printArray(points);

        boolean face = false;
        String res = strRepeat(points.get(0), "0");

        for (int i = 0, l = points.size(); i < l; i ++) {
            int p = points.get(i);
            int np = n;
            if (i + 1 < l) {
                np = points.get(i + 1);
            }
            int len = np - p;
            res += strRepeat(len, face ? "0" : "1");
            face = !face;
        }

        System.out.println(res);
    }

    static String strRepeat(int n, String str) {
        return new String(new char[n]).replace("\0", str);
    }

    static void printArray(List<Integer> a) {
        for (int n: a) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
