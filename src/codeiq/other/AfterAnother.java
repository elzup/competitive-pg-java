package codeiq.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AfterAnother {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fireName = sc.next();
        HashMap<String, Staff> staffs = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            String[] names = sc.next().split(",");
            String cname = names[0];
            String pname = names[1];
            if (!staffs.containsKey(cname)) {
                staffs.put(cname, new Staff(cname));
            }
            if (!staffs.containsKey(pname)) {
                staffs.put(pname, new Staff(pname));
            }
            staffs.get(cname).setMusashino();
            staffs.get(pname).add(staffs.get(cname));
        }
        staffs.get(fireName).fire();
        int c = 0;
        for (Staff s: staffs.values()) {
            if (s.isMusashino && s.active) {
                c ++;
            }
            // System.out.println(s.name + ": " + (s.active ? "1" : "0"));
        }
        System.out.println(c);
    }

    public static class Staff {
        public ArrayList<Staff> children;
        public boolean active;
        public String name;
        public boolean isMusashino;

        public Staff(String name) {
            this.children = new ArrayList<>();
            this.active = true;
            this.name = name;
            this.isMusashino = false;
        }

        public void add(Staff node) {
            this.children.add(node);
        }

        public void setMusashino() {
            this.isMusashino = true;
        }

        public void fire() {
            if (!this.active) {
                return;
            }
            this.active = false;
            for(Staff s: this.children) {
                s.fire();
            }
        }
    }
}

/*
mar
hon,mar
ema,igu
hir,tar
miy,yno
sat,miy
and,miy
oga,sug
igu,oga
kun,ema
*/
