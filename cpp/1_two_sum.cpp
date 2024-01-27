#include <iostream>
#include <vector>
#include <algorithm>


using 
std::cout,
std::vector;


// First method.
// Nothing too smart. Just set sol = to the first number of 
// the array. The searchs trough the array (starting from
// the second number) and tries to check if is the right number
// for the first one. If it is, then end the loops.
// If it is not, just search a "new first" number,
// then checks the second number of that number etc...
// You basically search each time in a smaller subset.
vector<int> two_sum_1(vector<int> nums, int target) {

    int index_1 = 0;
    int index_2 = 0;
    int sol = target;
    vector<int> result;
    
    for(int i=0; i<nums.size(); ++i) {

        sol = target-nums[i];
        index_1 = i;
        for(int j=i+1; j<nums.size(); ++j) {
            
            // Or just check (nums[i] + nums[j] == target)
            // result = {i,j};
            if(sol - nums[j] == 0) {
                index_2 = j;
                result = {index_1,index_2};
                return result;
            }
        }
    }

    // Not found
    result = {-1,-1};
    return result;
}


// Second method. The logic is the same as the first, but with an ordered array
// and setting an upper bound.
// Set target_index to the index of the target number if present(upper bound).
// This way we can be sure that no two sum can be found after that index.
// If the index of the target number is not found (the target itself it's not present
// in the array) just do a normal two sum algorithm(target_index = nums.size()).
// Only with >= 0 numbers.
vector<int> two_sum_2(vector<int> nums, int target) {
    
    std::sort(nums.begin(),nums.end());
    
    int target_index = nums.size();
    auto it = std::find(nums.begin(), nums.end(), target);  
    if(it != nums.end())  { 
        target_index = it - nums.begin();
    }
    else {
        cout << "Target not found in array! \n";
        vector<int> result = {-1,-1};
        return result;
    }

    int index_1 = 0;
    int index_2 = 0;
    int sol = target;
    vector<int> result;

    for(int i=0; i<target_index; ++i) {

        sol = target - nums[i];
        index_1 = i;
        for(int j=i+1; j<target_index; ++j) {
            
            // Or just check (nums[i] + nums[j] == target)
            // result = {i,j};
            if(sol - nums[j] == 0) {
                index_2 = j;
                result = {index_1,index_2};
                return result;
            }
        }
    }

    // Not found
    result = {-1,-1};
    return result;
}


// Third method. The logic is similar to the second, but 
// the algorithm uses two indexes (start and end)
// If start+end == target then, {start,end} are the indexex.
// If start+end > target -> end--
// If start+end < target -> start++
// Only with >= 0 numbers.
vector<int> two_sum_3(vector<int> nums, int target) {
    
    std::sort(nums.begin(),nums.end());
    
    int target_index = nums.size();
    auto it = std::find(nums.begin(), nums.end(), target);  
    if(it != nums.end())  { 
        target_index = it - nums.begin();
    }
    else {
        cout << "Target not found in array! \n";
        vector<int> result = {-1,-1};
        return result;
    }

    int start = 0;
    int end = target_index - 1;
    vector<int> result;

    while(start < end) {

        if(nums[start] + nums[end] == target) {
            result = {start,end};
            return result;
        }
        else if(nums[start] + nums[end] < target){
            start++;
        }
        else {
            end--;
        }
    }

    // Not found
    result = {-1,-1};
    return result;
}


int main(void) {

    vector<int> nums = {3,2,4}; 
    int target = 6;
    
    cout << "1 METHOD \n";
    vector<int> result = two_sum_1(nums,target);
    for(const auto &elem : result) {
        cout << elem << "\n";
    }
    cout << "------------------------------- \n";
    

    cout << "2 METHOD \n";
    vector<int> result2 = two_sum_2(nums,target);
    for(const auto &elem : result2) {
        cout << elem << "\n";
    }
    cout << "------------------------------- \n";
    

    cout << "3 METHOD \n";
    vector<int> result3 = two_sum_3(nums,target);
    for(const auto &elem : result3) {
        cout << elem << "\n";
    }
    cout << "------------------------------- \n";


    return 0;
}