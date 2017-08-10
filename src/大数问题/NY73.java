package 大数问题;

import java.io.BufferedInputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by stevenfenCai on 2017/8/10.
 */
public class NY73 {
    public static void main(String[] args){

        Scanner cin = new Scanner(new BufferedInputStream(System.in));
        List result = new ArrayList();
        int temp = 10;
        while(cin.hasNext()&&temp>0){
            BigInteger a = new BigInteger(cin.next());
            BigInteger b = new BigInteger(cin.next());
            BigInteger zero = new BigInteger("0");
            if(a.compareTo(b)<0){
                result.add("a<b");
            }
            else if(a.compareTo(b) > 0){
                result.add("a>b");
            }
            else if(a.compareTo(zero) == 0 && a.compareTo(b)!=0){
                result.add("a==b");
            }else if(a.compareTo(zero) == 0 && a.compareTo(b) == 0){
                break;
            }
            temp--;
        }
        for(int i = 0;i<result.size();i++){
            System.out.println(result.get(i));
        }
    }
}
