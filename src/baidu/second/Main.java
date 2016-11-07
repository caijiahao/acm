package baidu.second;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      while(scanner.hasNext()){
    	 int n = scanner.nextInt();
    	 int weight[] = new int[n];int height[] = new int[n];
    	 scanner.nextLine();
    	 for(int i = 0;i<n;i++){
    		 String str[] = scanner.nextLine().split(" ");
    		 weight[i] = Integer.valueOf(str[0]);
    		 height[i] = Integer.valueOf(str[1]); 
    	 }
    	 System.out.println(new Main().getWei(height, weight));
      }
	}
    public int getWei(int height[],int weight[]){
    	int maxheight = height[0];
    	int minheight = height[1];
    	int maxweight = weight[0];
    	int minweight = weight[1];
    	for(int i=0;i<height.length;i++){
    		if(maxheight<height[i]){
    			maxheight = height[i];
    		}
    		if(minheight>height[i]){
    			minheight = height[i];
    		}
    		if(maxweight<weight[i]){
    			maxweight = weight[i];
    		}
    		if(minweight>weight[i]){
    			minweight = weight[i];
    		}
    	}
    	int he = maxheight - minheight;
    	int wi = maxweight - minweight;
    	int area = he>wi?he*he:wi*wi;
    	return area;
    }
}
