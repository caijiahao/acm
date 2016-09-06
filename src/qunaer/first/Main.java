package qunaer.first;

/*题目
 * 从小明家所在公交站出发有n路公交到公司，现给出每路公交的停站数(不包括起点和终点)，及每次停的时间(一路车在每个站停的时间相同)和发车的间隔，先假定每辆车同时在相对时间0分开始发车，且所有车在相邻两个站之间的耗时相同,都为5分钟。给定小明起床的相对时间(相对0的分钟数)，请计算他最早到达公司的相对时间。
给定每路车的停站数stops,停站时间period,发车间隔interval及公交路数n，出发时间s。请返回最早到达时间。保证公交路数小于等于500，停站数小于等于50。
 */
/*解题思路
 * 小明到达公司的时间由三部分组成：起床时间，等车时间，车的行驶时间
起床时间是固定的s。
等车时间取决于起床时间s与发车间隔interval。如果s%interval为0，则等车时间是0；否则等车时间是(interval-s%interval)。
车的行驶时间，包括停车时间与行驶时间，即 (停站数+1)*5分钟+停站数*停车时间。
取等车时间+行驶时间的最小值即可，返回时记得加上起床时间。
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
	}
	public int chooseLine(int[] stops, int[] period, int[] interval, int n, int s) {
        // write code here
        int min  = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
        	int missTime  = s%interval[i];
        	int waitcost = missTime ==0?0:interval[i]-missTime ;
        	 min = Math.min(min, (stops[i]+1)*5+stops[i]*period[i]+waitcost);
        }
        return min+s;
    }

}
