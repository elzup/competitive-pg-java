package atcoder.agc.agc017;

import java.math.BigInteger;
import java.util.Scanner;

public class A {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int p = sc.nextInt();
    int odd = 0;
    for (int i = 0; i < n; i++) {
      if (sc.nextInt() % 2 == 1) {
        odd++;
      }
    }
    int even = n - odd;
//    System.out.println("o: " + odd);
//    System.out.println("e: " + even);
    BigInteger res;
    BigInteger en = BigInteger.ZERO;
    BigInteger on = BigInteger.ZERO;
    for (int i = 0; i <= even; i++) {
      en = en.add(choose(BigInteger.valueOf(even), BigInteger.valueOf(i)));
    }
    if (p == 0) {
      for (int i = 0; i <= odd; i += 2) {
        on = on.add(choose(new BigInteger("" + odd), new BigInteger("" + i)));
      }
    } else {
      for (int i = 1; i <= odd; i += 2) {
        on = on.add(choose(new BigInteger("" + odd), new BigInteger("" + i)));
      }
    }
    res = on.multiply(en);
//    System.out.println("on: " + on);
//    System.out.println("en: " + en);
    System.out.println(res.toString());
  }

  public static BigInteger[][] memo = new BigInteger[101][101];

  static BigInteger choose(BigInteger n, BigInteger k) {

    if (n.intValue() == 0 && k.intValue() > 0) {
      return BigInteger.ZERO;
    } else if (k.intValue() == 0 && n.intValue() >= 0) {
      return BigInteger.ONE;
    } else if (memo[n.intValue()][k.intValue()] != null) {
      return memo[n.intValue()][k.intValue()];
    } else {
      memo[n.intValue()][k.intValue()] = choose(n.subtract(BigInteger.ONE), k.subtract(BigInteger.ONE)).add(choose(n.subtract(BigInteger.ONE), k));
    }
    return memo[n.intValue()][k.intValue()];

  }

  // mod combination
  static long modComb(long a, long b, long mod) {
    long res = 1;
    for (long i = a; i > a - b; i--) {
      res = (res * i) % mod;
    }
    for (long i = b; i > 1; i--) {
      res = (res * inv(i, mod)) % mod;
    }
    return res;
  }

  static long inv(long a, long mod) {
    return powMod(a, mod - 2, mod);
  }

  // a ^ b (mod p)
  static long powMod(long a, long b, long p) {
    if (b == 0) {
      return 1;
    }
    if (b % 2 == 0) {
      long d = powMod(a, b / 2, p);
      return d * d % p;
    }
    return a * powMod(a, b - 1, p) % p;
  }
  static long N;

  static BigInteger factorial(int n) {
    if (n < 2) {
      return BigInteger.ONE;
    }
    BigInteger p = BigInteger.ONE, r = BigInteger.ONE;
    N = 1;
    int log2n = 31 - Integer.numberOfLeadingZeros(n);
    int h = 0, shift = 0, high = 1;
    while (h != n) {
      shift += h;
      h = n >>> log2n--;
      int len = high;
      high = (h & 1) == 1 ? h : h - 1;
      len = (high - len) >> 1;
      if (len > 0) {
        r = r.multiply((p = p.multiply(bp(len))));
      }
    }
    return r.shiftLeft(shift);
  }

  static BigInteger bp(int n) {
    int m = n >> 1;
    if (m == 0) {
      return BigInteger.valueOf(N += 2);
    } else if (n == 2) {
      return BigInteger.valueOf(N += 2).multiply(BigInteger.valueOf(N += 2));
    }
    return bp(n - m).multiply(bp(m));
  }
}

