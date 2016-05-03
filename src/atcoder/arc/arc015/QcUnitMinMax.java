package atcoder.arc.arc015;

import java.util.*;

public class QcUnitMinMax {
    static Unit minUnit;
    static double minVal = 1;
    static Unit maxUnit;
    static double maxVal = 1;
    static ArrayList<String> log;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String, Unit> units = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String l = sc.next();
            int m = sc.nextInt();
            String s = sc.next();

            if (!units.containsKey(l)) {
                units.put(l, new Unit(l));
            }
            if (!units.containsKey(s)) {
                units.put(s, new Unit(s));
            }
            Unit ul = units.get(l);
            Unit us = units.get(s);
            ul.add(us, m);
            us.add(ul, -m);
        }
        for (Map.Entry<String, Unit> e: units.entrySet()) {
            Unit u = e.getValue();
            maxUnit = u;
            minUnit = u;
            maxVal = Double.MIN_VALUE;
            minVal = Double.MAX_VALUE;
            log = new ArrayList<>();
            u.fire(1);
            if (isInteger(maxVal / minVal)) {
                break;
            }
        }
        // System.out.println(maxUnit.name + ": " + maxVal);
        // System.out.println(minUnit.name + ": " + minVal);
        System.out.println("1" + minUnit.name + "=" + ((int)(maxVal / minVal)) + "" + maxUnit.name);
    }

    static boolean isInteger(Double n) {
        return n % 1 == 0;
    }

    static class Unit {
        public String name;
        public HashMap<Unit, Integer> map;

        Unit(String name) {
            this.name = name;
            this.map = new HashMap<>();
        }

        public void add(Unit unit, int m) {
            this.map.put(unit, m);
        }

        public void fire(double val) {
            if (log.contains(this.name)) {
                return;
            }
            if (val > maxVal) {
                maxVal = val;
                maxUnit = this;
            }
            if (val < minVal) {
                minVal = val;
                minUnit = this;
            }
            log.add(this.name);
            for (Map.Entry<Unit, Integer> e: this.map.entrySet()) {
                Unit u = e.getKey();
                int v = e.getValue();
                if (v >= 0) {
                    u.fire(val * v);
                } else {
                    u.fire(val / -v);
                }
            }
        }
    }
}
