package chuchujie.third;

/*
本题目可以转化为计算图的单源最短路径。图的单源最短路径算法有几种，但考虑的时效性，这里选择Dijkstra，算法复杂度约为O(V^2)
*/
import java.util.*;
public class Main{
     
    public static void main(String[] args)
    {
        //二维数组，用来表示图的邻接矩阵
        int g[][] = new int[501][501];
        //二维数组，用来表示量港之间的航线第X天不能启航的值
        int x[][] = new int[501][501];
        //二维数组，用来表示量港之间的航线第Y天不能启航的值
        int y[][] = new int[501][501];
        //港的数量
        int n=0;
        //航线数
        int m=0;
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
             String ntc[]=in.nextLine().split(" ");
             n=Integer.parseInt(ntc[0]);
             m=Integer.parseInt(ntc[1]);
             //初始化x[][],y[][],g[][],如果港i和港j没有直接的航线g[i][j]=Integer.MAX_VALUE;
             for(int i=1; i<=n; i++){
                 for(int j=1; j<=n; j++){
                          x[i][j] = 0;
                          y[i][j] = 0;
                          g[i][j] = Integer.MAX_VALUE;
                 }
             }           
              
             int inputCount = m;
             while(inputCount>0&&in.hasNext()){
                 String[]a=in.nextLine().split(" ");
                 int p = Integer.parseInt(a[0]);
                 int q = Integer.parseInt(a[1]);
                 int k = Integer.parseInt(a[2]);
                 int x1 = Integer.parseInt(a[3]);
                 int y1 = Integer.parseInt(a[4]);
                 g[p][q] = k;
                 g[q][p] = k;
                 x[p][q] = x1;
                 x[q][p] = x1;
                 y[p][q] = y1;
                 y[q][p] = y1;
                 inputCount--;
           }
            
           System.out.println(Dijkstra(g,x,y,n,1));
            
        }
         
    }
    /*
    图的单源最短路径算法。
    [][]g：二维矩阵g的g[i][j]代表港i到港j的航线需要的天数；
    [][]x:二维矩阵x的x[i][j]代表港i到港j的航线不能启航的第X天；
    [][]x:二维矩阵y的y[i][j]代表港i到港j的航线不能启航的第Y天；
    n:港的数量；
    s：启航的港
    */ 
     
    static int Dijkstra(int [][]g,int [][]x,int [][]y, int n,int s){
        //定义d，d[i]代表s点到i点的最短距离;
        int []d = new int[n+1];
        //定义计算路径（调试用）
        int []pi = new int[n+1];
        //初始化d[i]为最大整数值；
        for(int i=0; i<=n; i++){
            d[i] = Integer.MAX_VALUE;
        }
        //初始化起点为d[s]=0。
        d[s] = 0;
        //标记源点s到i点的最短距离是否已经找到，如果 visied[i]=1,代表d[i]以为最小。  
        int visied[] = new int[n+1];
        //初始化起点
        for(int i=1; i<=n;i++){
            //选择一个最小的定点
            int min = Integer.MAX_VALUE;
            int min_p = 0;
            for(int j=1; j<=n; j++){
                if(d[j]<min && visied[j]==0){
                    min = d[j];
                    min_p = j;
                }
            }
            visied[min_p] = 1;
            pi[i] = min_p;
     
            //
            for(int k=1; k<=n;k++){
                if(visied[k]!=1 && g[min_p][k]!=Integer.MAX_VALUE ){
                    int temp = d[min_p] + g[min_p][k];
                    if(temp<x[min_p][k]){
                        if(d[k]>temp)
                            d[k] = temp;
                    }else{
                            if(d[min_p]>y[min_p][k]){
                                if(d[k]>temp)
                                    d[k] = temp;
                            }else{
                                if(d[k]>y[min_p][k]+g[min_p][k])
                                    d[k] = y[min_p][k]+g[min_p][k];
                                }
      
                        }
 
 
                }   
            }
        }
     //d[n]为启航点港到n的最短用时，例如d[n]为8天，但到达时间为d[n]+1，即9天。
     return d[n]+1;    
   }
     
}

