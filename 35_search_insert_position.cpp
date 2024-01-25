#include <iostream>
#include <vector>


using 
std::cout,
std::cin,
std::vector;


// First solution. Just a binary search and then
// check where the target position should be, based on the mid position.
int search_insert_1(vector<int>& nums, int target) {
        
    int start = 0;
    int end = nums.size() - 1;
    int mid = (start + end) / 2;
    while(nums[mid] != target && start <= end) {

        if(nums[mid] > target) {
            end = mid - 1;
        }
        else {
            start = mid + 1;
        }

        mid = (start + end) / 2;
    }

    if(nums[mid] == target) {
        return mid;
    }
    else if(nums[mid] > target) {
        if(mid == 0) {
            return 0;
        }
        else {
            return mid - 1; 
        }
    }
    else {
        return mid + 1;
    }
}


// Second solution. The same as the first method,
// but more elegant.
int search_insert_2(vector<int>& nums, int target) {

    int start = 0;
    int end = nums.size() - 1;
    int mid = (start + end) / 2;
    
    while(start <= end){
            
        mid = (start + end) / 2;
        if(nums[mid] == target){
            return mid;
        }
        else if(nums[mid] > target){
            end = mid - 1;
        }
        else{
            start = mid + 1;
        }
    }
    
    return start;
}


int main(void) {

    vector<int> nums = {1,3,4,6};
    int pos = search_insert_1(nums, 5);
    cout << pos << "\n";

    pos = search_insert_2(nums, 5);
    cout << pos << "\n";

    return 0;
}