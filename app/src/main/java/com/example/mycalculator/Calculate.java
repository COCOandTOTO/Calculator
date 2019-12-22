package com.example.mycalculator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Calculate {
    private String expr;

    /* public static void main(String[] args){
        //String str="1+((2+3)×4)-5";
        String str="0.67+(4.33%-5.9×88.88)÷99.99";
        Calculate cal=new Calculate(str);
        String[] resStr=cal.splitString();
        List<String> resList=cal.PostfixEvaluator(resStr);
        for(int i=0;i<cal.splitString().length;i++) {
            System.out.println(cal.splitString()[i]);
        }
        System.out.println("喵喵");
        for(int i=0;i<cal.PostfixEvaluator(cal.splitString()).size();i++){
            System.out.println(cal.PostfixEvaluator(cal.splitString()).get(i));
        }
        double result=0;
        result=calculate(resList);
        System.out.println("结果为"+result);
    } */

    public Calculate(){
    }

    public Calculate(String expr){
        this.expr=expr;
    }

    public void setExpr(String expr) {
        this.expr = expr;
    }

    public String getExpr(){
        return expr;
    }

    public String[] splitString(){
        String split_expr="";
        for(int i=0;i<this.expr.length();i++){
            if((this.expr.charAt(i)>='0' && this.expr.charAt(i)<='9')|| this.expr.charAt(i)=='.' ){
                split_expr=split_expr+this.expr.charAt(i);
            }
            else if((this.expr.charAt(i)=='+')||(this.expr.charAt(i)=='-')||(this.expr.charAt(i)=='×')||(this.expr.charAt(i)=='÷')||(this.expr.charAt(i)=='%')||(this.expr.charAt(i)=='(')||(this.expr.charAt(i)==')')){
                split_expr=split_expr+'#'+this.expr.charAt(i)+'#';
            }
        }
        String[] split_str=split_expr.split("#");
        return split_str;
    }

   /* public List<String> PostfixEvaluator(String[] split_str){
        Stack<String> opStack=new Stack<>();
        List<String> suffixList=new ArrayList<>();
        for(int i=0;i<split_str.length;i++){
            if((split_str[i]==null)||(split_str[i].equals(""))){
                continue;
            }
            else if(isOperator(split_str[i])==false){
                suffixList.add(split_str[i]);
            }
            else if(isOperator(split_str[i])==true){
                 if(split_str[i].equals("(")){
                    opStack.push(split_str[i]);
                }
                else if(split_str[i].equals("%")||split_str[i].equals("+")||split_str[i].equals("-")||split_str[i].equals("×")||split_str[i].equals("÷")){
                    if(opStack.isEmpty()==true||Compare(opStack.peek(),split_str[i])==-1||opStack.peek().equals("(")){
                        opStack.add(split_str[i]);
                    }
                    else if(opStack.isEmpty()==false && Compare(opStack.peek(),split_str[i])>=0){
                        while(opStack.isEmpty()==false && opStack.peek().equals("(")==false){
                            if(Compare(opStack.peek(),split_str[i])>=0){
                                suffixList.add(opStack.pop());
                            }
                        }
                    }
                }
                else if(split_str[i].equals(")")){
                    while(opStack.peek().equals("(")==false){
                        suffixList.add(opStack.pop());
                    }
                }
            }
        }
        while(opStack.isEmpty()==false) {
        	suffixList.add(opStack.pop());
        }
        for(int i=0;i<suffixList.size();i++) {
        	if(suffixList.get(i).equals("(")) {
        		suffixList.remove(i);
        	}
        }
        return suffixList;
    } */

    public List<String> PostfixEvaluator(String[] split_str){
        Stack<String> opStack=new Stack<>();
        List<String> suffixList=new ArrayList<>();
        for(int i=0;i<split_str.length;i++) {
            if(split_str[i].equals("")) {
                continue;
            }
            else if(isNumeric(split_str[i])) {
                suffixList.add(split_str[i]);
            }
            else if(split_str[i].equals("(")) {
                opStack.push(split_str[i]);
            }
            else if(isOperator(split_str[i])) {
                if(opStack.isEmpty() || opStack.peek().equals("(") || Compare(split_str[i],opStack.peek())>0) {
                    opStack.push(split_str[i]);
                }
                else {
                    while(!opStack.isEmpty() && !opStack.peek().equals("(")) {
                        if(Compare(split_str[i],opStack.peek())<=0) {
                            suffixList.add(opStack.pop());
                        }
                    }
                    opStack.push(split_str[i]);
                }
            }
            else if(split_str[i].equals(")")) {
                while(!opStack.isEmpty()) {
                    if(opStack.peek().equals("(")) {
                        opStack.pop();
                        break;
                    }
                    else {
                        suffixList.add(opStack.pop());
                    }
                }
            }
        }
        while(!opStack.isEmpty()) {
            suffixList.add(opStack.pop());
        }
        return suffixList;
    }

    public static double calculate(List<String> list) {
        Stack<Double> stack=new Stack<>();
        for(int i=0;i<list.size();i++) {
            String item=list.get(i);
            if(isNumeric(item)) {
                stack.push(Double.parseDouble(item));
            }
            else if(isOperator(item)) {
                if(item.equals("%")) {
                    stack.push(stack.pop()*0.01);
                }
                else {
                    double num1=stack.pop();
                    double num2=stack.pop();
                    double result=0;
                    if(item.equals("+")) {
                        result=num2+num1;
                    }
                    else if(item.equals("-")) {
                        result=num2-num1;
                    }
                    else if(item.equals("×")) {
                        result=num2*num1;
                    }
                    else if(item.equals("÷")) {
                        result=num2/num1;
                    }
                    stack.push(result);
                }
            }
        }
        return stack.pop();
    }

    public static boolean isNumeric(String str) {
        boolean result=false;
        Pattern pattern=Pattern.compile("[0-9]*\\.?[0-9]+");
        Matcher isNum=pattern.matcher(str);
        if(!isNum.matches()) {
            result=false;
        }
        else {
            result=true;
        }
        return result;
    }

    public static boolean isOperator(String operator){
        boolean result=false;
        if(operator.equals("+")||operator.equals("-")||operator.equals("×")||operator.equals("÷")||operator.equals("%")){
            result=true;
        }
        else{
            result=false;
        }
        return result;
    }

    public int Compare(String operator0,String operator1){
        int result=0;
        Map<String,Integer> map=new HashMap<String,Integer>();
        map.put("+",0);
        map.put("-",0);
        map.put("×",1);
        map.put("÷",1);
        map.put("%",2);
        if(map.get(operator0)<map.get(operator1)){
            result=-1;
        }
        else if(map.get(operator0)==map.get(operator1)){
            result=0;
        }
        else if(map.get(operator0)>map.get(operator1)){
            result=1;
        }
        return result;
    }
}

