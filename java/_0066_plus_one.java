// https://leetcode.com/problems/plus-one/description

import java.util.ArrayList;

public class _0066_plus_one {

    public static void main(String[] args) {

        ArrayList<Integer> digits = new ArrayList<Integer>() { 
            { add(6); add(1); add(4);  add(5); add(3); add(9); add(0); 
              add(1); add(9); add(5); add(1); add(8); add(6); add(7); add(0);
              add(5); add(5); add(4); add(3); } 
        };
    
        ArrayList<Integer> solution = plus_one_1(digits);
        System.out.println(solution);
    
        solution = plus_one_2(digits);
        System.out.println(solution);
    }

    
    /* Solution 1. 
     * Transform the array of digits in a string format of the number.
     * Transform the string number back to long long and add 1.
     * Transform the long long to string again.
     * Clear the array of digits and fill it with the string number char by char.
     * 
     * Instead of using string number inside the for loop, you can just multiply
     * by powers of 10.
     */
    public static ArrayList<Integer> plus_one_1(ArrayList<Integer> digits) {
        
        String number = "";
        long num = 0;
        for(int i=0; i<digits.size(); ++i) {

            number += String.valueOf(digits.get(i));
        }

        num = Integer.valueOf(number) + 1;
        number = String.valueOf(num);

        digits.clear();
        for(int i=0; i<number.length(); ++i) {
            digits.add(number.charAt(i) - '0');
        }
        
        return digits; 
    }


    /* Solution 2.
     * Check if the current digit + 1 == 10. If so, then set current digit
     * to 0, then go to the next digit. If the current digit + 1 != 10,
     * it means it doesn't need to carry the 1(ten).
     * Do this for every digit. Once the loop is finished, just check
     * if the first digit(from left) is 10. If so, set it to 1 and
     * insert a 0 at the end of the array.
     */
    public static ArrayList<Integer> plus_one_2(ArrayList<Integer> digits) {

        for(int i=digits.size()-1; i >= 0; --i) {
            digits.set(i, digits.get(i) + 1);
            if(digits.get(i) == 10 && i != 0) {
                digits.set(i,0);
            }
            else {
                break;
            }
        }

        if(digits.get(0) == 10) {
            digits.set(0,1);
            digits.add(0);
        }
            
        return digits;
    }

}
