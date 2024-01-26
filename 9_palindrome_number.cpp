#include <iostream>
#include <vector>


using 
std::cout,
std::vector;


// First method. An array is filled with the reversed number
// and then every complementary indexes of the array are checked.
bool is_palindrome_1(int x) {
    
    if(x < 0) {
        return false;
    }

    vector<int> digits;
    int temp = x;

    while(x > 0) {
        temp = x % 10;
        digits.push_back(temp);
        x /= 10;
    }
    
    for(int i=0; i<digits.size(); ++i) {

        if(digits[i] != digits[digits.size() - i - 1]) {
            return false;
        }
    }

    return true;
}


// Second method. Uses some simple but non immediate maths
// transformation.
bool is_palindrome_2(int x) {
    
    if (x < 0) {
        return false;
    }

    long reversed = 0;
    long temp = x;

    while (temp != 0) {
        int digit = temp % 10;
        reversed = reversed * 10 + digit;
        temp /= 10;
    }

    return (reversed == x);
}


int main(void) {

    bool b = is_palindrome_1(121);
    cout << std::boolalpha << b << "\n";

    b = is_palindrome_2(121);
    cout << std::boolalpha << b << "\n";


    return 0;
}