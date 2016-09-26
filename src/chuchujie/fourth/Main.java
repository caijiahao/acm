package chuchujie.fourth;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner in = new Scanner(System.in);
       while(in.hasNext()){
    	   int n = Integer.parseInt(in.nextLine());
    	   String str = in.nextLine();
    	   int[] index = new int[n+1];
    	   index[n] = str.length()-1;
    	   for(int i=0;i<n;i++){
    		   index[i]=str.indexOf((i+1)+"");
    	   }
    	   Arrays.sort(index);
    	   for(int i=0;i<n;i++){
    		   if(i==n-1){
    			   //System.out.println(index[i]+":"+index[i+1]);
    			   System.out.println(str.substring(index[i])+" ");
    		   }else{
    			   System.out.print(str.substring(index[i], index[i+1])+" ");
    		   }
    	   }
       }
	}

}
