/**
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 * <p>
 * Input: coins = [2], amount = 3
 * Output: -1
 */
public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        int leftAmount = amount;
        int coinsSum = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            int div = leftAmount / coins[i];
            coinsSum += div;
            leftAmount = leftAmount % coins[i];
        }
        return coinsSum == 0 ? -1 : leftAmount > 0 ? -1 : coinsSum;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(coinChange(coins, 11) + " == should be 3");
        int[] coins2 = {2};
        System.out.println(coinChange(coins2, 3) + " == should be -1");
        System.out.println(coinChange(coins2, 17) + " == should be -1");
        int[] coins3 = {1, 5, 10, 25, 50};
        System.out.println(coinChange(coins3, 17) + " == should be 4");
    }
}
