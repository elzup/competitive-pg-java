package atcoder.abc029;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // nones:=proc(n) local nn, c, j: nn:=convert(n, base, 10): c:=0: for j to nops(nn) do if nn[j]=1 then c:=c+1 else end if end do: c end proc: a:=proc(n) options operator, arrow: add(nones(k), k=1..n) end proc: seq(a(n), n=1..75);
    }
}

/*

1  1
2  1
3  1
4  1
5  1
6  1
7  1
8  1
9  1
10 2
11 4
12 5
13 6
14 7
15 8
16 9
17 10
18 11
19 12
20 12
21 13
22 13
23 13
24 13
25
26
27


1,1,1,1,1,1,1,1,1,2,4,5,6,7,8,9,10,11,12,12,13,13,13,13


 */