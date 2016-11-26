package 贪心算法.摆方格;

import java.util.Scanner;

/**
 * Created by stevenfen on 2016/11/26.
 */
public class Main {
    public static void main(String[] args){
        long n;
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            n = Long.parseLong(in.nextLine());
            System.out.println((n-1)*n*n-(n-1)*(n-2)+n*n/2-n+2);
        }
    }
}
