package lanqiaobei;

import java.util.Scanner;

/**
 * Created by stevenfenCai on 2017/11/6.
 */
public class ALGO148 {
    public  static void main(String[] args){
        //定义两个整型数
        int min;
        int max;
        Scanner scanner = new Scanner(System.in);
        min = scanner.nextInt();
        max = scanner.nextInt();

        if(min>max){
            int index = max;
            max = min;
            min = index;
        }

        System.out.println(Lcm(min,max));

    }

    public static int Gcd(int min,int max){
        while(max%min!=0){
            int k = max%min;
            max = min;
            min = k;
        }
        return min;
    }
    public static int Lcm(int min,int max){
         return min*max/Gcd(min,max);
    }
}
