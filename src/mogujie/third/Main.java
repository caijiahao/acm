package mogujie.third;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

class Main {
int p,q,l,r;
int[][] A,B;
int count;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Main main = new Main();
        main.run();
	}
public void run(){
	Scanner in = new Scanner(System.in);
	while(in.hasNext())
	{
		count = 0;
		String[] pqlr = in.nextLine().split(" ");
		p = Integer.valueOf(pqlr[0]);
		q = Integer.valueOf(pqlr[1]);
		l = Integer.valueOf(pqlr[2]);
		r = Integer.valueOf(pqlr[3]);

		if(!Judgepq(p, q)&&!Judgelr(l, r)){
			continue;
		}
		A = new int[p][2];
		B = new int[q][2];
		for(int i =0;i<p;i++){
			String[] row = in.nextLine().split(" ");
			A[i][0] = Integer.valueOf(row[0]);
			A[i][1] = Integer.valueOf(row[1]);
		}
		
		for(int i =0;i<q;i++){
			String[] row = in.nextLine().split(" ");
			B[i][0] = Integer.valueOf(row[0]);
			B[i][1] = Integer.valueOf(row[1]);
		}
		
		for(int t =l;t<=r;t++){
			if(isWake(t)){
				count++;
			}
		}
		System.out.println(count);
	}
}

public boolean isWake(int t){
	for(int i =0;i<A.length;i++){
		for(int j =0;j<B.length;j++){
			if(A[i][1]>=(B[j][0]+t)&&B[j][1]+t>=A[i][0]){
				return true;
			}
		}
	}
	return false;
}

public boolean Judgepq(int p,int q){
	if(p>=1 && p<=50 && q>=1 && q<=50){
		return true;
	}
	return false;
}

public boolean Judgelr(int l,int r){
	if(l>=0 && l<=1000 && r>=0 && r<=1000){
		return true;
	}
	return false;
}
}
