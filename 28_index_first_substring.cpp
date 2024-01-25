#include <iostream>
#include <string>


using 
std::cout,
std::cin,
std::string;


// First method, without using library/string methods.
int index_first_substring_1(string haystack, string needle) {
    
    if(haystack.length() == 0 && needle.length() == 0) {
        return -1;
    }

    int j = 0;
    int pos = -1;
    
    for(int i=0; i<haystack.size(); ++i) {

        if(haystack[i] == needle[0]) {
                
            j = 0;
            pos = i;
            while(j < needle.size() && j != -1) {
                    
                if(haystack[i] == needle[j]) {
                    j++;
                    i++;
                }
                else {
                    j = -1;
                }
                
            }
            i = pos;
            if(j != -1) {
                return pos;
            }   
        }    
    }
    
    return -1;
}


// Second method, using .find() and string::npos.
int index_first_substring_2(string haystack, string needle) {
    
    if(haystack.find(needle) != string::npos){
            return haystack.find(needle);
    }
    else{
        return -1;
    }
}


// Third method, very elegant.
int index_first_substring_3(string haystack, string needle) {
    
    return haystack.find(needle);
}


int main(void) {


    int index = index_first_substring_1("sodsosad","sad");
    cout << index << "\n";

    index = index_first_substring_2("sodsosad","sad");
    cout << index << "\n";

    index = index_first_substring_3("sodsosad","sad");
    cout << index << "\n";
    return 0;
}