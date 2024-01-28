// https://leetcode.com/problems/valid-parentheses/description/

#include <iostream>
#include <string>
#include <stack>


using 
std::cout,
std::string,
std::stack;


bool valid_parentheses(string s) {
    
    if(s.length()%2 != 0) {
        return false;
    }

    stack<char> stack;
    for(int i=0; i<s.length(); ++i) {
        if(s[i] == '(' || s[i] == '[' || s[i] == '{') {
            stack.push(s[i]);
        } 
        else {
            if(stack.empty()) {
                return false;
            }
            else if((s[i] == ')' && stack.top() == '(') ||
                    (s[i] == ']' && stack.top() == '[') ||
                    (s[i] == '}' && stack.top() == '{')) {
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


int main(void) {

    bool solution = valid_parentheses("()[]{}");
    cout << std::boolalpha << solution << "\n";

    solution = valid_parentheses("{[()]}");
    cout << std::boolalpha << solution << "\n";

    solution = valid_parentheses("][");
    cout << std::boolalpha << solution << "\n";

    solution = valid_parentheses("[)(]");
    cout << std::boolalpha << solution << "\n";


    return 0;
}