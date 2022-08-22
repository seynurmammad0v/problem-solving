public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int head = 0;
        for (int i = 1; i< nums.length; i++) {
            if (nums[head] < nums[i]) {
                nums[head+1] = nums[i];
                head++;
            }
        }
        return head+1;
    }
}