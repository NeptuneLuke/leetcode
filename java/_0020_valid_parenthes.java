// https://leetcode.com/problems/valid-parentheses/description/

import java.util.Stack;

public class _0020_valid_parenthes {

    public static void main(String[] args) {

        boolean solution = valid_parentheses("()[]{}");
        System.out.println(solution);

        solution = valid_parentheses("{[()]}");
        System.out.println(solution);

        solution = valid_parentheses("][");
        System.out.println(solution);

        solution = valid_parentheses("[)(]");
        System.out.println(solution);
    }


    public static boolean valid_parentheses(String s) {

        if(s.length()%2 != 0) {
            return false;
        }
    
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length(); ++i) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } 
            else {
                if(stack.empty()) {
                    return false;
                }
                else if((s.charAt(i) == ')' && stack.peek() == '(') ||
                        (s.charAt(i) == ']' && stack.peek() == '[') ||
                        (s.charAt(i) == '}' && stack.peek() == '{')) {
                            stack.pop();
                } 
                else {
                    return false;
                }
            }
        }
        
        /* If the stack is empty, all opening brackets have been matched with 
         * their corresponding closing brackets, so the string is valid.
         * Otherwise, there are unmatched opening brackets, so return false.
         */
        return stack.empty();
    }

}
