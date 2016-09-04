package mogujie.fourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            String s = null;//s = br.readLine();
            while ((s = br.readLine()) != null) {
                String[] str = s.trim().split(" ");
                int p=Integer.parseInt(str[0]);
                int n=Integer.parseInt(str[1]);
                  
                int[] arr = new int[n];
                for(int i=0;i<n;i++){
                    int num = Integer.parseInt(br.readLine().trim());
                    arr[i] = num;
                }
                getPoints(p, arr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
	public static void getPoints(int n,int[] arr){
        if(arr==null || arr.length<0)
            return;
          
        int[] lk= new int[n];
        for(int i=0;i<arr.length;i++){
            int index = arr[i]%n;
            if(lk[index]!=0){
                System.out.println(i+1);
                return;
            }
            lk[index]=1;
        }
        System.out.println(-1);
    }
}
