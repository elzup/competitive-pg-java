package template;

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
