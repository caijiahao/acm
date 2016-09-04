package baidu.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         String s = null;
         try {
			while((s=br.readLine())!=null){
				 String[] str = s.trim().split(" ");
				 int num = Integer.parseInt(str[0]);
				 int t = Integer.parseInt(str[1]);
				 int n = Integer.parseInt(str[2]);
				 str = br.readLine().trim().split(" ");
				 int arr[] = new int[num];
				 for(int i = 0;i < num;i++)
					 arr[i] = Integer.parseInt(str[i]);
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				if(br != null)
					br.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
	public static void moveWay(int t,int n,int[] arr){
		if(arr == null || arr.length == 0){
			return;
		}
		int len = arr.length;
		if(n>len){
			System.out.println(0);
		}
		int begin = 0,end = n-1;
		int count = 0;
		int sum = 0;
		for(int i = begin;i<=end;i++){
			sum+=arr[i];
		}
		if(sum<t)
			count++;
		begin++;
		end++;
		while(end<len){
			sum -=arr[begin-1];
			sum+=arr[end];
			if(sum<t)
				count++;
			begin++;
			end++;
		}
		System.out.println(count);
	}
    
}
