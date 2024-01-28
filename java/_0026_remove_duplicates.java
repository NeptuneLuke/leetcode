// https://leetcode.com/problems/remove-duplicates-from-sorted-array

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class _0026_remove_duplicates {

    public static void main(String[] args) {

        ArrayList<Integer> nums = new ArrayList<Integer>() { 
            { add(0); add(0); add(1); add(1); add(1); add(2); add(2); add(3); add(3); add(4); } 
        };

        int solution = remove_duplicate_1(nums);
        System.out.println(solution);

        solution = remove_duplicate_2(nums);
        System.out.println(solution);

    }


    /* Solution 1.
     * Trivial solution with the help of set.
     */
    public static int remove_duplicate_1(ArrayList<Integer> nums) {
           
       if(nums.isEmpty()) { 
           return 0; 
       }
           
       Set<Integer> unique_nums = new HashSet<Integer>();
       unique_nums.addAll(nums);
   
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
    public static int remove_duplicate_2(ArrayList<Integer> nums) {
        
        if(nums.isEmpty()) { 
            return 0; 
        }

        int j = 1;
        for(int i=1; i<nums.size(); ++i){
            if(nums.get(i) != nums.get(i-1)){
                nums.set(j, nums.get(i));
                j++;
            }
        }

        return j;
    }

}
