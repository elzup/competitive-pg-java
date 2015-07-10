package aoj.intoroduction.itp1;

import java.util.Scanner;

public class Q9AFindingAWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String needle = sc.nextLine().toLowerCase();
        int c = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if ("END_OF_TEXT".equals(line)) {
                break;
            }
            String[] hashstack = line.split(" ");
            for (int i = 0, l = hashstack.length; i < l; i++) {
                String s = hashstack[i];
                if (s.toLowerCase().equals(needle)) {
                    c++;
                }
            }
        }
        System.out.println(c);
    }
}
