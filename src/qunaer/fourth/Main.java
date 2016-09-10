package qunaer.fourth;

/*
 * 血型遗传对照表如下：
父母血型	子女会出现的血型	子女不会出现的血型
O与O	O	A,B,AB
A与O	A,O	B,AB
A与A	A,O	B,AB
A与B	A,B,AB,O	——
A与AB	A,B,AB	O
B与O	B,O	A,AB
B与B	B,O	A,AB
B与AB	A,B,AB	O
AB与O	A,B	O,AB
AB与AB	A,B,AB	O
请实现一个程序，输入父母血型，判断孩子可能的血型。
给定两个字符串father和mother，代表父母的血型,请返回一个字符串数组，代表孩子的可能血型(按照字典序排列)。
测试样例：
”A”,”A”
返回：[”A”,“O”]
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String[] newStr = chkBlood("O","A");
       String str ="";
       for(int i=0;i<newStr.length;i++){
    	   if(i!=newStr.length-1){
    		   str+="\""+newStr[i]+"\""+",";
    	   }else{
    		   str+="\""+newStr[i]+"\"";
    	   }
       }
       System.out.println("["+str+"]");
	}
	
	public static String[] chkBlood(String father, String mother) {
		String str = "";
		if(father.equals("O")&&mother.equals("O")){
			str = "O";
		}else if(father.equals("A")&&mother.equals("O")||father.equals("O")&&mother.equals("A")){
			str="A,O";
		}else if(father.equals("A")&&mother.equals("A")){
			str="A,O";
		}else if(father.equals("A")&&mother.equals("B")||father.equals("B")&&mother.equals("A")){
			str="A,AB,B,O";
		}else if(father.equals("A")&&mother.equals("AB")||father.equals("AB")&&mother.equals("A")){
			str="A,AB,B";
		}else if(father.equals("B")&&mother.equals("O")||father.equals("O")&&mother.equals("B")){
			str="B,O";
		}else if(father.equals("B")&&mother.equals("B")){
			str="B,O";
		}else if(father.equals("B")&&mother.equals("AB")||father.equals("AB")&&mother.equals("B")){
			str="A,AB,B";
		}else if(father.equals("AB")&&mother.equals("O")||father.equals("O")&&mother.equals("AB")){
			str="A,B";
		}else if(father.equals("AB")&&mother.equals("AB")){
			str="A,AB,B";
		}
		String[] newStr = str.split(",");
		return newStr;
        // write code here
    }

}
