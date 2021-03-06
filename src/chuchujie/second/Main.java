package chuchujie.second;

/**
 * 题目描述

原来是要到醋溜站台乘坐醋溜快车到醋溜港”，亮亮解出了地图隐藏的秘密，赶紧奔向醋溜站台，但到了之后，亮亮忧桑地发现，从醋溜站台到醋溜港沿途的每个车站都有很多美女被他飒爽的英姿所吸引，只要经过车站就会被这些漂亮的女孩搭讪，但是现在亮亮一心想要寻找楚楚街而没空去搭理她们，所以亮亮希望在抵达醋溜港的时候被搭讪的次数最少。问亮亮抵达醋溜港最少会被搭讪多少次？

输入描述:
第一行包含两个整数N(2<=N<=5000),M(1<=M<=50000)。N表示公有N个汽车站，M表示公有M条公路，起点为1，终点为N。
第二行包含N个整数(0<=K<=10000)，第i个整数表示在第i站有K个美女想要搭讪亮亮。
接下来M行，每行包含两个整数P(1<=P<=N),Q(1<=Q<=N),代表P,Q两个站是有班车直达的。


输出描述:
一个整数，即亮亮抵达醋溜港最少需要被搭讪的次数。

输入例子:
5 5
0 1 1 3 6
1 2
1 4
2 3
3 5
4 5

输出例子:
8
 */
import java.util.Scanner;
//不会做，图算法
public class Main {

  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      while (scanner.hasNext()) {
          int n = scanner.nextInt();
          int m = scanner.nextInt();
          int[] dij = new int[n + 1], station = new int[n + 1], vis = new int[n + 1];
          int[][] road = new int[n + 1][n + 1];

          for (int i = 0; i <= n; i++) {
              dij[i] = Integer.MAX_VALUE;
          }
          for (int i = 1; i <= n; i++) {
              station[i] = scanner.nextInt();
          }
          for (int i = 0; i < m; i++) {
              int p = scanner.nextInt();
              int q = scanner.nextInt();
              road[p][q] = 1;
              road[q][p] = 1;
          }
          dij[1] = station[1];
          vis[1] = 1;
          int tmp_i = 1;
          for (int i = 0; i < n - 1; i++) {
        	  System.out.println(tmp_i);
              for (int j = 1; j <= n; j++) {
                  if (vis[j] == 0 && road[tmp_i][j] == 1) {
                      dij[j] = Math.min(dij[j], dij[tmp_i] + station[j]);
                  }
              }

              int tmp_min = Integer.MAX_VALUE;
              for (int j = 1; j <= n; j++) {
                  if (vis[j] == 0 && dij[j] <= tmp_min) {
                      tmp_i = j;
                      tmp_min = dij[j];
                  }
              }

              vis[tmp_i] = 1;
          }
         /* for(int i=0;i<=n;i++)
          System.out.println(dij[i]);*/
      }
      scanner.close();
  }

}
