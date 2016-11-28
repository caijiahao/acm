package 贪心算法.最大数;

import java.util.Scanner;

/**
 * Created by stevenfen on 2016/11/29.
 */
/*最大的数
        时间限制：1000 ms  |  内存限制：65535 KB
        难度：3
        描述
        小明和小红在打赌说自己数学学的好，于是小花就给他们出题了，考考他们谁NB，题目是这样的给你N个数
        在这n个数之间添加N-1个*或+，使结果最大，但不可以打乱原顺序，请得出这个结果
        如
        1 3 5
        结果是（1+3）*5=20；最大
        可以添加若干个括号，但一定要保证配对，但是每两个数之间只可能有一个*或+
        数列最前和最后不应有+或乘
        小明想赢小红但是他比较笨，请你帮帮他
        输入
        多组测试数据以EOF结束，每组有一个n（n<10000），然后有n个正整数a[i]（1<=a[i]<=20）
        输出
        输出最大的结果由于结果比较大，结果对10086取余
        样例输入
        3
        1 2 3
        3
        5 1 2
        样例输出
        9
        15*/
public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] a = new int[1005];
        while(in.hasNext()){
          int num = Integer.parseInt(in.nextLine());
            String[] str = in.nextLine().split(" ");
            for(int i=0;i<num;i++){
                a[i]=Integer.parseInt(str[i]);
            }

            if(a[0]==1){
                a[1]++;
                a[0] = 0;
            }
            for(int i=1;i<num-1;i++){
                if(a[i] == 1){
                    a[i] = 0;
                    add(i-1,i+1,a);
                }
            }
            if(a[num-1] == 1&& num>1){
                for(int i = num-2;a[i]!=0;i--){
                    a[i]++;
                    a[num-1]=0;
                }
            }
            int sum = 1;
            for(int i=0;i<num;i++){
                if(a[i]!=0){
                    sum = (sum*a[i])%10086;
                }
            }
            System.out.println(sum);
        }
    }
    public static void add(int l,int r,int[] a){
       if(a[l] == 2){
           a[l]++;
           return ;
       }
       if(a[l] == 0){
           l--;
       }
       if(a[l]<=a[r]){
           a[l]++;
       }else{
           a[r]++;
       }
    }
}
