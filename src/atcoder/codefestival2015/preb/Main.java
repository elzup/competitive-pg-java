package atcoder.codefestival2015.preb;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int v = scanner.nextInt();
            if (!maps.containsKey(v)) {
                maps.put(v, 0);
            }
            maps.put(v, maps.get(v) + 1);
        }
        List<Map.Entry<Integer,Integer>> entries =
                new ArrayList<Map.Entry<Integer,Integer>>(maps.entrySet());
        Collections.sort(entries, new Comparator() {
            public int compare(Object o1, Object o2) {
                Map.Entry e2 = (Map.Entry) o1;
                Map.Entry e1 = (Map.Entry) o2;
                return ((Integer) e1.getValue()).compareTo((Integer) e2.getValue());
            }
        });
        if (n == 1) {
            System.out.println(entries.get(0).getKey());
            return;
        }
        if (entries.get(0).getValue() >= n / 2 &&
                entries.get(0).getValue() > entries.get(1).getValue()) {
            System.out.println(entries.get(0).getKey());
            return;
        }
        System.out.println(-1);
    }
}
