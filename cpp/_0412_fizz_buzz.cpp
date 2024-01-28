// https://leetcode.com/problems/fizz-buzz/description/

#include <iostream>
#include <string>
#include <vector>


using 
std::cout,
std::string,
std::vector;


vector<string> fizz_buzz(int n) {
        
    vector<string> answer;
    
    for(int i=1; i<=n; ++i) {
        if(i % 15 == 0) {
            answer.push_back("FizzBuzz");
        }
        else if(i % 3 == 0) {
            answer.push_back("Fizz");
        }
        else if(i % 5 == 0) {
            answer.push_back("Buzz");
        }
        else {
            answer.push_back(std::to_string(i));
        }
    }

    // For a more elegant solution
    // answer.push_back(i % 15 == 0 ? "FizzBuzz" :
    //            i % 5 == 0  ? "Buzz" :
    //            i % 3 == 0  ? "Fizz" :
    //            std::to_string(i) );

    return answer;
}


int main(void) {

    vector<string> solution = fizz_buzz(15);
    for(auto & elem : solution) {
        cout << elem << " ";
    }

    
    return 0;
}