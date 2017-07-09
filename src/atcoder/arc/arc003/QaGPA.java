package atcoder.arc.arc003;

import java.util.HashMap;
import java.util.Scanner;

public class QaGPA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String r = sc.next();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("QaSurbal", 0);
        map.put("QbColorfulHats", 0);
        map.put("C", 0);
        map.put("D", 0);
        map.put("F", 0);
        for (int i = 0; i < n; i++) {
            String rum = r.charAt(i) + "";
            map.put(rum, map.get(rum) + 1);
        }
        double res = (double)(map.get("QaSurbal") * 4 + map.get("QbColorfulHats") * 3 + map.get("C") * 2 + map.get("D") * 1) / n;
        System.out.println(res);
    }
}
