package atcoder.atc001;


import java.util.Scanner;

public class UnionFindMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] hw = sc.nextLine().split(" ");
        int N = Integer.parseInt(hw[0]);
        int Q = Integer.parseInt(hw[1]);
        UnionFind uf = new UnionFind(N);

        for (int i = 0; i < Q; i ++) {
            String[] params = sc.nextLine().split(" ");
            int q = Integer.parseInt(params[0]);
            int a = Integer.parseInt(params[1]);
            int b = Integer.parseInt(params[2]);
            if (q == 0) {
                // join
                uf.unite(a, b);
            }
            if (q == 1) {
                // check
                System.out.println(uf.same(a, b) ? "Yes" : "No");
            }
        }
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
