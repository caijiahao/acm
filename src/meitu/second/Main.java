package meitu.second;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author stevenfen
 * 题目描述

对于一个由0..n的所有数按升序组成的序列，我们要进行一些筛选，每次我们取当前所有数字中从小到大的第奇数位个的数，并将其丢弃。重复这一过程直到最后剩下一个数。请求出最后剩下的数字。

输入描述:
每组数据一行一个数字，为题目中的n(n小于等于1000)。


输出描述:
一行输出最后剩下的数字。

输入例子:
500

输出例子:
255
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner in = new Scanner(System.in);
       while(in.hasNext()){
    	   List<Integer> list = new ArrayList<>();
    	   List<Integer> removeList = new ArrayList<>();
    	   int n = in.nextInt();
    	   for(int i=0;i<=n;i++){
    		   list.add(i);
    	   }
    	   while(list.size()>1){
    		   int i=1;
    		   while(i<=list.size()){
    			   removeList.add(list.get(i-1));
    			   i+=2;
    		   }
    		  list.removeAll(removeList);
    		  removeList.clear();
    		   
    	   }
    	   System.out.println(list.get(0));
       }
	}

}
