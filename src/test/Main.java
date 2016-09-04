package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Record implements Comparable<Record>
{

	public String file;
	public int lineNum;
	public int num;
	public int firstTime;
	Record(String file,int[] arr){
		this.file = file;
		lineNum = arr[0];
		num = arr[1];
		firstTime = arr[2];
	}
	@Override
	public int compareTo(Record arg0) {
		// TODO Auto-generated method stub
		if(this.num < arg0.num)
			return 1;
		else if(num == arg0.num){
			if(this.firstTime == arg0.firstTime)
				return 0;
			else if(this.firstTime<arg0.firstTime)
				return -1;
			else 
				return 1;
		}else {
			return 1;
		}
		
	}
	
	public void fun(){
		if(file.length()>16)
			System.out.print(file.substring(file.length()-16));
		else
			System.out.print(file);
		System.out.print(" "+lineNum);
		System.out.print(" "+num);
	}
	
}
public class Main {


	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		//BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        Scanner scan = new Scanner(System.in);
        int count=0;    //输入行数
        HashMap<String, List<int[]>> hm = new HashMap<>();
        while(scan.hasNextLine()){
            //String line =br.readLine();
            String line=scan.nextLine();
            if(line==null||line.equals("")) break;
            String file=line.substring(0, line.indexOf(" "));
            int index=file.lastIndexOf("\\");
            file=file.substring(index+1, file.length());        //文件名
            int lineNum=Integer.parseInt(line.substring(line.lastIndexOf(" ")+1, line.length()));
            ++count;
            if(!hm.containsKey(file)){
                int[] record=new int[3];
                record[0]=lineNum;      //行号
                record[1]=1;            //出现次数
                record[2]=count;        //第一次出现顺序
                List<int[]> list = new ArrayList<>();
                list.add(record);
                hm.put(file, list);
            }else{     
                //判断行号是否一致
                //是，则加1
                //否，添加新记录
                List<int[]> list=hm.get(file);
                int size=0;
                boolean flag=false;
                while(size<list.size()){
                    int[] arr=list.get(size++);
                    if(arr[0]==lineNum){
                        ++arr[1];
                        flag=true;
                        break;
                    }
                }
                if(!flag){      //说明未找到
                    int[] record=new int[3];
                    record[0]=lineNum;
                    record[1]=1;
                    record[2]=count;        //第一次出现顺序
                    list.add(record);
                }
            }
        }
        //br.close();
        display(hm);
        
	}
	public static void display(HashMap<String, List<int[]>> hm){
        TreeSet<Record> ts = new TreeSet<>();
        Set<String> set=hm.keySet();
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            String file=it.next();
            List<int[]> list = hm.get(file);
            for(int[] arr: list){
                Record r= new Record(file, arr);
                ts.add(r);
            }
        }
        int i=0;
        for(Record r: ts){
            r.fun();
            ++i;
            if(i>=8)
                break;
        }
	}
}
