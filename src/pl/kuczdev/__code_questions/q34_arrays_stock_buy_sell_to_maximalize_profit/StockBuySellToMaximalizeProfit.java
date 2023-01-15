package pl.kuczdev.__code_questions.q34_arrays_stock_buy_sell_to_maximalize_profit;
/*
Given an array of integers representing stock price on a single day, find max profit that can be earned by 1 transaction.
So you need to find a pair (buyDay,sellDay) where buyDay < = sellDay and it should maximize the profit.
For example:
    int arr[]={14, 12, 70, 15, 99, 65, 21, 90};
    Max profit can be gain by buying on 1st day(0 based indexing) and sell on the 4th day.
    Max profit = 99-12 =87


Algorithm:
    Lets say we have array arr[] of stock prices.
    We will track two variables: lowestPriceTillThatDay and maxProfit.

        * lowestPriceTillThatDay will be initialise to arr[0].
        * Iterate over stock price array arr[]
        * If current element is greater than lowestPriceTillThatDay
            ** calculate profit.
            ** If profit is greater than maxProfit then update the maxProfit.

        * If current element is lesser than lowestPriceTillThatDay
            ** update lowestPriceTillThatDay with current element.

        * We will get maxProfit in the end.
 */
public class StockBuySellToMaximalizeProfit {
    public static void main(String[] args) {
        int arr[] = {14, 12, 70, 15, 99, 65, 21, 90};
        maximalizeProfit(arr);
        System.out.println("--------");
        System.out.println("Max profit: " + calculateMaxProfitByBlog(arr));
    }

    private static int findIndexOfMinimalValueInIntArray(int[] arr) {
        int minValueIndex = 0;
        int temp = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < temp) {
                minValueIndex = i;
                temp = arr[i];
            }
        }
        return minValueIndex;
    }

    private static int findIndexOfMaximumValueInIntArray(int[] arr) {
        int maxValueIndex = arr[0];
        int temp = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > temp) {
                maxValueIndex = i;
                temp = arr[i];
            }
        }
        return maxValueIndex;
    }

    private static void maximalizeProfit(int[] arr) {
        int cheapestDay = findIndexOfMinimalValueInIntArray(arr);
        int mostExpensiveDay = findIndexOfMaximumValueInIntArray(arr);
        System.out.println("Max profit can be gain by buying on: " + cheapestDay + " day (0 based indexing) and sell on: " + mostExpensiveDay + " day.");
    }


    private static int calculateMaxProfitByBlog(int[] arr) {
        int lowestPriceTillThatDay = arr[0];
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int profit = 0;
            if (arr[i] > lowestPriceTillThatDay) {
                profit = arr[i] - lowestPriceTillThatDay;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            } else {
                lowestPriceTillThatDay = arr[i];
            }
        }
        return maxProfit;
    }

}
