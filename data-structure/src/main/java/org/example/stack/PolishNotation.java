package org.example.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


public class PolishNotation {
    public static void main(String[] args) {
        String  expression="1+((20+3)*4)-5";
//        String  expression="3+4*5-6";
        List list= toList(expression);
        System.out.println(list);
        List toPolishNotation = toPolishNotation(list);
        System.out.println(toPolishNotation);
       int res= calc(toPolishNotation);
        System.out.println(res);

    }

    private static int calc(List<String> polishNotations) {
        Stack<Integer> res=new Stack<>();
        for (String polishNotation : polishNotations) {
            if(polishNotation.matches("\\d+")){
                res.push(Integer.parseInt(polishNotation));
                continue;
            }
            Integer num1 = res.pop();
            Integer num2 =res.pop();
            switch (polishNotation){
                case "+":res.push(num1 + num2);break;
                case "*":res.push(num1 * num2);break;
                case "-":res.push(num2 - num1);break;
                case "/":res.push(num2 / num1);break;
            }

        }

        return res.pop();

    }

    private static List<String> toPolishNotation(List<String> list) {
        Stack<String> stack=new Stack<>();
        int size = list.size();
        List<String> res = new ArrayList<>(size);
        for (String item : list) {
            if(item.matches("\\d+")){
                res.add(item);
                continue;
            }
            if(item.equals("(")){
                stack.push(item);
                continue;
            }
            if(item.equals(")")){
                while (!stack.peek().equals("(")){
                   res.add(stack.pop());
                }
                stack.pop();

                continue;
            }
            while (!stack.isEmpty()&&
                    ProorityCompare.getPriority(item)
                            <=ProorityCompare.getPriority( stack.peek())){
                res.add(stack.pop());
            }
            stack.push(item);
        }

        while (! stack.isEmpty()){
            res.add(stack.pop());
        }
return res;
    }

    private static List toList(String expression) {
        int index=0;
        int length = expression.length();
        List<String> list=new ArrayList<>(length);
        String numberStr="";
        while (index< length){
            char c = expression.charAt(index);
            if(c<48||c>57){
                list.add(c+"");
                index++;
                continue;
            }
            numberStr=(c-48)+"";
            //如果后一位是数字继续拼接
            while (index+1<length){
                char suf= expression.charAt(index+1);
                if(suf>=48&&suf<=57){
                    numberStr=numberStr.concat((suf-48)+"");
                    index++;
                }else {
                    break;
                }
            }
            list.add(numberStr);
            index++;
        }
        return list;

    }
}

class ProorityCompare{
    static int ADD=0;
   static   int SUB=0;
   static   int MUI=2;
   static   int DEV=1;

    public  static int getPriority(String oper){
        switch (oper){
            case "+" :return ADD;
            case "-" :return SUB;
            case "*" :return MUI;
            case "/" :return DEV;
            default:return  -1;
        }
    }

}