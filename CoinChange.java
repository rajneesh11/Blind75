/* 
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
 */
public class CoinChange {
    static int coinChange(int[] coins, int amount) {
        int[][] T = new int[coins.length][amount + 1];

        for (int c = 0; c < coins.length ; c++) {
            for (int a = 1; a <= amount; a++) {
                if (coins[c] > a) {
                    T[c][a] = T[c - 1][a];
                } else {
                    if (c == 0) {
                        T[c][a] = 1 + T[c][a - coins[c]];
                    } else
                        T[c][a] = Math.min(T[c - 1][a], 1 + T[c][a - coins[c]]);

                }
            }
        }
        return T[coins.length - 1][amount];
    }

    public static void main(String[] args) {
        int[] coins = { 1,2,5 };
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }
}
