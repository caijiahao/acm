package chuchujie.first;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author stevenfen
 * 亮亮深吸一口气，小心地将盒子打开，里面是一张地图，地图上除了一些奇怪的字母以外没有任何路线信息，这可让亮亮犯了愁，这些字母代表了什么意思呢？ 亮亮绞尽脑汁也想不出什么思路，突然，亮亮眼前一亮，“我可以把这些字母所有的排列方式全部写出来，一定可以找到答案！” 于是，亮亮兴奋的开始寻找字母里的秘密。

输入描述:
每组数据输入只有一行，是一个由不同的大写字母组成的字符串，已知字符串的长度在1到9之间，我们假设对于大写字母有'A' < 'B' < ... < 'Y' < 'Z'。


输出描述:
输出这个字符串的所有排列方式，每行一个排列，要求字母序比较小的排列在前面。

输入例子:
WHL

输出例子:
HLW

HWL

LHW

LWH

WHL

WLH
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner in = new Scanner(System.in);
       while(in.hasNext()){
    	   String[] result = QuanPaiLie(in.nextLine());
    	   Arrays.sort(result);
    	   for(int i=0;i<result.length;i++){
    		   System.out.println(result[i]);
    	   }
       }
	}
    
	public static String[] QuanPaiLie(String key){
		//如果字符串是空字符串“”，或者是空对象
		if(key==null||key.isEmpty()){
			return null;
		}
		int length = key.length();
		//计算全排列的字符串的个数
		int num = length;
		int sum = 1;
		while(num!=0){
			sum*=num;
			num--;
		}
		String[] result = new String[sum];
		if(length==1){
			result[0] = key;
		}else if(length == 2){
			result[0] = key;
			result[1] = ""+key.charAt(1)+key.charAt(0);
		}else{
			char end= key.charAt(length-1);
			String prefixString = key.substring(0,length-1);
			String[] prefixStrResult = QuanPaiLie(prefixString);//递归
			int prefixStringNum = prefixString.length()+1;
			int resultIndex = 0;
			for(int i=0;i<prefixStrResult.length;i++){
				for(int index = 0;index<prefixStringNum;index++){
					result[resultIndex++] = prefixStrResult[i].substring(0, index)+end+prefixStrResult[i].substring(index);
				}
			}
			
		}
		return result;
	}
}
