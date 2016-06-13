package acm.domestic_pre.y2016b;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Person[] persons;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        persons = new Person[n];
        for (int i = 0; i < n; i++) {
            float p = sc.nextFloat();
            int pn = sc.nextInt();
            ArrayList<Integer> ps = new ArrayList<>();
            for (int j = 0; j < pn; j++) {
                ps.add(sc.nextInt() - 1);
            }
            persons[i] = new Person(p, ps);
        }
        for (int i = 0; i < persons.length; i++) {
            ArrayList<Integer> close = new ArrayList<>();
            close.add(i);
            persons[i].dfs(persons[i].p, close);
        }
        double k = 1;
        for (int i = 0; i < persons.length; i++) {
            k *= persons[i].calc();
        }
        System.out.println(k);
    }

    static class Person {
        public float p;
        public ArrayList<Integer> children;
        public ArrayList<Double> ps;

        public Person(float p, ArrayList<Integer> children) {
            this.p = 1 - p;
            this.children = children;
            this.ps = new ArrayList<>();
        }

        public void dfs(double k, ArrayList<Integer> close) {
            this.ps.add(k);
            for (int i : this.children) {
                if (close.contains(i)) {
                    continue;
                }
                close.add(i);
                persons[i].dfs(k, close);
            }
        }

        public double calc() {
            double t = (1 - this.p);
            for (double d : this.ps) {
                t *= (1 - d);
            }
            return 1 - t;
        }
    }
}
