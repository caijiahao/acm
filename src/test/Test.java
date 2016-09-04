package test;
import java.util.Scanner;
import java.util.*;
public class Test {

	public static int calculateMax(int[] prices){
		if(prices == null || prices.length<2){
			return 0;
		}
		int len = prices.length;
		int[] left = new int[len];
		left[0]=0;
		int min = prices[0];
		int max = 0;
		for(int i=1;i<len;i++){
			if(prices[i]<min)
				min = prices[i];
			if(prices[i]-min>max){
				max = prices[i]-min;
			}
			left[i] = max;
		}
		int[] right = new int[len];
		right[0] = 0;
		int high = prices[len-1];
		max = 0;
		for(int i = len-2;i>=0;i--){
			if(prices[i]>high)
				high = prices[i];
			if(high-prices[i]>max){
				max=high-prices[i];
			}
			right[i] = max;
		}
		int result = 0;
		for(int i =0;i<len;i++){
			if(left[i]+right[i]>result){
				result = left[i]+right[i];
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
             int n = in.nextInt();
             int[] prices = new int[5];
             for(int i =0;i<5;i++){
            	 prices[i] = in.nextInt();
             }
             System.out.println(calculateMax(prices));
	}

}
