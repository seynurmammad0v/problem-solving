import java.util.Arrays;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int digit = digits[digits.length - 1] + 1;
        if (digit == 10) {
            for (int i = digits.length - 1; i >= 0; i--) {
                digits[i] = digits[i] + 1;
                if (digits[i] == 10) {
                    digits[i] = 0;
                    if (i - 1 == -1) {
                        int[] result = new int[digits.length + 1];
                        result[0] = 1;
                        return result;
                    }
                } else return digits;
            }
        }
        digits[digits.length - 1] = digit;
        return digits;
    }


    public static void main(String[] args) {
        System.out.printf("Expected: [3, 4, 7] \nActual:\t  %s \n", Arrays.toString(plusOne(new int[]{3, 4, 6})));
        System.out.printf("Expected: [1, 0, 0, 0] \nActual:\t  %s \n", Arrays.toString(plusOne(new int[]{9, 9, 9})));
        System.out.printf("Expected: [1, 0] \nActual:\t  %s \n", Arrays.toString(plusOne(new int[]{9})));
    }
}