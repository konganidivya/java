import java.util.Arrays;

public class GreedyCoinChange {
    public static void findMinCoins(int[] coins, int amount) {
        // Sort coins in descending order
        Arrays.sort(coins);
        int n = coins.length;

        System.out.println("Coins used to make change for " + amount + ":");

        for (int i = n - 1; i >= 0; i--) {
            while (amount >= coins[i]) {
                amount -= coins[i];
                System.out.print(coins[i] + " ");
            }
        }

        if (amount > 0) {
            System.out.println("\nCannot make exact change with given denominations.");
        } else {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] coins = {1, 5, 10, 25};
        int amount = 63;
        findMinCoins(coins, amount);
    }
}
