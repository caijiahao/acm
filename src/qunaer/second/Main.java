package qunaer.second;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
        	String[] str = in.nextLine().split(",");
        	int total = Integer.parseInt(str[1]);
        	String letter = "";
        	for(int i=2;i<str.length;i++){
        		if(i!=str.length-1){
        			str[i]= str[i].substring(str[i].length()-2, str[i].length()-1);
        		}else{
        			str[i]= str[i].substring(str[i].length()-3, str[i].length()-2);
        		}
        		letter+=str[i];
        		//System.out.println(str[i]);
        	}
        	char[] arg = letter.toCharArray();
        	System.out.println(formatString(str[0],total,arg,arg.length));
        }
	}
	 public static String formatString(String A, int n, char[] arg, int m) {
	        // write code here
		/*char[] target = A.toCharArray();
		String B="";
		int j=0;
		for(int i =0;i<target.length-1;i++){
			if(target[i]=='%'){
				B+=arg[j];
				j++;
				i++;
			}else{
				B+=target[i];
			}
			//System.out.println(j);
			//System.out.println(m);
		}
		for(int i=j;i<m;i++){
			B+=arg[i];
		}
		B=B+target[target.length-1];
		 return B;
	    }*/
		 StringBuilder sb = new StringBuilder();
	        int j = 0;
	        for (int i = 0; i < A.length(); ++i) {
	            if (A.charAt(i) == '%') {
	                sb.append(arg[j++]);
	                i++;
	            } else {
	                sb.append(A.charAt(i));
	            }
	        }
	        while (j < m) {
	            sb.append(arg[j++]);
	        }
	        return sb.toString();
	 }

}
