package atcoder.abc.abc038;

import java.util.Scanner;

public class QaTea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        System.out.println(n.substring(n.length() - 1).equals("T") ? "YES" : "NO");
    }
}
