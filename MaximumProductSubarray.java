/* 
 Given an integer array nums, find a 
subarray
 that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

 

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 

Constraints:

1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 */
public class MaximumProductSubarray {
    static int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int n = nums.length;
        int l = 1, r = 1;

        for (int i = 0; i < n; i++) {
            l = l == 0 ? 1 : l;
            r = r == 0 ? 1 : r;

            l *= nums[i];
            r *= nums[n - 1 - i];
            maxProd = Math.max(maxProd, Math.max(l, r));
        }

        return maxProd;
    }

    static int maxProduct_BruteForce(int[] nums) {
        int maxProd = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int product = nums[i];
            maxProd = Math.max(maxProd, product);

            for (int j = i + 1; j < nums.length; j++) {
                product *= nums[j];
                maxProd = Math.max(maxProd, product);
            }
        }
        return maxProd;
    }

    public static void main(String[] args) {
        // int[] nums = { -2, 0, -1 };
        // int[] nums = { 2, 3, -2, 4 };
        // int[] nums = { -3, -1, -1 };
        // int[] nums = { -3, 0, 1, -2 };
        // int[] nums={-2};
        int[] nums = { -2, 3, -4 };
        System.out.println(maxProduct(nums));
        System.out.println(maxProduct_BruteForce(nums));
    }
}
