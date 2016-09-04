package huawei.third;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
        	System.out.println(chkLegal(in.nextLine()));
        }
	}
    public  static boolean chkLegal(String A){
    	char[] string = A.toCharArray();
    	Stack<Character> s1 = new Stack<>();
    	Stack<Character> s2 = new Stack<>();
    	Stack<Character> s3 = new Stack<>();
    	for(int i = 0;i<string.length;i++){
    		switch(string[i]){
    		case '{':
    			s1.push(string[i]);
    			break;
    		case '[':
    			s2.push(string[i]);
    			break;
    		case '(':
    			s3.push(string[i]);
    			break;
    		case '}':
    			s1.pop();
    			break;
    		case ']':
    			s2.pop();
    			break;
    		case ')':
    			s3.pop();
    			break;			
    		}
    	}
		return s1.isEmpty()&&s2.isEmpty()&&s3.isEmpty();
    	
    }
}
