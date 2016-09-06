package jingdong.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner in = new Scanner(System.in);
       while(in.hasNext()){
    	   List list = new ArrayList();
    	   String[] str =in.nextLine().split(" ");
    	   int n =Integer.parseInt(str[0]);
    	   int m = Integer.parseInt(str[1]);
    	   //System.out.println(n+""+m);
    	   str = in.nextLine().split(" ");
    	   int[] price = new int[n];
    	   for(int i=0;i<str.length;i++){
    		   price[i]=Integer.parseInt(str[i]);
    		   //System.out.println(price[i]);
    	   }
    	    
    	   String[] shop = new String[m];
    	   for(int i=0;i<m;i++){
    		   shop[i] = in.nextLine();
    		   //System.out.println(shop[i]);
    	   }
    	   
    	 for(int i =0;i<m;i++){
    		 int j=i;
    		 int count =0;
    		 while(shop[i].equals(shop[j])){
    			 count++;
    			 j++;
    			 if(j>=m){
    				 break;
    			 }
    			// System.out.println(j);
    		 }
    		 list.add(count);
    		 i=j-1;
    	 }
    	 list.sort(null);
         int[] shopNumber = new int[list.size()];
         for(int i=0;i<list.size();i++){
        	 shopNumber[i]=(int) list.get(i);
         }
         System.out.println(getMinPrice(price,shopNumber)+" "+getMaxPrice(price,shopNumber));
       }
	}
	
	public static int getMaxPrice(int[] price,int[] shopNumber){
		Arrays.sort(price);
		int sum =0;
		int j =0;
		for(int i=price.length-shopNumber.length;i<price.length;i++){
			sum+=price[i]*shopNumber[j];
			j++;
		}
		return sum;
	}
	
	public static int getMinPrice(int[] price,int[] shopNumber){
		Arrays.sort(price);
		int sum =0;
		int j =shopNumber.length-1;
		for(int i=0;i<shopNumber.length;i++){
			sum+=price[i]*shopNumber[j];
			j--;
		}
		return sum;
	}

}
