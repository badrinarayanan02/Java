// Lab 2 Program 2
// Maximum Profit a share trader can achieve based on stock prices within a day 

public class ShareTrader {
    private static int maxProfit; // Static variable used to store the maximum profit that can be obtained from the given stock prices

    // This method takes the array of integers 'prices' as input and returns an integer value which represents the maximum value that can be achieved


    public static int findMaxProfit(int[] prices) {
        int n = prices.length; // Finding the length of the prices array representing the no of stock prices given

        if (n < 2) {
            return 0; // Not enough prices to perform transactions
        }
        // Check if there are less than 2 prices in the array if so it is not possible to perform transactions

        // These variables represent the maximum profit at different stages of buying and selling stocks

        int maxProfitAfterFirstBuy = Integer.MIN_VALUE; // Smallest possible integer in java
        int maxProfitAfterSecondBuy = 0;
        int maxProfitAfterFirstSell = 0;
        int maxProfitAfterSecondSell = 0;

        // This for loop iterates through each price in the prices array and calculates the maximum profit after each stage of buying and selling

        for (int price : prices) {
            maxProfitAfterSecondSell = Math.max(maxProfitAfterSecondSell, maxProfitAfterSecondBuy + price);
            maxProfitAfterSecondBuy = Math.max(maxProfitAfterSecondBuy, maxProfitAfterFirstSell - price);
            maxProfitAfterFirstSell = Math.max(maxProfitAfterFirstSell, maxProfitAfterFirstBuy + price);
            maxProfitAfterFirstBuy = Math.max(maxProfitAfterFirstBuy, -price);
        }

        // Calculates the final maximum profit by comparing maximum profits achieved after the allowed transactions and returns the highest value among them
        maxProfit = Math.max(maxProfitAfterSecondSell, maxProfitAfterFirstSell);
        return maxProfit;
    }

    public static void main(String[] args) {
        
        // Test case
        int[] stockPrices = {10, 22, 5, 75, 65, 80};
        int maxProfit = findMaxProfit(stockPrices);
        System.out.println("Maximum profit: " + maxProfit);
        // For the array {10, 22, 5, 75, 65, 80} the maximum profit that this algorithm computes considering
        // atmost two transactions (Buy->Sell->Buy->Sell) is 87.
        // Buy at 10 and sell at 22 = 22-10 = 12
        // Buy at 5 and sell at 80 = 80-5 = 75
        // The total achievable profit is 75+12 = 87
    }
}
