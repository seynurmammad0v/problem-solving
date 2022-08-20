public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        char[] arr = strs[0].toCharArray();
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (!(i < strs[j].length() && strs[j].charAt(i) == arr[i])) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        System.out.printf("Expected: fl \nActual:\t  %s ", longestCommonPrefix(new String[]{
                "flower", "flow", "flight"
        }));
    }
}