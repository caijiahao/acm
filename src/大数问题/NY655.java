package 大数问题;

import java.util.Scanner;

/**
 * Created by stevenfenCai on 2017/8/10.
 */
public class NY655 {
    public static void main(String[] args){
        int n,l;
        int[][] f = new int[200][200];
        int i,j,k;

        //初始化
        for(int t=0;t<200;t++){
            for(int tt = 0;tt<200;tt++){
                f[t][tt] = '0';
            }
        }
        Scanner cin = new Scanner(System.in);
        n = Integer.parseInt(cin.nextLine());
        while(n-->0){
           l = cin.nextLine().length();
            f[0][199]=1;
            f[1][199]=2;
            int p=1;
            for(j=2;j<l;j++){
                int c =0;
                for(i=199;i>=200-p;i--){
                    k = f[j-1][i] + f[j-2][i] +c;
                    f[j][i]=k%10;
                    c=k/10;
                    if(i+p<=200&&c==1){
                        f[j][i-1]=c;
                        p++;
                    }
                }
            }
            for(i=200-p;i<200;i++){
                System.out.println(f[l-1][i]);
            }

        }

    }
}
