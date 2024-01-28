// https://leetcode.com/problems/remove-duplicates-from-sorted-array

#include <iostream>
#include <vector>
#include <set>


using 
std::cout,
std::vector;

/* Solution 1.
 * Trivial solution with the help of set.
 */
int remove_duplicate_1(vector<int> nums) {
        
    if(nums.empty()) { 
        return 0; 
    }
        
    std::set<int> unique_nums;
    unique_nums.insert(nums.begin(), nums.end());

    return unique_nums.size();
}


/* Second method.
 * We use 2 pointers, one that keeps track of the current number,
 * the other one keeps trak of the previous number.
 * If the current element nums[i] is not equal to the previous element nums[i - 1], 
 * it means we have encountered a new unique element.
 * In that case, we update nums[new_n] with the value of the unique element at nums[i], 
 * and then increment new_n by 1 to mark the next position for a new unique element.
 * y doing this, we overwrite any duplicates and only keep the unique elements.
 */
int remove_duplicate_2(vector<int> nums) {
    
    if(nums.empty()) { 
        return 0; 
    }

    int new_n = 1;
    for(int i=1; i<nums.size(); ++i){
        if(nums[i] != nums[i - 1]){
            nums[new_n] = nums[i];
            new_n++;
        }
    }
    
    return new_n;
}


int main(void) {

    vector<int> nums = {0,0,1,1,1,2,2,3,3,4};

    int solution = remove_duplicate_1(nums);
    cout << solution << "\n";

    solution = remove_duplicate_2(nums);
    cout << solution;


    return 0;
}