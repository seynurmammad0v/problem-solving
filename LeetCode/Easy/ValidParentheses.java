import java.util.Stack;

class ValidParentheses {
    public static boolean isValid(String s) {
        if (s.length() % 2 == 1 || s.length() == 0) return false;
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '[' || arr[i] == '{' || arr[i] == '(') {
                stack.push(arr[i]);
            } else if (!stack.empty()) {
                boolean valid = switch (stack.pop()) {
                    case '{' -> '}' == arr[i];
                    case '(' -> ')' == arr[i];
                    case '[' -> ']' == arr[i];
                    default -> false;
                };
                if (!valid) {
                    return false;
                }
            } else return false;
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.printf("Expected: false \nActual:\t  %s \n", isValid("[]{}}["));
        System.out.printf("Expected: true \nActual:\t  %s \n", isValid("[{}[]{[]}]"));
        System.out.printf("Expected: false \nActual:\t  %s \n", isValid("))"));
        System.out.printf("Expected: false \nActual:\t  %s \n", isValid("(("));
    }
}