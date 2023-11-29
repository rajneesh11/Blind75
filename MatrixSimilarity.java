/* 
 * Matrix Similarity After Cyclic Shifts
User Accepted:28
User Tried:48
Total Accepted:28
Total Submissions:50
Difficulty:Easy
You are given a 0-indexed m x n integer matrix mat and an integer k. You have to cyclically right shift odd indexed rows k times and cyclically left shift even indexed rows k times.

Return true if the initial and final matrix are exactly the same and false otherwise.

 

Example 1:

Input: mat = [[1,2,1,2],[5,5,5,5],[6,3,6,3]], k = 2
Output: true
Explanation:


Initially, the matrix looks like the first figure. 
Second figure represents the state of the matrix after one right and left cyclic shifts to even and odd indexed rows.
Third figure is the final state of the matrix after two cyclic shifts which is similar to the initial matrix.
Therefore, return true.
Example 2:

Input: mat = [[2,2],[2,2]], k = 3
Output: true
Explanation: As all the values are equal in the matrix, even after performing cyclic shifts the matrix will remain the same. Therefeore, we return true.
Example 3:

Input: mat = [[1,2]], k = 1
Output: false
Explanation: After one cyclic shift, mat = [[2,1]] which is not equal to the initial matrix. Therefore we return false
 */

import java.util.Arrays;

public class MatrixSimilarity {
    static boolean areSimilar(int[][] mat, int k) {
        int[][] orMat = Arrays.stream(mat).map(int[]::clone).toArray(int[][]::new);
        for (int a = 1; a <= k; a++) {
            for (int i = 0; i < mat.length; i++) {
                if (i % 2 == 0) {
                    // even: left shift
                    for (int j = 1; j < mat[i].length; j++) {
                        int temp = mat[i][j - 1];
                        mat[i][j - 1] = mat[i][j];
                        mat[i][j] = temp;
                    }
                } else {
                    // odd: right shift
                    for (int j = mat[i].length - 1; j > 0; j--) {
                        int temp = mat[i][j - 1];
                        mat[i][j - 1] = mat[i][j];
                        mat[i][j] = temp;
                    }
                }
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] != orMat[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] mat = { { 1, 2, 1, 2 }, { 5, 5, 5, 5 }, { 6, 3, 6, 3 } };
        // int[][] mat={{1,2}};
        int k = 2;
        System.out.println(areSimilar(mat, k));
    }
}
