import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//You can return the answer in any order.
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> iMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int findNum = target - nums[i];
            if(iMap.containsKey(findNum)){
                return new int[]{iMap.get(findNum), i};
            }
            iMap.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.printf("Expected: [0, 2] \nActual:\t  %s ",Arrays.toString(twoSum(new int[]{3, 4, 6}, 9)));
    }
}
