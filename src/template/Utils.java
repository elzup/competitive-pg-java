package template;

import algo.Dijkstra;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by hiro on 6/23/15.
 */
public class Utils {
    public static void dumpArray(int[][] k) {
        for (int i = 0; i < k.length; i++) {
            for (int j = 0; j < k[i].length; j++) {
                System.out.print(k[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---");
    }

    public static int max(int[] ns) {
        int max = 0;
        for (int n : ns) {
            max = Math.max(max, n);
        }
        return max;
    }
}

class UnionFind {
    int[] par;
    int n;
    UnionFind(int n){
        this.n = n;
        par=new int[n];
        for(int i=0;i<n;i++)par[i]=i;
    }
    public int find(int x){
        if(par[x]==x) return x;
        return par[x]=find(par[x]);
    }
    public boolean same(int x,int y){
        return find(x)==find(y);
    }
    public void unite(int x,int y){
        if(find(x)==find(y))return;
        par[find(x)]=find(y);
    }
}

class DijkstraMatrix {
    int[][] a;
    boolean[] b;
    PriorityQueue<int[]> q;

    public DijkstraMatrix(int n) {
        a = new int[n + 1][n + 1];
        b = new boolean[n + 1];
        q = new PriorityQueue<int[]>(n + 1, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
    }

    public void set(int i, int j, int cost) {
        a[i][j] = cost;
    }

    public int getCost(int s, int e) {
        Arrays.fill(b, false);
        q.clear();
        b[s] = true;
        int c = 0;
        for (int i = 0; i < a.length; ++i) {
            int[] t = q.poll();
            if (t[0] == e) {
                c = t[1];
                break;
            }
            b[t[0]] = true;
            for (int k = 0; k < a.length; k++) {

                if (!b[k] && a[t[0]][k] > 0) {
                    q.add(new int[] { k, t[1] + a[t[0]][k]});
                }
            }
        }
        return c;
    }
}
