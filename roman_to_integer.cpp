#include <iostream>
#include <string>
#include <vector>


using 
std::cout,
std::cin,
std::string,
std::vector;


int roman_to_int(string s) {
    
    int number = 0;
    char c = s[0];
    
    for(int i=0; i<s.length(); ++i) {
        
        c = s[i];
        
        switch(c) {
            
            case 'I': {
                if(s[i+1] == 'V') { number += 4; i++; }
                else if (s[i+1] == 'X') { number += 9; i++; }
                else { number += 1; }
                break;
            }
            case 'X': {
                if(s[i+1] == 'L') { number += 40; i++; }
                else if (s[i+1] == 'C') { number += 90; i++; }
                else { number += 10; }
                break;
            }
            case 'C': {
                if(s[i+1] == 'D') { number += 400; i++; }
                else if (s[i+1] == 'M') { number += 900; i++; }
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


int main(void) {

    string roman = "MCMXCIV";
    int number = roman_to_int(roman);

    cout << number;

    return 0;
}