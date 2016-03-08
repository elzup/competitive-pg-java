package atcoder.arc016;

import java.util.Scanner;

public class QbMusicGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String preLine = "";

        int c = 0;
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < 9; j++) {
                char notes = line.charAt(j);
                if (notes == 'x') {
                    c ++;
                } else if (notes == 'o'){
                    c ++;
                    if (i != 0) {
                        if (preLine.charAt(j) == 'o') {
                            c --;
                        }
                    }
                }
            }
            preLine = line;
        }
        System.out.println(c);
    }
}
