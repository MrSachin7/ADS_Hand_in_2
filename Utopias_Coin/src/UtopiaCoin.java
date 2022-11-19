import java.util.HashMap;

public class UtopiaCoin {


    private final int[] coins = {0, 1, 7, 10, 22};
    private final int length = coins.length;

    private final HashMap<Integer, Integer> minCoinValues = new HashMap<>();


    public int findMinimumCoinsToValue(int value) {
        // To store the min coins for i value
        minCoinValues.put(0, 0);


        // Initialize the table
        for (int i = 1; i <= value; i++) {
            minCoinValues.put(i, Integer.MAX_VALUE);
        }


        // We need to find out the min coins req for
        // all values less than the provided value
        for (int i = 1; i <= value; i++) {

            // iterate through all coins smaller than i
            for (int j = 0; j < length; j++) {
                if (coins[j] <= i) {

                    Integer sub = minCoinValues.get(i - coins[j]);
                    if (sub != Integer.MAX_VALUE && sub + 1 < minCoinValues.get(i)) {
                        minCoinValues.put(i, sub + 1);
                    }


                }

            }

        }

        if (minCoinValues.get(value) == Integer.MAX_VALUE) {
            return -1;
        }
        return minCoinValues.get(value);


    }

    public static void main(String[] args) {
        UtopiaCoin coin = new UtopiaCoin();

        System.out.println(coin.findMinimumCoinsToValue(145));
    }


}
