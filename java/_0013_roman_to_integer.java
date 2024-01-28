// https://leetcode.com/problems/roman-to-integer/description/

public class _0013_roman_to_integer {

    public static void main(String[] args) {

        String roman = "MCMXCIV";
    
        int solution = roman_to_int(roman);
        System.out.println(solution);
    }


    public static int roman_to_int(String s) {

        int number = 0;
    
        for(int i=0; i<s.length(); ++i) {
            switch(s.charAt(i)) {
                
                case 'I': {
                    if(s.charAt(i+1) == 'V') { number += 4; i++; }
                    else if(s.charAt(i+1) == 'X') { number += 9; i++; }
                    else { number += 1; }
                    break;
                }
                case 'X': {
                    if(s.charAt(i+1) == 'L') { number += 40; i++; }
                    else if(s.charAt(i+1) == 'C') { number += 90; i++; }
                    else { number += 10; }
                    break;
                }
                case 'C': {
                    if(s.charAt(i+1) == 'D') { number += 400; i++; }
                    else if(s.charAt(i+1) == 'M') { number += 900; i++; }
                    else { number += 100; }
                    break;
                }
                case 'V': { number += 5; break; }
                case 'L': { number += 50; break; }
                case 'D': { number += 500; break; }
                case 'M': { number += 1000; break; }
            }
        }

        return number;
    }

}
