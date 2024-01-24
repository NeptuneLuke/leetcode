#include <iostream>
#include <string>
#include <stack>


using 
std::cout,
std::cin,
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
    
    // If the stack is empty, all opening brackets have been matched with 
    // their corresponding closing brackets, so the string is valid, 
    // otherwise, there are unmatched opening brackets, so return false.
    // We can also push a tracker character (like '0','-' or any other chars) 
    // in the stack before the for loop to keep track of when it's done.
    // Or we can just return stack.empty()
    if(stack.empty()) {
        return true;
    }
    return false;
}


int main(void) {


    bool b = valid_parentheses("()[]{}");
    cout << std::boolalpha << b << "\n";

    b = valid_parentheses("{[()]}");
    cout << std::boolalpha << b << "\n";

    b = valid_parentheses("][");
    cout << std::boolalpha << b << "\n";

    b = valid_parentheses("[)(]");
    cout << std::boolalpha << b << "\n";

    return 0;
}