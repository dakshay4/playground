package org.r7d.misc;

import java.util.Stack;

public class ValidParenthesesString {

    public static void main(String[] args) {
        String[] sample = new String[]{"(******)))"};
        for (String s : sample) {
            System.out.println(s + " is " + checkValidString(s));
        }
    }

    public static boolean checkValidString(String s) {
        Stack<Character> stack= new Stack<>();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(!stack.isEmpty()){
                if(stack.peek() == '*' && c== ')') stack.pop();
                else if(stack.peek() == '(' && c == ')') stack.pop();
                else if(stack.peek() =='*' && c=='*') continue;
                else stack.push(c);
            }
            else if(c==')') return false;
            else stack.push(c);
        }
        if(stack.isEmpty() || (stack.size()==2 && stack.peek()=='*')) return true;
        return false;

    }

    public static boolean checkValidString_2(String s) {
        Stack<Character> stack= new Stack<>();
        int asterickCount=0;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c=='(') stack.push(c);
            if(c=='*') asterickCount++;
            if(!stack.isEmpty() && c==')') stack.pop();
            if(stack.isEmpty() && c==')' && asterickCount>0) asterickCount--;

        }
        if(stack.isEmpty() || (stack.size()==2 && stack.peek()=='*')) return true;
        return false;

    }
}



/*k
()
(******)))
(*)()))
(*(())))
(()***()(()) =>
*())

*/