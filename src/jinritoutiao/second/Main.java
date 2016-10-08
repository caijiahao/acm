package jinritoutiao.second;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while(in.hasNext()){
        	Long n = in.nextLong();
        	int m = in.nextInt()-1;
        	for(Long i= 1L;i<=n;i++){
        		list.add(i+"");
        	}
            list.sort(null);
        	System.out.println(list.get(m));
        	list.clear();
        }
	}

}
