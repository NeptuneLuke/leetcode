// https://leetcode.com/problems/length-of-last-word/description/

public class _0058_length_last_word {

    public static void main(String[] args) {

        int solution = length_last_word("hello world");
        System.out.println(solution);

        solution = length_last_word("    world");
        System.out.println(solution);

        solution = length_last_word("hello    ");
        System.out.println(solution);

        solution = length_last_word("    hello    ");
        System.out.println(solution);
    }

    
    /* Start from the end of string. If s[i] != ' ' it means
     * we found the last word, so we start counting the word length,
     * and set found to true (so we know we should break when s[i] == ' ').
     * When we encounter a space we just break out of the for loop.
     */
    public static int length_last_word(String s) {
    
        int count = 0;
        boolean found = false;
        
        for(int i=s.length()-1; i>=0; --i) {
            if(s.charAt(i) != ' ') {
                count++;
                found = true;
            }   
            if(s.charAt(i) == ' ' && found == true) {
                break;
            }
        }
            
        return count;
    }

}
