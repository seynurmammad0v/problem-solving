import java.util.Stack;

class ValidParentheses {
    public static int lengthOfLastWord(String s) {
        s = s.trim();
        int li = s.lastIndexOf(' ');
        return (s.length() - 1) - li;
    }

    public static void main(String[] args) {
        System.out.printf("Expected: 5 \nActual:\t  %s \n", lengthOfLastWord("Hello World"));
        System.out.printf("Expected: 4 \nActual:\t  %s \n", lengthOfLastWord("   fly me   to   the moon  "));
        System.out.printf("Expected: 6 \nActual:\t  %s \n", lengthOfLastWord("luffy is still joyboy"));
    }
}