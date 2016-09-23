package wangyi.third;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner in = new Scanner(System.in);
       while(in.hasNext()){
    	   System.out.println(count(in.nextLine()));
       }
	}

	public static int count(String s){
		char ch[] = s.toCharArray();
		int sum = 0;
		for(int i=0;i<ch.length;i++){
			int j = i;
			for(int count =1;count<=(ch.length-i)/2;count++){
			int flag = 0;
			for(int t =1;t<=count;t++){
				int start = j+count;
				System.out.println(start);
				if(ch[j+t]!=ch[start+t]){
					break;
				}
			}
			if(flag==1){
				sum++;
				flag = 0;
			}
			}
		}
		return sum;
	}
}
