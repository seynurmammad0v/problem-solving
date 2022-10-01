import java.util.Arrays;

public class AddBinary {
    //first method
    public static String addBinary(String a, String b) {
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, mem = 0;
        while (i >= 0 || j >= 0) {
            int sum = mem;
            if (j >= 0) sum += bChars[j--] - '0';
            if (i >= 0) sum += aChars[i--] - '0';
            sb.append(sum % 2);
            mem = sum / 2;
        }
        if (mem != 0) sb.append(mem);
        return sb.reverse().toString();
    }

    //scnd method
    public static String addBinaryTwo(String a, String b) {
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        int mem = 0;
        for (int i = aChars.length - 1, j = bChars.length - 1; i >= 0 && j >= 0; i--, j--) {
            mem = getMem(aChars[i] - '0' + bChars[j] - '0' + mem, sb, mem);
        }
        aChars = aChars.length > bChars.length ? aChars : bChars;
        for (int i = aChars.length - sb.length() - 1; i >= 0; i--) {
            mem = getMem(aChars[i] - '0' + mem, sb, mem);
        }
        if (mem == 1) sb.append("1");
        return sb.reverse().toString();
    }

    private static int getMem(int n, StringBuilder s, int mem) {
        switch (n) {
            case 2: {
                s.append("0");
                return 1;
            }
            case 3: {
                s.append("1");
                return 1;
            }
            case 1: {
                s.append("1");
                return 0;
            }
            default: {
                s.append("0");
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        System.out.printf("Expected: 100  \nActual:\t  %s \n", addBinary("11", "1"));
        System.out.printf("Expected: 10101  \nActual:\t  %s \n", addBinary("1010", "1011"));
        System.out.printf("Expected: 10101  \nActual:\t  %s \n", addBinary("1011", "1010"));
        System.out.printf("Expected: 11110  \nActual:\t  %s \n", addBinary("1111", "1111"));
        System.out.printf("Expected: 0  \nActual:\t  %s \n", addBinary("0", "0"));
        System.out.printf("Expected: 1  \nActual:\t  %s \n", addBinary("1", "0"));
        System.out.printf("Expected: 10  \nActual:\t  %s \n", addBinary("1", "1"));
        System.out.printf("Expected: 110110  \nActual:\t  %s \n", addBinary("100", "110010"));
        System.out.println("V2");
        System.out.printf("Expected: 100  \nActual:\t  %s \n", addBinaryTwo("11", "1"));
        System.out.printf("Expected: 10101  \nActual:\t  %s \n", addBinaryTwo("1010", "1011"));
        System.out.printf("Expected: 10101  \nActual:\t  %s \n", addBinaryTwo("1011", "1010"));
        System.out.printf("Expected: 11110  \nActual:\t  %s \n", addBinaryTwo("1111", "1111"));
        System.out.printf("Expected: 0  \nActual:\t  %s \n", addBinaryTwo("0", "0"));
        System.out.printf("Expected: 1  \nActual:\t  %s \n", addBinaryTwo("1", "0"));
        System.out.printf("Expected: 10  \nActual:\t  %s \n", addBinaryTwo("1", "1"));
        System.out.printf("Expected: 110110  \nActual:\t  %s \n", addBinaryTwo("100", "110010"));
    }
}