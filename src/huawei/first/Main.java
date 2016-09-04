package huawei.first;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Scanner in = new Scanner(System.in);
      while(in.hasNext()){
    	  int f =0;
    	  int a = in.nextInt();
    	  for(int i =2;i<=a;i++){
    		  f=(f+3)%i;
    	}
    	  System.out.println(f);
      }
	}
}
