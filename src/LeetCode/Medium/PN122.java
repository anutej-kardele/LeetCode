package LeetCode.Medium;

public class PN122 {

    public static void main(String[] args) {
        // int[] prices = { 7, 1, 5, 3, 6, 4 };
        int[] prices = { 1, 2, 3, 4, 5 };
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {

        int profit = 0;
        int boughtPrice = 0;
        boolean isBought = false;

        for (int i = 0; i < prices.length; i++) {

            int currentPrice = prices[i];

            if (isBought) {

                int sellPrice = currentPrice - boughtPrice;
                if (prices.length - 1 == i) {
                    profit += sellPrice;
                    continue;
                }
                int futurePrice = prices[i + 1];

                if (futurePrice < currentPrice) {
                    isBought = false;
                    profit += sellPrice;
                }
            } else {

                if (prices.length - 1 == i)
                    continue;
                int futurePrice = prices[i + 1];

                // future low then ignore
                if (futurePrice < currentPrice)
                    continue;
                else { // future high then buy
                    isBought = true;
                    boughtPrice = currentPrice;
                }
            }
        }

        return profit;
    }
}
