class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<=1){return 0;}//无法进行交易
    	int maxv=prices[prices.length-1];//max selling price
    	int maxp=0;//max profit
    	for(int i=prices.length-2;i>=0;i--){
    		if(maxp<maxv-prices[i]){maxp=maxv-prices[i];}
    		if(maxv<prices[i]){maxv=prices[i];}
    	}
    	return maxp;
    }
}