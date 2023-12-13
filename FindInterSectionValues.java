import java.util.HashSet;
import java.util.Set;

public class FindInterSectionValues {
    static int[] method1_BruteForce(int[] nums1, int[] nums2) {
        int[] ans = new int[2];

        int n1 = nums1.length;
        int n2 = nums2.length;
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (nums1[i] == nums2[j]) {
                    ans[0]++;
                    break;
                }
            }
        }
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < n1; j++) {
                if (nums2[i] == nums1[j]) {
                    ans[1]++;
                    break;
                }
            }
        }

        return ans;
    }

    static int[] findInterSectionValues(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set=new HashSet<>();
        Set<Integer> nums2Set=new HashSet<>();
        int[] ans=new int[2];

        for(int i=0;i<nums1.length;i++){
            nums1Set.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            nums2Set.add(nums2[i]);
        }

        for(int n:nums1){
            if(nums2Set.contains(n)){
                ans[0]++;
            }
        }
        for(int n:nums2){
            if(nums1Set.contains(n)){
                ans[1]++;
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        int[] nums1 = { 4, 3, 2, 3, 1 }; //4,3,2,1
        int[] nums2 = { 2, 2, 5, 2, 3, 6 }; // 2,5,3,6
        // int[] nums1 = { 3, 4, 2, 3 };
        // int[] nums2 = { 1, 5 };
        int[] a = findInterSectionValues(nums1, nums2);
        System.out.println(a[0] + " " + a[1]);
    }
}
