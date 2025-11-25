/*Problem statement:
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
*/

/*Sample test cases: 
    Example 1:
    Input: prices = [7,1,5,3,6,4]
    Output: 5
    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
    
    Example 2:
    Input: prices = [7,6,4,3,1]
    Output: 0
*/

//TC-O(N), SC-O(1)

class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0; i<prices.length; i++){
            if(prices[i] > buy){
                int profit = prices[i] - buy;
                maxProfit = Math.max(profit, maxProfit);
            }else{
                buy = prices[i];
            }
        }
        return maxProfit; 
    }
}