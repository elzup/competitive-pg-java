package atcoder.arc012;

import java.util.HashMap;
import java.util.Scanner;

public class QaDistanceHoriday {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String day = sc.next();
        HashMap<String, Integer> lib = new HashMap<>();

        lib.put("Sunday", 0);
        lib.put("Monday", 5);
        lib.put("Tuesday", 4);
        lib.put("Wednesday", 3);
        lib.put("Thursday", 2);
        lib.put("Friday", 1);
        lib.put("Saturday", 0);

        System.out.println(lib.get(day));
    }
}
