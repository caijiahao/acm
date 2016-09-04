package mogujie.second;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Scanner in = new Scanner(System.in);
      while (in.hasNext()) {
		int n  = in.nextInt();		
		int arr[] = new int[n];
		for(int i =0;i<n;i++){
			arr[i] = in.nextInt();
		}
		int maxfull = Integer.MIN_VALUE,minMaxGroup = Integer.MAX_VALUE;
		
		for(int i = 1;i<n;i++){
			maxfull = Math.max(arr[i]-arr[i-1], maxfull);
		}
		
		for(int i =2;i<n-1;i++){
			minMaxGroup = Math.min(minMaxGroup, Math.max(arr[i+1]-arr[i-1], maxfull));
		}
		System.out.println(minMaxGroup);
	}
      in.close();
	}

}
