package meitu.third;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author stevenfen
 * 题目描述

有一个二维数组(n*n),写程序实现从右上角到左下角沿主对角线方向打印。
给定一个二位数组arr及题目中的参数n，请返回结果数组。
测试样例：
[[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]],4
返回：[4,3,8,2,7,12,1,6,11,16,5,10,15,9,14,13]
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
         int newArr[]=arrayPrint(arr,4);
         for(int i=0;i<newArr.length;i++){
        	 System.out.println(newArr[i]);
         }
	}
	public static int[] arrayPrint(int[][] arr, int n) {
		List<Integer>list = new ArrayList<>();
		int starti = 0,startj = n-1;
		int count =0;
		
		while(startj>=0){
			count++;
			for(int i=0;i<count;i++){
				list.add(arr[starti+i][startj+i]);
			}
			startj-=1;			
		}
		starti=1;
		startj=0;
		while(starti<=n-1){
			count--;
			for(int i=0;i<count;i++){
				list.add(arr[starti+i][startj+i]);
			}
			starti++;
		}
		int newArr[] = new int[n*n];
		count=0;
		for(int i=0;i<n*n;i++){
				newArr[i]=list.get(count);
				count++;
		}
		return newArr;
	        // write code here
	    }
}
