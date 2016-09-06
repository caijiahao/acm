package jingdong.second;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner in =new Scanner(System.in);
       while(in.hasNext()){
    	   String[] str = in.nextLine().split(" ");
    	 int n = Integer.parseInt(str[0]);
    	 int m = Integer.parseInt(str[1]);
    	 int lastDay = 0;
    	 int lasthigh = 0;
         int newDay = 0;
         int newHigh = 0;
         boolean flag = true;
    	 for(int i =0;i<m;i++){
    		 str=in.nextLine().split(" ");
    		 lastDay = newDay;
    		 lasthigh =newHigh;
    		 newDay =Integer.parseInt(str[0]);
    		 newHigh = Integer.parseInt(str[1]);
    		 if((newDay-lastDay)*2<newHigh-lasthigh){
    			 flag =false;
    		 }
    	 }
    	 if(!flag){
    		 System.out.println("IMPOSSIBLE");
    	 }else{
    		 System.out.print(newHigh+(n-newDay)*2);
    	 }
  	}
	}
}
