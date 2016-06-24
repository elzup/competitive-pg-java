package acm.domestic.y2016;

import java.util.Scanner;

/**
 * Created by hiro on 2016/06/24.
 */
public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true){
            int m = sc.nextInt();
            int n = sc.nextInt();

            if(m==0&&n==0){
                break;
            }

            int[] area =new int[n];
            int ans = m;

            for (int i = 0; i < n; i++) {
                if (area[i]==0){
                    area[i] = ans;
                }

                boolean isPrime = false;
                for (int j = 2; j < Math.sqrt(ans); j++) {
                    if ((ans/j) * j != ans) continue;
                    isPrime = true;
                }

                if (isPrime || (ans/area[i]) * area[i] == ans){
                    ans++;
                    i=-1;
                    continue;
                }
            }
            System.out.println(ans);
        }
    }
}
