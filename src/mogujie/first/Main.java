package mogujie.first;

import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner scanner = new Scanner(System.in);
       while(scanner.hasNextLine()){
    	   String[] line = scanner.nextLine().split(" ");
    	   double r,x,y,x1,y1;
    	   double step;
    	   r = Integer.parseInt(line[0]);
    	   x = Integer.parseInt(line[1]);
    	   y = Integer.parseInt(line[2]);
    	   x1 = Integer.parseInt(line[3]);
    	   y1 = Integer.parseInt(line[4]);
    	   step = Math.sqrt((x1-x)*(x1-x)+(y1-y)*(y1-y))/(2*r);
    	   System.out.println(String.format("%.0f", step));
       }
	}

}
