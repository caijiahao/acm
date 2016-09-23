package wangyi.second;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
        	int n = Integer.parseInt(in.nextLine());
        	int m = n+1;
        	while(true){
        		if(caclulateRightAgain(n,m)){
        			System.out.println(m);
        			break;
        		}
        		m++;
        	}
        	
        }
	}
    public static int caclulateRight(int num){
    	int count=0;
    	String str = num+"";
    	char[] ch = str.toCharArray();
    	for(int i=0;i<ch.length;i++){
    		if(ch[i]=='1'){
    			count++;
    		}
    		System.out.println(ch[i]);
    	}
    	
    	//System.out.println(count);
    	return count;
    }
    
   public static boolean caclulateRightAgain(int num,int m){
    	int n = num^m;
    	int count=0;
    	while(n>0){
    		if(n%2==1){
    			count++;
    		}
    		num/=2;
    	}
    	if(m-num+1==count){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
}
