// https://leetcode.com/problems/remove-element/description

import java.util.ArrayList;

public class _0027_remove_element {

    public static void main(String[] args) {

        ArrayList<Integer> nums = new ArrayList<Integer>() { 
            { add(0); add(1); add(2); add(2); add(3); add(0); add(4); add(2); } 
        };
        int val = 1;


        int solution = remove_element_1(nums,val);
        System.out.println(solution);

        solution = remove_element_2(nums,val);
        System.out.println(solution);

        solution = remove_element_3(nums,val);
        System.out.println(solution);

    }

    
    /* Trivial solution 1. 
     * Just use a support vector filled with only the numbers != val,
     * and then fill the original vector with the support vector.
     */
    public static int remove_element_1(ArrayList<Integer> nums, int val) {
           
        if(nums.isEmpty()) { 
            return 0; 
        }
    
        ArrayList<Integer> support = new ArrayList<Integer>();
        for(int i=0; i<nums.size(); ++i) {
            if(nums.get(i) != val) {
                support.add(nums.get(i));
            }
        }
    
        nums = support;
        return nums.size();
    }


    /* Trivial solution 2
     * Modify the vector itself by using .erase(pos).
     */
    public static int remove_element_2(ArrayList<Integer> nums, int val) {        

        if(nums.isEmpty()) { 
            return 0; 
        }
    
        int len = nums.size();
        for(int i=0 ; i<len ; ++i) {
            if(nums.get(i) == val) {
                nums.remove(i);
                i--;
                len--;
            }
        }
    
        return nums.size();
    }


    // Solution 3 with two pointers method.
    public static int remove_element_3(ArrayList<Integer> nums, int val) {
            
        if(nums.isEmpty()) { 
            return 0; 
        }

        int index = 0;
        for(int i=0; i<nums.size(); ++i){
            if(nums.get(i) != val){
                nums.set(index,nums.get(i));
                index++;
            }
        }
            
        return index;
    }

}
