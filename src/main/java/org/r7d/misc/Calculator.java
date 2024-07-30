package org.r7d.misc;

public class Calculator {

    public static void main(String[] args) {
        System.out.println(calculate("1 + 1"));
    }

    public static int calculate(String s) {
        int sum = 0;
        // Stack<Integer> s = new Stack();
        int number = 0;
        int result = 0;
        int sign=1;
        for(int i=0;i< s.length();i++) {
            char c = s.charAt(i);
            if(c=='+' ){
                result+=number*sign;
                sign=1;
                number=0;

            } else if(c=='-'){
                result+=number*sign;
                sign=-1;
                number=0;
            } else if(Character.isDigit(c)) {
                number = 10*number + (int)(c-'0');
            }
        }
        if(number!=0 ) result+=number*sign;
        return result;
    }
}
