package 贪心算法.阶乘之和;

import java.util.Scanner;

/**
 * Created by stevenfen on 2016/11/30.
 * 时间限制：3000 ms  |  内存限制：65535 KB
 难度：3
 描述
 给你一个非负数整数n，判断n是不是一些数（这些数不允许重复使用，且为正数）的阶乘之和，如9=1！+2!+3!，如果是，则输出Yes，否则输出No；
 输入
 第一行有一个整数0<m<100,表示有m组测试数据；
 每组测试数据有一个正整数n<1000000;
 输出
 如果符合条件，输出Yes，否则输出No;
 样例输入
 2
 9
 10
 样例输出
 Yes
 No
 */
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] k = {1,2,6,24,120,720,5040,40320,362880};
        while(n-->0){
            boolean flag = false;
            int m = Integer.parseInt(in.nextLine());
            for(int i = 8;i>=0;i--){
                if(m >= k[i] && m > 0){
                    m -= k[i];
                }
                if(m == 0){
                    flag = true;
                }
            }
            if(flag)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
}
