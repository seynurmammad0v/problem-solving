import java.util.HashMap;
import java.util.Map;

//Given a string s, find the length of the longest substring without repeating characters.
//Example :
//        Input: s = "abcabcbb"
//        Output: 3
//        Explanation: The answer is "abc", with the length of 3.

public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastI = new HashMap<>();
        long validator = 1L;
        int chCount = 0, maxChCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (validator < (validator | 1L << (long) s.charAt(i))) {
                validator = validator | 1L << (long) s.charAt(i);
                lastI.put(s.charAt(i), i);
                chCount++;
            } else {
                int mem = i;
                i = lastI.getOrDefault(s.charAt(i), -1);
                if (i != -1) {
                    validator = 1L;
                    if (chCount > maxChCount) {
                        maxChCount = chCount;
                    }
                    chCount = 0;
                    lastI.put(s.charAt(i), mem);
                } else {
                    chCount++;
                    i = mem;
                }
            }
        }
        return Math.max(maxChCount, chCount);
    }

    //test cases
    public static void main(String[] args) {
        System.out.printf("Expected: 2 \nActual:\t  %s\n", lengthOfLongestSubstring("aab"));
        System.out.printf("Expected: 3 \nActual:\t  %s\n", lengthOfLongestSubstring("dvdf"));
        System.out.printf("Expected: 4 \nActual:\t  %s\n", lengthOfLongestSubstring("tmmmzuxt"));
        System.out.printf("Expected: 3 \nActual:\t  %s\n", lengthOfLongestSubstring("abcabcbb"));
        System.out.printf("Expected: 1 \nActual:\t  %s\n", lengthOfLongestSubstring("bbbbbbb"));
        System.out.printf("Expected: 3 \nActual:\t  %s\n", lengthOfLongestSubstring("pwwkew"));
        System.out.printf("Expected: 6 \nActual:\t  %s\n", lengthOfLongestSubstring("wobgrovw"));
        System.out.printf("Expected: 3 \nActual:\t  %s\n", lengthOfLongestSubstring("aabaab!bb"));
        System.out.printf("Expected: 55 \nActual:\t  %s\n", lengthOfLongestSubstring("hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"));
    }
}