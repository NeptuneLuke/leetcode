#include <iostream>
#include <string>


using 
std::cout,
std::string;


// Start from the end of string. If s[i] != ' ' it means
// we found the last word, so we start counting the word length,
// and set found to true (so we know we should break when s[i] == ' ').
// When we encounter a space we just break out of the for loop.
int length_last_word(string s) {
    
    int count = 0;
    bool found = false;
    
    for(int i=s.length()-1; i>=0; --i) {

        if(s[i] != ' ') {
                
            count++;
            found = true;
        }   
            
        if(s[i] == ' ' && found == true) {
            break;
        }
    }
        
    return count;
}


int main(void) {

    int index = length_last_word("hello world");
    cout << index << "\n";

    index = length_last_word("    world");
    cout << index << "\n";

    index = length_last_word("hello    ");
    cout << index << "\n";

    index = length_last_word("    hello    ");
    cout << index << "\n";
    
    
    return 0;
}