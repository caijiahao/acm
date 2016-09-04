package mogujie.frith;

import java.util.Scanner;

public class Main {
	private boolean change = false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Scanner cin = new Scanner(System.in);
      while(cin.hasNext()){
    	  String arr = cin.next();
    	  Main testMain = new Main();
    	  System.out.println(testMain.huiwen(arr)?"YES":"NO");
      }
	}
	public boolean huiwen(String arr){
		int len = arr.length();
		boolean result = true;
		if(len!=1&&len!=0){
			if(arr.charAt(0)!=arr.charAt(len-1)){
			if(change){
				result = false;
			}else{
				change = true;
				result = huiwen(arr.substring(1,len))|huiwen(arr.substring(0,len-1));
			}
			}
			else{
				result = huiwen(arr.substring(1,len-1));
			}
		}
		return result;
	}
}
