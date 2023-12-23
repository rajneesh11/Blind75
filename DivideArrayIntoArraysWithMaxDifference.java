/* 
 * You are given an integer array nums of size n and a positive integer k.

Divide the array into one or more arrays of size 3 satisfying the following conditions:

Each element of nums should be in exactly one array.
The difference between any two elements in one array is less than or equal to k.
Return a 2D array containing all the arrays. If it is impossible to satisfy the conditions, return an empty array. And if there are multiple answers, return any of them.

 

Example 1:

Input: nums = [1,3,4,8,7,9,3,5,1], k = 2
Output: [[1,1,3],[3,4,5],[7,8,9]]
Explanation: We can divide the array into the following arrays: [1,1,3], [3,4,5] and [7,8,9].
The difference between any two elements in each array is less than or equal to 2.
Note that the order of elements is not important.
Example 2:

Input: nums = [1,3,3,2,7,3], k = 3
Output: []
Explanation: It is not possible to divide the array satisfying all the conditions.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivideArrayIntoArraysWithMaxDifference {
    static int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        int i = 0;
        while (i < nums.length) {
            List<Integer> group = new ArrayList<>();
            group.add(nums[i]);

            int j = i + 1;
            while (j < nums.length && nums[j] - group.get(group.size() - 1) <= k && group.size() < 3) {
                group.add(nums[j]);
                j++;
            }

            if (group.size() == 3) {
                result.add(new ArrayList<>(group));
            } else {
                return new int[0][0];
            }

            i = j;
        }

        int[][] res = new int[result.size()][3];

        for (int a = 0; a < result.size(); a++) {
            for (int b = 0; b < 3; b++) {
                res[a][b] = result.get(a).get(b);
            }
        }

        return res;
    }
    public static List<List<Integer>> divideArray1(int[] nums, int k) {
        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Initialize the result
        List<List<Integer>> result = new ArrayList<>();

        // Step 3: Iterate through the sorted array
        int i = 0;
        while (i < nums.length) {
            // Step 4: Group consecutive elements
            List<Integer> group = new ArrayList<>();
            group.add(nums[i]);

            int j = i + 1;
            while (j < nums.length && nums[j] - group.get(group.size() - 1) <= k) {
                group.add(nums[j]);
                j++;
            }

            // Step 5: Add the group to the result
            result.add(new ArrayList<>(group));

            // Move to the next element
            i = j;
        }

        // Return the result
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {15,13,12,13,12,14,12,2,3,13,12,14,14,13,5,12,12,2,13,2,2};
        int k = 2;
        int ans[][] = divideArray(nums, k);

        /* for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        } */

        List<List<Integer>> result = divideArray1(nums, k);

        // Print the result
        for (List<Integer> group : result) {
            System.out.println(group);
        }
    }
}
