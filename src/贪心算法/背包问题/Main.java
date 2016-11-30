package 贪心算法.背包问题;

import java.util.Scanner;

/**
 * Created by stevenfen on 2016/11/30.
 * 背包问题
 时间限制：3000 ms  |  内存限制：65535 KB
 难度：3
 描述
 现在有很多物品（它们是可以分割的），我们知道它们每个物品的单位重量的价值v和重量w（1<=v,w<=10）；如果给你一个背包它能容纳的重量为m（10<=m<=20）,你所要做的就是把物品装到背包里，使背包里的物品的价值总和最大。
 输入
 第一行输入一个正整数n（1<=n<=5）,表示有n组测试数据；
 随后有n测试数据，每组测试数据的第一行有两个正整数s，m（1<=s<=10）;s表示有s个物品。接下来的s行每行有两个正整数v，w。
 输出
 输出每组测试数据中背包内的物品的价值和，每次输出占一行。
 */
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String[] str = null;
        while(n-->0){
            int[] DP=new int[25];
            str = in.nextLine().split(" ");
            int num = Integer.parseInt(str[0]);
            int maxHeight = Integer.parseInt(str[1]);
            while(num-->0){
                str = in.nextLine().split(" ");
                int v = Integer.parseInt(str[0]);
                int w = Integer.parseInt(str[1]);
                for(int k =0;k<w;k++){
                    for(int j = maxHeight;j>0;j--){
                        DP[j]=max(DP[j-1]+v,DP[j]);
                       // System.out.println(DP[j]);
                    }
                }
            }
            System.out.println(DP[maxHeight]);
        }
    }

    public static int max(int a,int b){
        return a>b?a:b;
    }
}
