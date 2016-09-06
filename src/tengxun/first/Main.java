package tengxun.first;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
        	String[] str = in.nextLine().split(",");
        	int[] num = new int[str.length-1];
        	str[0]=str[0].substring(1);
        	str[str.length-2] = str[str.length-2].substring(0, 1);
        	int total = Integer.parseInt(str[str.length-1]);
        	for(int i=0;i<total;i++){
        		num[i]=Integer.parseInt(str[i]);
        	}
        	
           if(getValue(num,total)!=-1){
        	   System.out.println(num[getValue(num,total)]);
           }else{
        	   System.out.println(0);
           }
        }
	}
	
	 public static int getValue(int[] gifts, int n) {
	        // write code here
		 Arrays.sort(gifts);
		 int index = 0;
     	int maxCount =0;
		 for(int i=0;i<n;i++){
         	int count =0;
         	int j=i;
         	while(gifts[i]==gifts[j]){
         		count++;
         		j++;
               if(j>=n)
             	  break;
         	}
         	if(count>maxCount){
         		maxCount = count;
         		index = i;
         	}
         	i = j-1;
         }
         if(maxCount>n/2.0){
         	return index;
         }
         else{
         	return -1;
         }
	    }

}
