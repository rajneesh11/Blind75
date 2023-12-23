/* 
 * Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing moving one unit north, south, east, or west, respectively. You start at the origin (0, 0) on a 2D plane and walk on the path specified by path.

Return true if the path crosses itself at any point, that is, if at any time you are on a location you have previously visited. Return false otherwise.

 

Example 1:
          _
         | |
    (0,0)@
Input: path = "NES"
Output: false 
Explanation: Notice that the path doesn't cross any point more than once.
Example 2:
           _
         _|_|
    (0,0)@
Input: path = "NESWW"
Output: true
Explanation: Notice that the path visits the origin twice.
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PathCrossing {
    static boolean isPathCrossing(String path) {
        int x = 0, y = 0;
        Set<String> pathSet = new HashSet<>();
        String points = "0,0";
        pathSet.add(points);

        for (char p : path.toCharArray()) {
            switch (p) {
                case 'N':
                    y++;
                    break;
                case 'E':
                    x++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'W':
                    x--;
                    break;
                default:
                    break;
            }
            points = getPointsStr(x, y);
            if (pathSet.contains(points)) {
                return true;
            }
            pathSet.add(points);
        }
        return false;
    }

    private static String getPointsStr(int x, int y) {
        StringBuilder sb = new StringBuilder();
        sb.append(x).append(",").append(y);
        return sb.toString();
    }

    public static void main(String[] args) {
        String path = "NESW";
        System.out.println(isPathCrossing(path));
    }
}
