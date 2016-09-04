package baidu.third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String s="";
      while((s=br.readLine())!=null){
    	  String[] strs = s.trim().split(" ");
    	  int n = Integer.parseInt(strs[0]);
    	  int m = Integer.parseInt(strs[1]);
    	  int x = Integer.parseInt(strs[2]);
    	  int y = Integer.parseInt(strs[3]);
    	  int t = Integer.parseInt(strs[4]);
    	  double[][] matrix = new double[n][m];
    	  
    	  double sum = 0;
    	  for(int i=0;i<n;i++){
    		  s = br.readLine();
    		  strs = s.trim().split(" ");
    		  for(int j=0;j<m;j++){
    			  matrix[i][j] = Double.parseDouble(strs[j]);
    			  sum+=matrix[i][j];
    		  }
    	  }
    	  double cc = 1-Math.pow((1-matrix[x-1][y-1]), t);
    	  double ss = 1-Math.pow((1-sum/(n*m)), t);
    	  if(cc>ss){
    		  System.out.println("cc");
              System.out.printf("%.2f\n", cc); 
    	  }else if(cc<ss){
    		  System.out.println("ss");
              System.out.printf("%.2f\n", ss);
    	  }else{
    		  System.out.println("equal");
              System.out.printf("%.2f\n", ss);
    	  }
      }
      br.close();
	}

}
