// https://leetcode.com/problems/remove-element/description

#include <iostream>
#include <vector>


using 
std::cout,
std::vector;


/* Trivial solution 1. 
 * Just use a support vector filled with only the numbers != val,
 * and then fill the original vector with the support vector.
 */
int remove_element_1(vector<int> nums, int val) {
        
    if(nums.empty()) { 
        return 0; 
    }

    vector<int> support;
    for(int i=0; i<nums.size(); ++i) {
        if(nums[i] != val) {
            support.push_back(nums[i]);
        }
    }

    nums = support;
    return nums.size();
}


/* Trivial solution 2
 * Modify the vector itself by using .erase(pos).
 */
int remove_element_2(vector<int> nums, int val) {
        
    if(nums.empty()) { 
        return 0; 
    }

    int len = nums.size();
    for(int i=0 ; i<len ; ++i) {
        if(nums[i] == val) {
            nums.erase(nums.begin() + i);
            i--;
            len--;
        }
    }
    
    return nums.size();
}


// Solution 3 with two pointers method.
int remove_element_3(vector<int> nums, int val) {
        
    if(nums.empty()) { 
        return 0; 
    }

    int index = 0;
    for(int i=0; i<nums.size(); ++i){
        if(nums[i] != val){
            nums[index] = nums[i];
            index++;
        }
    }
        
    return index;
}


int main(void) {

    vector<int> nums = {0,1,2,2,3,0,4,2};
    int val = 1;

    int solution = remove_element_1(nums,val);
    cout << solution << "\n";

    solution = remove_element_2(nums,val);
    cout << solution << "\n";

    solution = remove_element_3(nums,val);
    cout << solution << "\n";


    return 0;
}