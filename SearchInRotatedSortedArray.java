/* 
 * There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
 

Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104
 */
public class SearchInRotatedSortedArray {
    static int idx = -1;

    static void divide(int[] nums, int b, int e, int target) {
        if (b < e) {
            int m = (b + e) / 2;
            if (idx == -1) {
                idx = nums[b] == target ? b : -1;
            }

            divide(nums, b, m, target);
            divide(nums, m + 1, e, target);
        }
        if (b == e && idx == -1) {
            idx = nums[b] == target ? b : -1;
        }
    }

    static int search_DnC(int[] nums, int target) {
        divide(nums, 0, nums.length - 1, target);
        return idx;
    }

    static int search(int[] nums, int target) {
        int i = 0;
        while (i <= nums.length / 2) {
            if (nums[i] == target) {
                return i;
            }

            if (nums[nums.length - 1 - i] == target) {
                return nums.length - 1 - i;
            }
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = { 4 };
        int target = 4;
        System.out.println(search(nums, target));
    }
}
