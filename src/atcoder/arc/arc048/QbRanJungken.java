package atcoder.arc.arc048;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class QbRanJungken {

    public static int H_G = 1;
    public static int H_C = 2;
    public static int H_P = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        HashMap<Integer, Integer> c_map = new HashMap<>();
        HashMap<Integer, Integer> p_map = new HashMap<>();
        HashMap<Integer, Integer> g_map = new HashMap<>();
        TreeMap<Integer, Integer> all_map = new TreeMap<>();

        int[] hs = new int[n];
        int[] rs = new int[n];

        for (int i = 0; i < n; i++) {
            int r = sc.nextInt();
            int h = sc.nextInt();
            HashMap<Integer, Integer> inc_map = new HashMap<>();
            rs[i] = r;
            hs[i] = h;
            if (h == H_G) {
                inc_map = g_map;
            } else if (h == H_C) {
                inc_map = c_map;
            } else if (h == H_P) {
                inc_map = p_map;
            }
            if (!inc_map.containsKey(r)) {
                inc_map.put(r, 0);
            }
            inc_map.put(r, inc_map.get(r) + 1);
            if (!all_map.containsKey(r)) {
                all_map.put(r, 0);
            }
            all_map.put(r, all_map.get(r) + 1);
        }

        HashMap<Integer, Integer> win_count_map = new HashMap<>();
        HashMap<Integer, Integer> los_count_map = new HashMap<>();

        int sum = 0;
        for (Map.Entry<Integer, Integer> e : all_map.entrySet()) {
            win_count_map.put(e.getKey(), sum);
            sum += e.getValue();
            // System.out.println(e.getKey() + ": " + e.getValue() + ":" + (n - sum));
            los_count_map.put(e.getKey(), n - sum);
        }

        for (int i = 0; i < n; i++) {
            int h = hs[i];
            int r = rs[i];

            int win = win_count_map.get(r);
            int los = los_count_map.get(r);
            int draw = 0;

            HashMap<Integer, Integer> win_map = new HashMap<>();
            HashMap<Integer, Integer> los_map = new HashMap<>();
            HashMap<Integer, Integer> draw_map = new HashMap<>();
            if (h == H_G) {
                win_map = c_map;
                los_map = p_map;
                draw_map = g_map;
            } else if (h == H_C) {
                win_map = p_map;
                los_map = g_map;
                draw_map = c_map;
            } else if (h == H_P) {
                win_map = g_map;
                los_map = c_map;
                draw_map = p_map;
            }
            win += win_map.getOrDefault(r, 0);
            los += los_map.getOrDefault(r, 0);
            draw = draw_map.get(r) - 1;

            System.out.println(win + " " + los + " " + draw);
        }
    }
}
