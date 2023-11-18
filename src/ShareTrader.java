// Program 2
public class ShareTrader {
    private static int maxProfit; // Static variable to store the maximum profit

    // Static method to calculate the maximum profit
    public static int findMaxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0; // Not enough prices to perform transactions
        }

        int maxProfitAfterFirstBuy = Integer.MIN_VALUE;
        int maxProfitAfterSecondBuy = 0;
        int maxProfitAfterFirstSell = 0;
        int maxProfitAfterSecondSell = 0;

        for (int price : prices) {
            maxProfitAfterSecondSell = Math.max(maxProfitAfterSecondSell, maxProfitAfterSecondBuy + price);
            maxProfitAfterSecondBuy = Math.max(maxProfitAfterSecondBuy, maxProfitAfterFirstSell - price);
            maxProfitAfterFirstSell = Math.max(maxProfitAfterFirstSell, maxProfitAfterFirstBuy + price);
            maxProfitAfterFirstBuy = Math.max(maxProfitAfterFirstBuy, -price);
        }

        maxProfit = Math.max(maxProfitAfterSecondSell, maxProfitAfterFirstSell);
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] stockPrices = {10, 22, 5, 75, 65, 80};
        int maxProfit = findMaxProfit(stockPrices);
        System.out.println("Maximum profit: " + maxProfit);
    }
}
