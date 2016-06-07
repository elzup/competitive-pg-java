package acm.domestic.y2013;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Ranking {
    static Scanner sc;

    final static int INF = Integer.MAX_VALUE;

    static int M;
    static int P;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        while (true) {
            M = sn();
            int T = sn();
            P = sn();
            int R = sn();
            if ((M | T | P | R) == 0) {
                break;
            }
            Team[] teams = new Team[T];
            for (int i = 0; i < T; i++) {
                teams[i] = new Team(i, P);
            }
            for (int i = 0; i < R; i++) {
                int m = sn();
                int t = sn();
                int p = sn();
                int j = sn();
                teams[t - 1].addScore(p, m, j == 0);
            }

            for (int i = 0; i < T; i++) {
                teams[i].calc();
            }
            Arrays.sort(teams, new Comparator<Team>() {
                @Override
                public int compare(Team o1, Team o2) {
                    if (o1.getSucsessNum() != o2.getSucsessNum()) {
                        return o2.getSucsessNum() - o1.getSucsessNum();
                    }
                    if (o1.time != o2.time) {
                        return o1.time - o2.time ;
                    }
                    return o2.id - o1.id;

                }
            });

            for (int i = 0; i < T; i++) {
                System.out.print(teams[i].id);
                if (i != T - 1) {
                    System.out.print((teams[i + 1].point() == teams[i].point()) ? "=" : ",");
                }
            }
            System.out.println();
        }
    }

    public static void solve(int w, int h) {

    }

    public static int sn() {
        return sc.nextInt();
    }

    static class Team {
        public int[] penarlty;
        public Boolean[] sucsess;
        public int time;
        public int id;

        public Team(int id, int n) {
            this.id = id + 1;
            this.time = 0;
            this.penarlty = new int[n];
            this.sucsess = new Boolean[n];
            Arrays.fill(this.penarlty, 0);
            Arrays.fill(this.sucsess, false);
        }

        public void addScore(int n, int time, boolean isScusess) {
            this.sucsess[n - 1] |= isScusess;
            if (this.sucsess[n - 1]) {
                this.time += time;
            } else {
                this.penarlty[n - 1]++;
            }
        }

        public void calc() {
            for (int i = 0; i < this.sucsess.length; i++) {
                if (sucsess[i]) {
                    this.time += this.penarlty[i] * 20;
                }
            }
        }

        public int getSucsessNum() {
            return (int) Arrays.stream(this.sucsess).filter(x -> x).count();
        }

        public int point() {
            return this.getSucsessNum() * M * P + this.time;
        }
    }
}
