/* 
 * Given an m x n binary matrix mat, return the number of special positions in mat.

A position (i, j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0 (rows and columns are 0-indexed).

 

Example 1:


Input: mat = [[1,0,0],[0,0,1],[1,0,0]]
Output: 1
Explanation: (1, 2) is a special position because mat[1][2] == 1 and all other elements in row 1 and column 2 are 0.
Example 2:


Input: mat = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
Explanation: (0, 0), (1, 1) and (2, 2) are special positions.
 */
public class SpecialPosInBinaryMat {

    static int method1(int[][] mat) {
        int[] row = new int[mat.length];
        int[] col = new int[mat[0].length];
        int c = 0;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    row[i] += 1;
                    col[j] += 1;
                }
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1) {
                    c++;
                }
            }
        }

        return c;
    }

    static int method2(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] rowSum = new int[m];
        int[] colSum = new int[n];

        // Calculate row and column sums
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i] += mat[i][j];
                colSum[j] += mat[i][j];
            }
        }

        int specialPositions = 0;

        // Check each element for special position conditions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && rowSum[i] == 1 && colSum[j] == 1) {
                    specialPositions++;
                }
            }
        }

        return specialPositions;
    }

    static int method3(int[][] mat) {
        int specialPositions = 0;

        for (int row = 0; row < mat.length; row++) {
            int colIdx = checkRow(mat, row);
            if (colIdx != -1 && checkCol(mat, colIdx)) {
                specialPositions++;
            }
        }
        return specialPositions;
    }

    private static boolean checkCol(int[][] mat, int colIdx) {
        int c = 0;
        for (int row = 0; row < mat.length; row++) {
            if (mat[row][colIdx] == 1) {
                c++;
            }
        }
        return c == 1 ? true : false;
    }

    private static int checkRow(int[][] mat, int row) {
        int c = 0, colIdx = -1;
        for (int i = 0; i < mat[row].length; i++) {
            if (mat[row][i] == 1) {
                c++;
                colIdx = i;
            }
        }
        return c == 1 ? colIdx : -1;
    }

    static int numSpecial(int[][] mat) {
        return method3(mat);
    }

    public static void main(String[] args) {

        int[][] mat = {
                { 0, 0, 1, 0 }, // 1
                { 0, 0, 0, 0 }, // 0
                { 0, 0, 0, 0 }, // 0
                { 0, 1, 0, 0 } // 1
        };

        /*
         * r0:1
         * r1:0
         * r2:0
         * r3:1
         */

        System.out.println(numSpecial(mat));
    }
}
