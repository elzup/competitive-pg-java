package atcoder.agc.agc017;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long n = sc.nextInt();
    long a = sc.nextInt();
    long b = sc.nextInt();
    long c = sc.nextInt();
    long d = sc.nextInt();
    if (Math.abs(b - a) > (n - 1) * d) {
      System.out.println("NO");
      return;
    }
    if (c * 2 <= (n - 1)) {
      System.out.println("YES");
      return;
    }
    long dw = d - c;
    long k = 2 * c + dw;
    long x = n - 1;
    long low = a - d * x;
    if ((b - low) % k <= dw * x) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }

}
