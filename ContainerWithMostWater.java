/* 
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

 

Example 1:


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 
Example 2:

Input: height = [1,1]
Output: 1
*/
public class ContainerWithMostWater {
    static int calculateArea(int maxArea, int l, int r, int[] height) {
        int area = (r - l) * Math.min(height[l], height[r]);
        return Math.max(maxArea, area);
    }

    static int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;

        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            maxArea = calculateArea(maxArea, l, r, height);
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int height[] = { 2, 3, 10, 5, 7, 8, 9 };
        System.out.println(maxArea(height));
    }
}
