public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        if (nums.length == 1 && nums[0] == val) return 0;
        int tail = nums.length - 1;
        int i = 0;
        while (tail >= i) {
            if (nums[i] == val) {
                while (nums[tail] == val) {
                    tail--;
                    if (tail <= i) {
                        return i;
                    }
                }
                nums[i] = nums[tail];
                tail--;
            }
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 2, 3};
        System.out.printf("Expected: 2 \nActual:\t  %d ", removeElement(arr, 3));
    }

}