// https://leetcode.com/problems/search-insert-position/description

import java.util.ArrayList;

public class _0035_search_insert_position {

    public static void main(String[] args) {

        ArrayList<Integer> nums = new ArrayList<Integer>() { 
            { add(1); add(3); add(4); add(6); } 
        };
        int target = 5;
    
        int solution = search_insert_1(nums, target);
        System.out.println(solution);
    
        solution = search_insert_2(nums, target);
        System.out.println(solution);
    }

    
    /* Solution 1.
     * Just a binary search and then check where the target 
     * position should be, based on the mid position.
     */
    public static int search_insert_1(ArrayList<Integer> nums, int target) {
        
        int start = 0;
        int end = nums.size() - 1;
        int mid = (start + end) / 2;
        while(nums.get(mid) != target && start <= end) {
            if(nums.get(mid) > target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
            mid = (start + end) / 2;
        }

        if(nums.get(mid) == target) {
            return mid;
        }
        else if(nums.get(mid) > target) {
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


    /* Second solution. 
     * The same as the first method, but more elegant.
     */
    public static int search_insert_2(ArrayList<Integer> nums, int target) {
        
        int start = 0;
        int end = nums.size() - 1;
        int mid = (start + end) / 2;
        
        while(start <= end) {
            mid = (start + end) / 2;
            if(nums.get(mid) == target) {
                return mid;
            }
            else if(nums.get(mid) > target) {
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        
        return start;
    }

}
