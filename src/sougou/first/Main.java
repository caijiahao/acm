package sougou.first;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner in = new Scanner(System.in);
       while(in.hasNext()){
    	   int N = Integer.parseInt(in.nextLine());
    	   Map<Integer,String> map = new HashMap<Integer,String>();
    	   Set<Integer> set = new HashSet<Integer>();
    	   for(int i=0;i<N;i++){
    		   String s = in.nextLine();
    		   String[] a = s.split(" ");
    		   int c = Integer.parseInt(a[1]);
    		   String ss="";
    		   int key = Integer.parseInt(a[0]);
    		   int count=0;
    		   Set<Integer> set1 = new HashSet<Integer>();
    		   set1.add(key);
    		   for(int j=0;j<c;j++){
    			   int h = Integer.parseInt(a[j+2]);
    			   if(set.contains(h)&&!set1.contains(h)){
    				   count++;
    				   set1.add(h);
    			   }
    			   if(count==2){
    				   set.add(key);
    			   }
    			   if(!set1.contains(h)&&map.get(h)!=null){
    				   if(map.get(h).contains(key+"")){
    					   set.add(h);
    					   set.add(key);
    				   }
    			   }
    			   ss+=h+" ";
    		   }
    		   map.put(key, ss);  
    	   }
    	   System.out.println(set.size());
           int size=set.size();
           for(int mm:set){
               if(size-->1) System.out.print(mm+" ");
               else System.out.println(mm);
           }
       }
	}

}
