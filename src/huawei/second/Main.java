package huawei.second;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner in = new Scanner(System.in);
       while(in.hasNext()){
    	   int[] num = new int[58];
    	   for(int i =0;i<58;i++){
    		   num[i] = 0;
    	   }
    	   String str = in.nextLine();
    	   char[] arr = str.toCharArray();
    	   StringBuffer newString = new StringBuffer();
    	   for(int i =0;i<arr.length;i++){
    		   if(num[arr[i]-'A']==0){
    			   newString.append(arr[i]);
    			   num[arr[i]-'A'] = 1;
    		   }
    	   }
    	   System.out.println(newString);
       }
	}

}
