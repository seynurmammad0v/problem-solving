//Given a string s, return the longest palindromic substring in s.
//Example 1:
//
//        Input: s = "babad"
//        Output: "bab"
//        Explanation: "aba" is also a valid answer.
//Example 2:
//
//        Input: s = "cbbd"
//        Output: "bb"
//Runtime: 141 ms, faster than 39.75% of Java online submissions for Longest Palindromic Substring.
//Memory Usage: 41.8 MB, less than 98.93% of Java online submissions for Longest Palindromic Substring.
public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        char[] chArr = s.toCharArray();
        String res = s.substring(0, 1);
        for (int i = 0; chArr.length - i >= res.length(); i++) {
            for (int j = chArr.length - 1; j - i >= res.length(); j--) {
                if (chArr[i] == chArr[j]) {
                    if (isPalindrome(chArr, i, j)) {
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }

    public static boolean isPalindrome(char[] str, int i, int j) {
        while (i < j) {
            if (str[i] != str[j])
                return false;
            i++;
            j--;
        }
        return true;
    }

    //test cases
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("asdasdaaadddddaaaaa"));
        System.out.println(longestPalindrome("aacabdkacaa"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("ac"));
        System.out.println(longestPalindrome("bb"));
        System.out.println(longestPalindrome("abb"));
        System.out.println(longestPalindrome("bb"));
        System.out.println(longestPalindrome("fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffgggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg"));
    }

}