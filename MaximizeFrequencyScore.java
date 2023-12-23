import java.util.Arrays;

public class MaximizeFrequencyScore {
    static int maxFrequencyScore(int[] nums, long k) {
        Arrays.sort(nums);

        int maxFreq = 0;
        int left = 0;
        int right = 0;
        int opsUsed = 0;

        while (right < nums.length) {
            int diff = nums[right] - nums[left];
            int totalOps = diff * (right - left);

            if (opsUsed + totalOps <= k) {
                opsUsed += totalOps;
                right++;
                maxFreq = Math.max(maxFreq, right - left);
            } else {
                opsUsed -= nums[right] - nums[left];
                left++;
            }
        }

        return maxFreq;
    }


    public static void main(String[] args) {
        int[] nums = {1,4,4,2,4};
        int k = 0;
        int result = maxFrequencyScore(nums, k);
        System.out.println(result);
    }
}
