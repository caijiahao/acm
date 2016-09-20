package meitu.first;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author stevenfen
 * 请设计一个算法，给一个字符串进行二进制编码，使得编码后字符串的长度最短。
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner in = new Scanner(System.in);
       while(in.hasNext()){
    	   char[] ch = in.next().toCharArray();
    	   Arrays.sort(ch);
    	   int index=0;
    	   int[][] num = new int[ch.length*2][2];
    	   
    	   //统计各个字母出现的个数
    	   for(int i=0;i<ch.length;){
    		   for(int j=i+1;j<=ch.length;j++){
    			   if(j==ch.length||ch[j]!=ch[i]){
    				   num[index++][0]=j-i;
    				   i=j;
    				  // System.out.println(index);
    				   break;
    			   }
    		   }  
    	   }
    	  // System.out.println(index);
    	   int line = index;
    	   while(true){
    		   int max1 = Integer.MAX_VALUE;
    		   int maxi = -1;
    		   int max2 = Integer.MAX_VALUE;
    		   int maxj = -1;
    		   //寻找第一小的数
    		   for(int i=0;i<line;i++){
    			   if(num[i][1]==0&&max1>num[i][0]){
    				   maxi=i;
    				   max1 = num[i][0];
    			   }
    		   }
    		   
    		   //寻找第二小的数
    		   for(int i=0;i<line;i++){
    			   if(maxi!=i&&num[i][1]==0&&max2>num[i][0]){
    				   maxj = i;
    				   max2 = num[i][0];
    			   }
    		   }
    		   
    		   //如果不能两两组合的话
    		   if(maxj==-1){
    			   break;
    		   }
    		   
    		   //两个最小的数组合成一个新的元素
    		   num[line++][0] = max1+max2;
    		   //System.out.println(max1+":"+max2);
    		   num[maxi][1]=line-1;
    		   num[maxj][1]=line-1;
    	   }
    	   
    	   //计算每个字母的长度和频率的积
    	   int max =0;
    	   for(int i=0;i<index;i++){
    		   int j = num[i][1];
    		   int a =1;
    		   while(num[j][1]!=0){
    			   a++;
    			   j = num[j][1];
    		   }
    		   max+=a*num[i][0];
    	   }
    	   System.out.println(max);
       }
	}

}
