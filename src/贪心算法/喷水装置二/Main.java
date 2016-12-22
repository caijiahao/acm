package 贪心算法.喷水装置二;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by lenovo on 2016/12/22.
 */
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] str ;
        while(in.hasNext()){
            int N = Integer.parseInt(in.nextLine());
            while(N-->0){
                int n,w,h;
                List<Node> nodeList = new ArrayList<Node>();
                str = in.nextLine().split(" ");
                n = Integer.parseInt(str[0]);
                w = Integer.parseInt(str[1]);
                h = Integer.parseInt(str[2]);

                for(int i=0;i<n;i++){
                    int x,r;
                    str = in.nextLine().split(" ");
                    x= Integer.parseInt(str[0]);
                    r = Integer.parseInt(str[1]);

                    //直径小于草坪宽度的直接丢弃
                    if(r<=h/2.0){
                        i--;
                        n--;
                        continue;
                    }
                    //计算左交点
                    Node node = new Node();
                    node.setS(x-Math.sqrt(r*r-h*h/4.0));
                    node.setE(2.0*x - node.getS());
                    if(node.getS()>=w||node.getE()<=0){
                        i--;
                        n--;
                        continue;
                    }else{
                        nodeList.add(node);
                    }
                }

                Collections.sort(nodeList);
                double maxe=0;
                double last=0;
                int sum=0;
                int ok=0;
                //标记此次遍历或搜索是否找到满足条件的喷水装置，如果没找到，则直接结束搜索输出0
                    maxe=0;
                    ok = 0;
                    for(Node node : nodeList){
                        if(node.getS()<=last){
                            if(node.getE()>last){
                                if(ok==0){
                                    sum++;
                                }
                                ok = 1;
                                if(node.getE()>maxe){
                                    maxe = node.getE();
                                }
                            }
                            else if(ok == 1){
                                last = maxe;
                                break;
                            }
                        }
                        if(ok == 1){
                            last = maxe;
                        }else{
                            break;
                        }
                        //喷水器的数量已经足够了
                        if(last>=w){
                            break;
                        }
                    }
                    if(ok == 1){
                        System.out.println(sum);
                    }else{
                        System.out.println(0);
                    }
                }
            }
        }
    }
class Node implements Comparable<Node>{
    private Double s;
    private Double e;

    public Node() {
    }

    public Node(Double s, Double e) {
        this.s = s;
        this.e = e;
    }

    public Double getS() {
        return s;
    }

    public void setS(Double s) {
        this.s = s;
    }

    public Double getE() {
        return e;
    }

    public void setE(Double e) {
        this.e = e;
    }

    @Override
    public int compareTo(Node o) {
        return this.s>o.s?1:-1;
    }
}
