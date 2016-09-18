package sougou.second;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner in =new Scanner(System.in);
       while(in.hasNext()){
    	   int max=0;
    	   String[] s = in.nextLine().split(" ");
    	   int n = Integer.parseInt(s[0]);
    	   int m = Integer.parseInt(s[1]);
    	   int[][] num = new int[n][m];
    	   
    	   for(int i=0;i<n;i++){
    		 s=in.nextLine().split(" ");
    		 for(int j=0;j<m;j++){
    			 num[i][j]=Integer.parseInt(s[j]);
    		 }
    	   }
    	   
    	   for(int i=0;i<n;i++){
    		   for(int j=0;j<m;j++){
    			   int sum=1;
    			   
    			   for(int t=0;t<m;t++){
    				   if(t!=j){
    					   sum*=num[i][t];
    				   }
    			   }
    			   
    			   for(int t=0;t<n;t++){
    				   if(t!=i){
    					   sum*=num[t][j];
    				   }
    			   }
    			   
    			   if(max<sum){
    				   max = sum;
    			   }
    		   }
    	   }
    	   
    	   System.out.println(max);
       }
	}

}
