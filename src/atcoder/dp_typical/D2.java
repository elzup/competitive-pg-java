package atcoder.dp_typical;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class D2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    BigInteger k = new BigInteger("" + sc.nextInt());
    HashMap<BigInteger, Double> map = new HashMap<>();

    map.put(new BigInteger("1"), 1.0);
    for (int i = 0; i < n; i++) {
      HashMap<BigInteger, Double> map2 = new HashMap<>();
      for (BigInteger t: map.keySet()) {
        double now = map.get(t);
//        System.out.println(t);
//        System.out.println(now);
        for (int j = 1; j <= 6; j++) {
          BigInteger o = t.multiply(new BigInteger("" + j));
          if (!map2.containsKey(o)) {
            map2.put(o, 0.0);
          }
          double p = map2.get(o) + now / 6.0f;
          map2.put(o, p);
//          System.out.printf(o + " %2.4f\n", p);
        }
//        System.out.println();
      }
//      System.out.println();
      map = map2;
    }
    double sum = 0.0;
    for (BigInteger t: map.keySet()) {
      if (t.remainder(k).toString().equals("0")) {
        sum += map.get(t);
      }
    }
//    System.out.println(map.get(k));
    System.out.println(sum);
  }

}
