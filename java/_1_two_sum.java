import java.util.ArrayList;

public class _1_two_sum {

    public static void main(String[] args) {

        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(3);
        nums.add(4);
        nums.add(2);
        int target = 6;
        

        System.out.println("1 METHOD ");
        ArrayList<Integer> result = two_sum__1(nums,target);
        for(int elem : result) {
            System.out.println(elem);
        }
        System.out.println("------------------------------- ");


        System.out.println("2 METHOD ");
        result = two_sum__2(nums,target);
        for(int elem : result) {
            System.out.println(elem);
        }
        System.out.println("------------------------------- ");


        System.out.println("3 METHOD ");
        result = two_sum__3(nums,target);
        for(int elem : result) {
            System.out.println(elem);
        }
        System.out.println("------------------------------- ");
    }


    /* First method.
     * Nothing too smart. Just set sol = to the first number of the array.
     * Then search trough the array (starting from the second number) 
     * and tries to check if is the right match for the first one. 
     * If it is, then end the loops.
     * If it is not, just search a new starting number, then checks the 
     * next possible match of that number etc...
     * You basically search each time in a smaller subset.
     */
    public static ArrayList<Integer> two_sum__1(ArrayList<Integer> nums, int target) {

        int index_1 = 0;
        int index_2 = 0;
        int sol = target;
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        for(int i=0; i<nums.size(); ++i) {
            sol = target - nums.get(i);
            index_1 = i;
            for(int j=i+1; j<nums.size(); ++j) {
                
                // Or just check (nums.get(i) + nums.get(j) == target)
                // result = {i,j};
                if(sol - nums.get(j) == 0) {
                    index_2 = j;
                    result.add(index_1);
                    result.add(index_2);
                    return result;
                }
            }
        }

        // Not found
        result.add(-1);
        result.add(-1);
        return result;
    }


    /* Second method. Only with >= 0 numbers and sorted arrays.
     * The logic is the same as the first, but with an ordered array and setting an upper bound.
     * Set target_index to the index of the target number if present (upper bound).
     * This way we can be sure that no two sum pair can be found after that index.
     * If the index of the target number is not found (the target itself it's not present in the array), 
     * just do a normal two sum algorithm (target_index = nums.size()).
     */
    public static ArrayList<Integer> two_sum__2(ArrayList<Integer> nums, int target) {
        
        int target_index = nums.indexOf(target);
        if(target_index == -1)  { 
            target_index = nums.size();
        }

        int index_1 = 0;
        int index_2 = 0;
        int sol = target;
        ArrayList<Integer> result = new ArrayList<Integer>();

        for(int i=0; i<target_index; ++i) {
            sol = target - nums.get(i);
            index_1 = i;
            for(int j=i+1; j<target_index; ++j) {
                
                // Or just check (nums.get(i) + nums.get(j) == target)
                // result = {i,j};
                if(sol - nums.get(j) == 0) {
                    index_2 = j;
                    result.add(index_1);
                    result.add(index_2);
                    return result;
                }
            }
        }

        // Not found
        result.add(-1);
        result.add(-1);
        return result;
    }


    /* Third method.  Only with >= 0 numbers and sorted arrays.
     * The logic is the same as the second, but  the algorithm uses two indexes (start and end).
     * If start+end == target -> {start,end} are the indexes.
     * If start+end > target -> end--.
     * If start+end < target -> start++.
     */
    public static ArrayList<Integer> two_sum__3(ArrayList<Integer> nums, int target) {
        
        int target_index = nums.indexOf(target);
        if(target_index == -1)  { 
            target_index = nums.size();
        }

        int start = 0;
        int end = target_index - 1;
        ArrayList<Integer> result = new ArrayList<Integer>();

        while(start < end) {
            if(nums.get(start) + nums.get(end) == target) {
                result.add(start);
                result.add(end);
                return result;
            }
            else if(nums.get(start) + nums.get(end) < target){
                start++;
            }
            else {
                end--;
            }
        }

        // Not found
        result.add(-1);
        result.add(-1);
        return result;
    }
    
}
