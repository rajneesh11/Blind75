/* 
 * An image smoother is a filter of the size 3 x 3 that can be applied to each cell of an image by rounding down the average of the cell and the eight surrounding cells (i.e., the average of the nine cells in the blue smoother). If one or more of the surrounding cells of a cell is not present, we do not consider it in the average (i.e., the average of the four cells in the red smoother).


Given an m x n integer matrix img representing the grayscale of an image, return the image after applying the smoother on each cell of it.

 

Example 1:


Input: img = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[0,0,0],[0,0,0],[0,0,0]]
Explanation:
For the points (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
For the points (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
For the point (1,1): floor(8/9) = floor(0.88888889) = 0
Example 2:


Input: img = [[100,200,100],[200,50,200],[100,200,100]]
Output: [[137,141,137],[141,138,141],[137,141,137]]
Explanation:
For the points (0,0), (0,2), (2,0), (2,2): floor((100+200+200+50)/4) = floor(137.5) = 137
For the points (0,1), (1,0), (1,2), (2,1): floor((200+200+50+200+100+100)/6) = floor(141.666667) = 141
For the point (1,1): floor((50+200+200+200+200+100+100+100+100)/9) = floor(138.888889) = 138
 */
public class ImageSoother {
    static int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] ans = new int[m][n];

        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         ans[i][j] = img[i][j];
        //     }
        // }

        for (int i = 0; i < m; i += 1) {
            for (int j = 0; j < n; j += 1) {
                // applyFilter(i, j, img, ans);
                ans[i][j] = sumOfNeighbor(i, j, img);
            }
        }

        return ans;
    }

    static void applyFilter(int row, int col, int[][] img, int[][] ans) {
        ans[row][col] = sumOfNeighbor(row, col, img);

        // for (int i = row; i < 3; i++) {
        // for (int j = col; j < 3; j++) {
        // ans[i][j] = sumOfNeighbor(i, j, img);
        // }
        // }
    }

    private static int sumOfNeighbor(int i, int j, int[][] img) {
        int sum = 0, count = 0;

        for (int a = i - 1; a <= i + 1; a++) {
            for (int b = j - 1; b <= j + 1; b++) {
                if (a >= 0 && a < img.length && b >= 0 && b < img[0].length) {
                    sum += img[a][b];
                    count++;
                }
            }
        }
        return Math.floorDiv(sum, count);
    }

    public static void main(String[] args) {

        int[][] img = {
                { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 } };
        // int[][] img = {
        // { 100, 200, 100 },
        // { 200, 50, 200 },
        // { 100, 200, 100 } };

        // int[][] img = {
        // { 2, 3, 4 },
        // { 5, 6, 7 },
        // { 8, 9, 10 },
        // { 11, 12, 13 },
        // { 14, 15, 16 } };
        int[][] ans = imageSmoother(img);

        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[i].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
