package acm.domestic.y2013_2;

import java.util.Arrays;
import java.util.Scanner;

public class Qb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int M = sc.nextInt();
            int T = sc.nextInt();
            int P = sc.nextInt();
            int R = sc.nextInt();
            if ((M | T | P | R) == 0) {
                break;
            }
            Team[] teams = new Team[T];
            for (int i = 0; i < T; i++) {
                teams[i] = new Team(i, P);
            }
            for (int i = 0; i < R; i++) {
                int m = sc.nextInt();
                int t = sc.nextInt() - 1;
                int p = sc.nextInt() - 1;
                int j = sc.nextInt();
                if (j == 0 && !teams[t].solves[p]) {
                    teams[t].solve++;
                    teams[t].solves[p] = true;
                    teams[t].lastTime += m + teams[t].pena;
                    teams[t].pena = 0;
                } else {
                    teams[t].pena += 20;
                }
            }
            // for (int i = 0; i < teams.length; i++) {
            //     System.out.println((i + 1) + ": " + teams[i].solve + ", " + teams[i].lastTime);
            // }

            Arrays.sort(teams);
            System.out.print(teams[0].id + 1);
            for (int i = 1; i < teams.length; i++) {
                System.out.print((teams[i - 1].equalsRank(teams[i]) ? "=" : ",") + (teams[i].id + 1));
            }
            // System.out.println();
            System.out.println();
        }
    }

    public static class Team implements Comparable {
        public int solve;
        public boolean[] solves;
        public int lastTime;
        public int pena;
        int id;

        Team(int id, int m) {
            this.id = id;
            this.solve = 0;
            this.solves = new boolean[m];
            this.pena = 0;
            this.lastTime = 0;
        }

        public boolean equalsRank(Team t) {
            return this.solve == t.solve && this.lastTime == t.lastTime;
        }

        @Override
        public int compareTo(Object o) {
            Team ot = (Team) o;
            int solveC = Integer.compare(this.solve, ot.solve);
            int timeC = Integer.compare(this.lastTime, ot.lastTime);
            if (solveC == 0) {
                if (timeC == 0) {
                    return -Integer.compare(this.id, ot.id);
                }
                return timeC;
            }
            return -solveC;
        }
    }
}
