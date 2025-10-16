
class Solution {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        int preLowest = prices[0];
        int maxProfit=0;
        for (int i = 0; i < len; i++) {
            maxProfit=maxProfit>prices[i]-preLowest?maxProfit:prices[i]-preLowest;
            if(prices[i]<preLowest){
                preLowest=prices[i];
            }
        }
        return maxProfit;
    }
}
//我操了xdm JVM调优真他妈牛逼昂