// https://leetcode.com/problems/fizz-buzz/description/

import java.util.ArrayList;

public class _0412_fizz_buzz {

    public static void main(String[] args) {

        ArrayList<String> solution = fizz_buzz(15);
        for(String elem : solution) {
            System.out.print(elem + " ");
        }

    }


    public static ArrayList<String> fizz_buzz(int n) {
        
        ArrayList<String> answer = new ArrayList<String>();
        
        for(int i=1; i<=n; ++i) {
            if(i % 15 == 0) {
                answer.add("FizzBuzz");
            }
            else if(i % 3 == 0) {
                answer.add("Fizz");
            }
            else if(i % 5 == 0) {
                answer.add("Buzz");
            }
            else {
                answer.add(String.valueOf(i));
            }
        }
    
        // For a more elegant solution
        // answer.add(i % 15 == 0 ? "FizzBuzz" :
        //            i % 5 == 0  ? "Buzz" :
        //            i % 3 == 0  ? "Fizz" :
        //            String.valueOf(i) );
    
        return answer;
    }

}
