package acm.domestic_pre.y2017;

public class Log {
  public static void main(String[] args) {
    for (int i = 1; i <= 10; i++) {
      double n = Math.pow(10, i);
      double logb2 = Math.log(2);
      double logn = Math.log(n) / logb2;
      System.out.println("i     : " + i);
      System.out.println("n     : " + n);
      System.out.println("log(n): " + logn);
    }
  }
}
