package 贪心算法.田忌赛马;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by lenovo on 2016/12/3.
 * Think:思路：
 贪心算法
 1、对田忌和齐王两人马的速度按照从小到大排序，从两边往中间挨个比较；
 2、贪心策略：
 a。贪赢并发挥马的最大作用，体现在：一、若田强>齐强，则消掉，赢一局；  否则暂停，比较弱马；    二、若田弱>齐弱，则消掉，赢一局；否则，b步；
 b。为后来马创造最佳环境， 体现在：一、若田弱<齐弱，干掉当前齐强；二、若田弱=齐弱，用田弱与当前齐强比较，若田弱=齐强，则平一句，否则干掉齐强，输一局；
 需注意指针挪动；并且要注意“当前”含义，即先把田忌强马和弱马能赢得先赢掉；
 */
public class Main {
    public static void main(String[] args){
        Scanner in =new Scanner(System.in);
        String[] str = null;
        while(in.hasNext()){
            int n = Integer.parseInt(in.nextLine());
            int[] a = new int[n];
            int[] b = new int[n];
            str = in.nextLine().split(" ");
            for(int i =0;i<str.length;i++){
                a[i] = Integer.parseInt(str[i]);
            }
            str = in.nextLine().split(" ");
            for(int i =0;i<str.length;i++){
                b[i] = Integer.parseInt(str[i]);
            }
            //先将田忌和齐王的马排序
            Arrays.sort(a);
            Arrays.sort(b);
            int start = 0,end = n - 1,count = 0;
            for(int i =0;i<n;i++){
                //若田强>齐强，则消掉，赢一局
                while(a[n-1]>b[end]){
                    n--;
                    end--;
                    count++;
                    if(i == n) break;
                }
                if(i == n) break;
                //若田弱=齐弱，用田弱与当前齐强比较，若田弱=齐强，则平一句，否则干掉齐强，输一局
                if(a[i] == b[start]){
                    if(a[i]<b[end]){
                        count--;
                    }
                    end--;
                }
                //若田弱>齐弱，则消掉，赢一局
                else if(a[i] > b[start]){
                    count ++ ;
                    start++;
                }
                //若田弱=齐强，则平一句，否则干掉齐强，输一局；
                else{
                    end--;
                    count--;
                }
            }
            System.out.println(count*200);
        }
    }
}

