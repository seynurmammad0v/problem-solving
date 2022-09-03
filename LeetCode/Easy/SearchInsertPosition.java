import java.util.Stack;

class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) start = mid + 1;
            else if (nums[mid] > target) end = mid - 1;
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.printf("Expected: 0 \nActual:\t  %s \n", searchInsert(new int[]{1,3,5,6}, 0));
        System.out.printf("Expected: 1 \nActual:\t  %s \n", searchInsert(new int[]{1,3,5,6}, 2));
        System.out.printf("Expected: 4 \nActual:\t  %s \n", searchInsert(new int[]{1,3,5,6}, 7));
        System.out.printf("Expected: 2 \nActual:\t  %s \n", searchInsert(new int[]{1,3,5,6}, 4));
    }
}