package 贪心算法.zkc学长的福利;

import java.util.*;

/**
 * Created by lenovo on 2016/12/3.
 */
public class Main {
    public static void main(String[] args){
      int n,m,left,rigth;

        Scanner in  = new Scanner(System.in);
        String[] str = null;
        while(in.hasNext()){
            List<Info> infos = new ArrayList<Info>();
            int[] f = new int[1010];
            int[] fs = new int[1010];
            n= Integer.parseInt(in.nextLine());
            str = in.nextLine().split(" ");
            //输入师兄的数据
            left = Integer.parseInt(str[0]);
            rigth = Integer.parseInt(str[1]);

            //加载n个朋友左手和右手的数字
            for(int i=0;i<n;i++){
                str = in.nextLine().split(" ");
                infos.add(new Info( Integer.parseInt(str[0]),Integer.parseInt(str[1])));
            }

            //排序
            MyComparator mc = new MyComparator();
            Collections.sort(infos,mc);

            long s = 0,t = left;
            int si = 0;
            for(int i =0;i<n;i++){
                if(t/infos.get(i).r>s){
                    s = t/infos.get(i).r;
                    m = 0;
                    for(int j = 999; j >= 0; j--)
                    {
                        m = m*10000 + f[j];
                        fs[j] = m / infos.get(i).r;
                        m = m % infos.get(i).r;
                    }
                    si = i;
                }
                t =t * infos.get(i).l;
                m = 0;
                for(int j = 0; j <= 999; j++)
                {
                    m = m + f[j]*infos.get(i).l;
                    f[j] = m % 10000;
                    m = m / 10000;
                }
            }
           m = 0;
            /*for(int j = 999;j>=0;j--){
                if(m == 1){
                    if(fs[j] < 10){
                        System.out.print("000");
                    }else if(fs[j] < 100){
                        System.out.print("00");
                    }else if(fs[j] < 1000){
                        System.out.print("0");
                    }
                    System.out.println(fs[j]);
                }
                else if(fs[j] > 0){
                    m =1;
                    System.out.println(fs[j]);
                }
            }*/
            System.out.println(s);
        }
    }
    //比较函数
    public static boolean cmp(Info a ,Info b){
        return a.l*a.r < b.l*b.r;
    }
}
class Info{
    public int l;
    public int r;

    public Info(int l, int r) {
        this.l = l;
        this.r = r;
    }
}
class MyComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Info a = (Info) o1;
        Info b = (Info) o2;
        if(a.l*a.r < b.l*b.r){
            return 1;
        }
        return 0;
    }
}
