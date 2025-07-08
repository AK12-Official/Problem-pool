int maxProfit(int* prices, int pricesSize) {
    int min=prices[0];
    int max=0;
    for(int i=0;i<pricesSize;i++){
        max=(prices[i]-min)>max?(prices[i]-min):max;
        min=min<prices[i]?min:prices[i];
    }
    return max;
}

//逆天题解
//并非全局最小值
