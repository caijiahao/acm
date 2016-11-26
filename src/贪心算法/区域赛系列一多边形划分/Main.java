package 贪心算法.区域赛系列一多边形划分;

import java.util.Scanner;

/**
 * Created by stevenfen on 2016/11/26.
 */
/*解法微博：http://www.cnblogs.com/handsomecui/p/4963396.html*/
/*
区域赛系列一多边形划分
时间限制：1000 ms  |  内存限制：65535 KB
难度：2
描述
Give you a convex（凸边形）, diagonal n-3 disjoint divided into n-2 triangles(直线), for different number of methods, such as n=5, there are 5 kinds of partition method, as shown in Figure





输入
The first line of the input is a n (1<=n<=1000), expressed n data set.
The next n lines each behavior an integer m (3<=m<=18), namely the convex edges.
输出
For each give m,, output how many classification methods.
example output: Case #a : b
样例输入
3
3
4
5
样例输出
Case #1 : 1
Case #2 : 2
Case #3 : 5
 */
public class Main {
    public static void main(String[] args){
      Scanner in =new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int caseNum = 1;
        Long[] result = new Long[20];
        result = createCatalan();
       while(n-->0){
          int m = Integer.parseInt(in.nextLine()) -2;
           String str = String.format("Case #%d : %d",caseNum++,result[m]);
           System.out.println(str);
       }
    }
    /*
    生成3到18之间的卡塔兰数数组
     */
    public static Long[] createCatalan(){
        Long[] result = new Long[20];
        result[0] = 1L;
        result[1] = 1L;
        result[2] = 2L;
        int t ;
        for(int i=3;i<=18;i++){
            result[i] = 0L;
            t = i-1;
            for(int j=0;j<i;j++){
                result[i] += result[j] * result[t--];
            }

        }
        return result;
    }
}
