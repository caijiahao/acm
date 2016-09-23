package meituan.fourth;
/**
 * 
 * @author stevenfen
 * 在股市的交易日中，假设最多可进行两次买卖(即买和卖的次数均小于等于2)，规则是必须一笔成交后进行另一笔(即买-卖-买-卖的顺序进行)。给出一天中的股票变化序列，请写一个程序计算一天可以获得的最大收益。请采用实践复杂度低的方法实现。
给定价格序列prices及它的长度n，请返回最大收益。保证长度小于等于500。
测试样例：
[10,22,5,75,65,80],6
返回：87
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int[] prices = {10,22,5,75,65,80};
      System.out.println(maxProfit(prices,6));
	}
	public static int maxProfit(int[] prices, int n) {
	        // write code here
		int[] dis = new int[n];
		int[] dis1 = new int[n];
		for(int i=1;i<n;i++){
			dis[i] = prices[i]-prices[i-1];
		}
		for(int i = n-2;i>=0;i--){
			dis1[i] = prices[i]-prices[i+1];
		}
		int[] max = getMax(dis,n);
		int[] min = getMin(dis1,n);
		int result = Integer.MIN_VALUE;
		for(int i=0;i<max.length;i++){
			result = Math.max(result, max[i]-min[i]);
		}
	 	return result;
	}
	public  static int[] getMax(int[] dis,int n){
		int[] dp = new int[n];
		int max = Integer.MIN_VALUE;
		int current = 0;
		for(int i=0;i<dis.length;i++){
			current += dis[i];
			current = Math.max(current, dis[i]);
			max = Math.max(max, current);
			dp[i] = max;
		}
		return dp;
	}
	public static int[] getMin(int[] dis,int n){
		int[] dp = new int[n];
		int min = Integer.MAX_VALUE;
		int current = 0;
		for(int i = dis.length-1;i>=0;i--){
			current+=dis[i];
			current = Math.min(current, dis[i]);
			min = Math.min(current, min);
			dp[i] = min;
		}
		return dp;
	}
}
