// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/

public class _0028_index_first_substring {

    public static void main(String[] args) {

        String haystack = "sadsosad";
        String needle = "sad";
    
        int solution = index_first_substring_1(haystack,needle);
        System.out.println(solution);
    
        solution = index_first_substring_2(haystack,needle);
        System.out.println(solution);
    }

    
    // First method, without using library/string methods.
    public static int index_first_substring_1(String haystack, String needle) {
    
        if(haystack.length() == 0 && needle.length() == 0) {
            return -1;
        }
    
        int j = 0;
        int pos = -1;
        
        for(int i=0; i<haystack.length(); ++i) {
            if(haystack.charAt(i) == needle.charAt(0)) {
                j = 0;
                pos = i;
                while(j < needle.length() && j != -1) {
                    if(haystack.charAt(i) == needle.charAt(j)) {
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


    // Second method, using .contains().
    public static int index_first_substring_2(String haystack, String needle) {
        
        return haystack.indexOf(needle);
    }

}
