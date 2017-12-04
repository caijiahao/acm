package lanqiaobei;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by stevenfenCai on 2017/11/6.
 */
public class ALGO156 {
    public static final String LEFT_BRACKET = "(";
    public static final String RIGHT_BRACKET = ")";

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
    }

    /**
     * 中缀表达式转换为后缀表达式
     * @param infix 中缀表达式
     * @return 返回后缀表达式
     */
    public List<String> infix2Postfix(List<String> infix){
        List<String> postfix = new Stack<>();

        Stack<String> stack = new Stack<>();
        int len = infix.size();
        String temp;

        for(int i=0;i<len;i++){
            temp = infix.get(i);

            if(temp.equals(" "))
                continue;

            if(temp.equals(LEFT_BRACKET)){
                stack.push(temp);
            }else if(temp.equals(RIGHT_BRACKET)){
                while(!stack.peek().equals(LEFT_BRACKET)){
                    postfix.add(temp);
                }
               stack.pop();
            }else{
                if (!isOperator(temp)) {   //若为操作数
                    postfix.add(temp);
                }else{
                    // 从栈中弹出所有优先级比当前运算符高的运算符, 并放进队列中
                    while(!stack.isEmpty() && compareOperatorPriority(stack.peek(),temp)>=0){
                        postfix.add(stack.pop());
                    }
                    stack.push(temp);   // 操作符进栈
                }
            }
        }

       //把栈中的所有元素弹出, 放进队列中
        while(!stack.isEmpty()) {
          postfix.add(stack.pop());
        }

       return postfix;
    }

    /**
     * 判断是否为操作数
     * @param temp
     * @return
     */
    public boolean isOperator(String temp ){
        if(temp.equals("+") || temp.equals("-") || temp.equals("*") || temp.equals("/")){
            return false;
        }
        return true;
    }

    /**
     * 判断符号优先级
     * @param one
     * @param two
     * @return
     */
    public int compareOperatorPriority(String one,String two){
        if((one.equals("*") || one.equals("/"))&&(two.equals("+")||two.equals("-"))){
            return 1;
        }
        return -1;
    }


	 /**
           * 由后缀表达式计算表达式的结果
           * @param postfix 后缀表达式
           * @return 返回表达式的结果
           */

	 public double calculate(List<String> postfix){
         Stack<Double> stack = new Stack<>();
         int len = postfix.size();
         String temp;

         for(int i = 0;i<len;i++){
             temp = postfix.get(i);
             if(!isOperator(temp)){
                 stack.push(Double.parseDouble(temp));
             }else{
                 double val = 0;
                 double num1 = stack.pop();
                 double num2 = stack.pop();
                 switch (temp){
                     case "+":
                         val = num2+num1;
                         break;
                     case "-":
                         val = num2-num1;
                         break;
                     case "*":
                         val = num2*num1;
                         break;
                     case "/":
                         val = num2/num1;

                     default:
                         break;
                 }
                 stack.push(val);
             }
         }
         return stack.pop();
     }


}
