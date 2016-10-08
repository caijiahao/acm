package chuchujie.five;

/*
 * 本题本质上是求最小生成树，这里使用经典算法Kruskal，得到最少生成树后遍历该树的边，把边权重最大的找出来，即为题目所求。
 题目转化为1.....N 个顶点，M条边组成的无向图，其中P、Q、K代表P、Q两个顶点之间存在边，并且边权重为K。
 * */
import java.util.*;
public class Main{
    public static void main(String[] args)
    {
         
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
             String []nm=in.nextLine().split(" ");
             final int n = Integer.parseInt(nm[0]);
             final int m = Integer.parseInt(nm[1]);
             //初始化辅助数组，如果verSet[i]==verSet[j]代表是同一个集合里的。初始化为verSet[i]=i；代表n个独立的集合。
             int []verSet = new int[n+1];
             //P、Q、K分别看作为边的两点及边的权重，用力保存边。Edge为保存边的类
             Edge []eSet = new Edge[m];
 
             for(int i=0 ;i<m; i++){
                 String []pqk=in.nextLine().split(" ");
                 eSet[i] = new Edge();
                 eSet[i].u = Integer.parseInt(pqk[0]);
                 eSet[i].v = Integer.parseInt(pqk[1]);
                 eSet[i].w = Integer.parseInt(pqk[2]);
             }
             //对图进行最少生成树操作，函数返回最少生成树的边集。
             ArrayList<Edge> res = Kruskal(verSet, n, eSet);
             //遍历边集合，求出最大的边权重
             int max=0;
             for(int i = 0;i < res.size(); i++){
                 int w = (res.get(i)).w;
                 if(max<w) max = w;
             }
             System.out.println(max);
        }
   
    }
 
     
    public static ArrayList<Edge>  Kruskal(int []verSet, int n,Edge []eSet){
       //初始化辅助数组，如果verSet[i]==verSet[j]代表是一个集合里的。初始化为verSet[i]=i；代表n个独立的集合。
       for(int i=1; i<=n; i++){
            verSet[i] = i;
        }
       //对边进行非递减排序
        Arrays.sort(eSet);
       //计算最少生成树的顶点数。
        int count = 1;
        //遍历边数组的下标
        int k=0;
        //用于保存最小生成树的边集合。
        ArrayList<Edge> res_list = new ArrayList<Edge>(10007);
        while(count<n){//循环次数，count每增加一次至少归集一个顶点，
            int v1 = verSet[eSet[k].u];
            int v2 = verSet[eSet[k].v];
            if(v1!=v2){//不在一个集合里
                count++;
                //保存边
                res_list.add(eSet[k]);
                //归并同属于一个集合的顶点
                for(int i=1; i<=n;i++){
                    if(verSet[i]==v2)
                        verSet[i]=v1;
                }
            }
            //遍历下一条边
            k++;
        }
        return res_list;
    }
}
 
class Edge implements Comparable<Edge>{
    public int u;
    public int v;
    public int w;
    Edge(){
       this.u=-1;
       this.v=-1;
       this.w=-1;
    }
    Edge(int u, int v, int w){
       this.u = u;
       this.v = v;
       this.w = w;
    }
    public int compareTo(Edge o)
    {
        return this.w - o.w;
    }
     
}
class SortByW implements Comparator {
     public int compare(Object o1, Object o2) {
         Edge s1 = (Edge) o1;
         Edge s2 = (Edge) o2;
         if (s1.w > s2.w)
             return 1;
         else return 0;
        }
}