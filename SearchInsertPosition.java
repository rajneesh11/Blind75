/* 
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4
 */
public class SearchInsertPosition {
    static int searchInsert(int[] nums, int target) {
        int low = 0, end = nums.length - 1;
        int mid = 0;
        while (low <= end) {
            mid = (low + end) / 2;
            if (nums[mid] == target)
                return mid;
            else if (target < nums[mid])
                end = mid - 1;
            else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 6 };
        int target = 0;
        System.out.println(searchInsert(nums, target));
    }
}
