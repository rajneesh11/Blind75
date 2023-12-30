/* 
 * There is a large (m - 1) x (n - 1) rectangular field with corners at (1, 1) and (m, n) containing some horizontal and vertical fences given in arrays hFences and vFences respectively.

Horizontal fences are from the coordinates (hFences[i], 1) to (hFences[i], n) and vertical fences are from the coordinates (1, vFences[i]) to (m, vFences[i]).

Return the maximum area of a square field that can be formed by removing some fences (possibly none) or -1 if it is impossible to make a square field.

Since the answer may be large, return it modulo 109 + 7.

Note: The field is surrounded by two horizontal fences from the coordinates (1, 1) to (1, n) and (m, 1) to (m, n) and two vertical fences from the coordinates (1, 1) to (m, 1) and (1, n) to (m, n). These fences cannot be removed.

 

Example 1:



Input: m = 4, n = 3, hFences = [2,3], vFences = [2]
Output: 4
Explanation: Removing the horizontal fence at 2 and the vertical fence at 2 will give a square field of area 4.
Example 2:



Input: m = 6, n = 7, hFences = [2], vFences = [4]
Output: -1
Explanation: It can be proved that there is no way to create a square field by removing fences.
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaxSquareAreaByRemovingFencesFromField {
    static int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int[] newHFences = new int[hFences.length + 2];
        int[] newVFences = new int[vFences.length + 2];
        Set<Integer> set = new HashSet<>();

        int Hfences = newHFences.length;
        int Vfences = newVFences.length;
        newHFences[0] = 1;
        newHFences[Hfences - 1] = m;
        newVFences[0] = 1;
        newVFences[Vfences - 1] = n;
        int h = 1, v = 1;
        for (int i = 0; i < hFences.length; i++) {
            newHFences[h++] = hFences[i];
        }
        for (int i = 0; i < vFences.length; i++) {
            newVFences[v++] = vFences[i];
        }

        for (int i = 0; i < Hfences; i++) {
            for (int j = 0; j < Hfences; j++) {
                if(i!=j) set.add(Math.abs(newHFences[i] - newHFences[j]));
            }
        }

        long maxA = 0, mod = 1000000007;
        for (int i = 0; i < Vfences; i++) {
            for (int j = 0; j < Vfences; j++) {
                if (set.contains(Math.abs(newVFences[i] - newVFences[j]))) {
                    maxA = (long) Math.max(maxA, Math.pow(newVFences[i] - newVFences[j], 2));
                }
            }
        }

        return maxA != 0 ? (int) ((maxA) % mod) : -1;
    }

    public static void main(String[] args) {
        int m = 3, n = 9;
        int[] hFences = { 2 }, vFences = { 8, 6, 5, 4 };
        System.out.println(maximizeSquareArea(m, n, hFences, vFences));
    }
}
