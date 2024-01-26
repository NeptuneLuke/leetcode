#include <iostream>
#include <string>
#include <vector>


using 
std::cout,
std::string,
std::vector;


// Transform the array of digits in a string format of the number.
// Transform the string number back to long long and add 1.
// Transform the long long to string again.
// Clear the array of digits and fill it with the string number char by char.

// Instead of using string number inside the for loop, you can just multiply
// by powers of 10.
vector<int> plus_one_1(vector<int>& digits) {
    
    string number = "";
    long long num = 0;
    for (int i=0; i<digits.size(); ++i) {

        number += std::to_string(digits[i]);
    }
    
    num = std::stoll(number) + 1;
    number = std::to_string(num);

    digits.clear();
    for(int i=0; i<number.length(); ++i) {
        digits.push_back(number[i] - '0');
    }
    
    return digits; 
}


// Check if the current digit + 1 == 10. If so, then set current digit
// to 0, then go to the next digit. If the current digit + 1 != 10,
// it means it doesn't need to carry the 1(ten).
// Do this for every digit. Once the loop is finished, just check
// if the first digit(from left) is 10. If so, set it to 1 and
// insert a 0 at the end of the array.
vector<int> plus_one_2(vector<int>& digits) {

    for(int i=digits.size()-1; i >= 0; --i) {
            
        digits[i] = digits[i] + 1;
        if(digits[i] == 10 && i != 0) {
            digits[i] = 0;
        }
        else {
            break;
        }
    }

    if(digits[0] == 10) {
        digits[0] = 1;
        digits.push_back(0);
    }
        
    return digits;
}


int main(void) {

    vector<int> digits = {6,1,4,5,3,9,0,1,9,5,1,8,6,7,0,5,5,4,3};

    digits = plus_one_2(digits);
    for(auto & elem : digits) {
        cout << elem << "";
    }


    return 0;
}