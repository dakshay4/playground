package org.r7d.misc;

public class ValidPalindrome {

    public static void main(String[] args) {

        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
    public static boolean isPalindrome(String s) {
        int left=0;
        int right=s.length()-1;
        while(left<=right) {
            int leftAscii = s.charAt(left);
            int rightAscii = s.charAt(right);
            boolean toContinue = true;
            if(!(leftAscii >=65 && leftAscii<=90 || leftAscii >=97 && leftAscii<=122
                    || leftAscii >=48 && leftAscii<=57)) {
                left++;
                toContinue = false;
            }
            if(!(rightAscii >=65 && rightAscii<=90 || rightAscii >=97 && rightAscii<=122
            || rightAscii >=48 && rightAscii<=57)) {
                right--;
                toContinue=false;
            }
            if(toContinue){
                if(Character.toUpperCase(s.charAt(left))==Character.toUpperCase(s.charAt(right))) {left++; right--;}
                else return false;
            }

        }
        return true;

    }
}
