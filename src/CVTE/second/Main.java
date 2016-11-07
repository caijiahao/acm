package CVTE.second;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {

        Scanner in =new Scanner(System.in);
        while(in.hasNext()){
        	char[] letter = in.nextLine().toCharArray();
        	Stack<String> stack = new Stack<>();
        	for(int i=0;i<letter.length;i++){
        		if(letter[i]=='{'){
        			stack.push("{");
        		}else if(letter[i]=='('){
        			stack.push("(");
        		}else if(letter[i]=='}'){
        			if(stack.peek()=="{"){
        				stack.pop();
        			}
        		}else if(letter[i]==')'){
        			if(stack.peek()=="("){
        				stack.pop();
        			}
        		}
        	}
        	System.out.println( stack.isEmpty());
        	
        }
	}
	
}
