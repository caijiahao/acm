package 贪心算法.冰法斗神龙;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by stevenfen on 2016/12/18.
 * 思路：思路还是很清晰地， 一个经典贪心。
 首先，cd-冰冻时间是技能的实际cd时间。
 所以，当实际cd==0 时， 如果该技能攻击大于0  直接YES。
 当实际cd<0时，如果存在任意一个技能攻击大于0，YES。
 技能储存，攻击相等时，实际cd最短的。
 然后根据  技能攻击/实际cd 排序。
 每次取最优技能，看最后能否杀死。
 */
public class Main {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());

        String[] str ;
        int da,fr,cd;
        int a[] = new int[110];

        while(t-->0){
            int bshp,bsda,zzhp,k,cur=0,cur1=0;
            List<SD> sds = new ArrayList<SD>();
            str = in.nextLine().split(" ");
            bshp = Integer.parseInt(str[0]);
            bsda = Integer.parseInt(str[1]);
            str = in.nextLine().split(" ");
            zzhp = Integer.parseInt(str[0]);
            k = Integer.parseInt(str[1]);

            for(int i=0;i<110;i++){
                a[i] = Integer.MAX_VALUE;
            }
            for(int i=0;i<k;i++) {
                str = in.nextLine().split(" ");
                da = Integer.parseInt(str[0]);
                fr = Integer.parseInt(str[1]);
                cd = Integer.parseInt(str[2]);

                if (da > 0) {
                    cur1 = 0;
                }

                a[da] = a[da] < (cd - fr) * bsda ? a[da] : (cd - fr) * bsda;

                if (fr >= cd && cur != 1) {
                    if (da > 0) {
                        cur = 1;
                    } else if (fr > cd) {
                        cur = -1;
                    }
                }
            }
                if(cur==1||cur==-1&&cur1>0){
                    System.out.println("YES");
                    continue;
                }

                for(int i=0;i<100;i++){
                   if(a[i]!=Integer.MAX_VALUE){
                       SD sd = new SD(a[i],i);
                       sds.add(sd);
                   }
                }

            Collections.sort(sds);
            cur = 0;

            //攻击冰龙
            while(bshp>0){
                int i;
               for(i=0;i<sds.size();i++){
                   SD sd = sds.get(i);
                   //刚好击杀了冰龙
                   if(sd.getZg()>=bshp){
                       bshp = 0;break;
                   }
                   //攻击冰龙后自己不会死
                   if(sd.getBg()<zzhp){
                       zzhp-=sd.getBg();
                       bshp-=sd.getZg();
                       break;
                   }
               }
               //所有可用技能已经用完不可能杀死冰龙
               if(i == sds.size()){
                   cur = 1;
                   break;
               }
            }

            if(cur>0){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }
        }
    }
}
class SD implements Comparable<SD>{
    private int bg;
    private int zg;

    public int getBg() {
        return bg;
    }

    public void setBg(int bg) {
        this.bg = bg;
    }

    public int getZg() {
        return zg;
    }

    public void setZg(int zg) {
        this.zg = zg;
    }

    @Override
    public int compareTo(SD o) {
        if(this.zg*o.getBg()<this.bg*o.getZg())
          return 1;
        else
            return -1;
    }

    public SD(int bg, int zg) {
        this.bg = bg;
        this.zg = zg;
    }
}
