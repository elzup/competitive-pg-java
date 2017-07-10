package acm.domestic.y2008;

import java.util.ArrayList;
import java.util.Scanner;

public class QbMonSutPrime {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayList<Integer> primes = new ArrayList<>();
    for (int i = 2; i < 300000; i++) {
      if (i % 7 != 6 && i % 7 != 1) {
        continue;
      }
      boolean ok = true;
      for (int p : primes) {
        if (i % p == 0) {
          ok = false;
          break;
        }
      }
      if (!ok) {
        continue;
      }
      primes.add(i);
    }
    while (true) {
      int n = sc.nextInt();
      if (n == 1) {
        break;
      }
      System.out.print(n + ":");

      for (int p : primes) {
        if (n % p == 0) {
          System.out.print(" " + p);
        }
        if (n == 1) {
          break;
        }
      }
      System.out.println();
    }
  }
}
