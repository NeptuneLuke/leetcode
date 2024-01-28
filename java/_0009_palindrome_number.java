// https://leetcode.com/problems/palindrome-number/description

import java.util.ArrayList;

public class _0009_palindrome_number {

    public static void main(String[] args) {

        boolean solution = is_palindrome_1(121);
        System.out.println(solution);
    
        solution = is_palindrome_2(121);
        System.out.println(solution);
    }


    /* Solution 1. 
     * An array is filled with the reversed number and then every 
     * complementary indexes of the array are checked.
     */
    public static boolean is_palindrome_1(int x) {

        if(x < 0) {
            return false;
        }
    
        ArrayList<Integer> digits = new ArrayList<Integer>();
        int temp = x;
    
        while(x > 0) {
            temp = x % 10;
            digits.add(temp);
            x /= 10;
        }
        
        for(int i=0; i<digits.size(); ++i) {
            if(digits.get(i) != digits.get(digits.size() - i - 1) ) {
                return false;
            }
        }
    
        return true;
    }


    /* Second method. 
     * Uses some simple but non immediate maths transformation.
     */
    public static boolean is_palindrome_2(int x) {
    
        if (x < 0) {
            return false;
        }
    
        long reversed = 0;
        long temp = x;
    
        while(temp != 0) {
            int digit = (int) (temp % 10);
            reversed = reversed * 10 + digit;
            temp /= 10;
        }
    
        return (reversed == x);
    }

}
