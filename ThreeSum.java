/* 
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {
    static Set<List<Integer>> twoSum(int[] nums, int target, int ele, int eleIdx) {
        Set<List<Integer>> ansSet = new HashSet<>();
        
        Map<Integer, Integer> map = new HashMap<>();
        Integer[] twoSumAns = new Integer[3];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && eleIdx != i && map.get(target - nums[i]) != eleIdx) {
                twoSumAns = new Integer[] { ele, target - nums[i], nums[i] };
                Arrays.sort(twoSumAns);
                ansSet.add(Arrays.asList(twoSumAns));
            }
            map.put(nums[i], i);
        }
        return ansSet;
    }

    static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            Set<List<Integer>> lists = twoSum(nums, 0 - nums[i], nums[i], i);
            set.addAll(lists);
        }
        set.remove(null);
        return List.copyOf(set);
    }

    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4 };
        System.out.println(threeSum(nums));
    }
}