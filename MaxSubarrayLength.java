import java.util.HashMap;
import java.util.Map;

public class MaxSubarrayLength {
    static int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else if (map.containsKey(nums[i])) {
                if (map.get(nums[i]) < k) {
                    map.put(nums[i], map.get(nums[i]) + 1);
                }
            }
        }
        int c = 0;
        for (int v : map.values()) {
            c += v;
        }
        return c;
    }

    static int longestGoodSubarray(int[] nums, int k) {
        int left = 0, right = 0;
        int maxLength = 0;
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        while (right < nums.length) {
            frequencyMap.put(nums[right], frequencyMap.getOrDefault(nums[right], 0) + 1);

            while (frequencyMap.size() > k) {
                frequencyMap.put(nums[left], frequencyMap.get(nums[left]) - 1);
                if (frequencyMap.get(nums[left]) == 0) {
                    frequencyMap.remove(nums[left]);
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1, 2, 3, 1, 2 };
        int k = 2;
        System.out.println(maxSubarrayLength(nums, k));
    }
}
