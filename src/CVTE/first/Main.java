package CVTE.first;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Scanner in =new Scanner(System.in);
      while(in.hasNext()){
    	  int[] huan = new int[20];
    	  for(int i =0;i<20;i++){
    		  huan[i]=0;
    	  }
    	  int x = in.nextInt();
    	  x = x-1;
    	  int n = in.nextInt();
    	  for(int i =2;i<=n+1;i++){
    		  x = (x+i)%20;
    		  huan[x] = 1;
    	  }
    	  int count = 0;
    	  for(int i =0;i<20;i++){
    		  if(huan[i] == 1){
    			  System.out.print(i+1+" ");
    			  count++;
    		  }
    	  }
    	  if(count == 0){
    		  System.out.print(-1);
    	  }
    	 System.out.println();
      }
	}

}
