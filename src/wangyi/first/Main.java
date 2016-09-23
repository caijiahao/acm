package wangyi.first;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner in =new Scanner(System.in);
       while(in.hasNext()){
    	   String[] s = in.nextLine().split(" ");
    	   int A=Integer.parseInt(s[0]);
    	   int B=Integer.parseInt(s[1]);
    	   int C=Integer.parseInt(s[2]);
    	   int min = Integer.MAX_VALUE;
    	   int index = A;
    	   int sum1 = 0;
    	   while(C>0){
    		   sum1+=C%10;
    		   C/=10;
    	   }
    	  // System.out.println(sum1);
    	   for(int i=A;i<=B;i++){
    		   if(cacluLateNum(i,sum1)<min){
    			   min = cacluLateNum(i,sum1);
    			   index = i;
    			  // System.out.println(min+":"+index);
    		   }
    		   
    	   }
    	   System.out.println(index);
       }
       
	}

	public static int cacluLateNum(int num,int C){
		int sum = 0;
		while(num>0){
			sum+=num%10;
			num/=10;
		}
		
		return Math.abs(sum-C);
	}
}
