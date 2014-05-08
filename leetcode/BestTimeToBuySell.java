
public class BestTimeToBuySell {
 /*   public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(prices.length<=1)
            return 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<prices.length-1;i++)
            for(int j=i+1;j<prices.length;j++) {
                max = prices[j]-prices[i]>max ? prices[j]-prices[i] : max;
            }
        return max>0 ? max : 0;
    }
    */
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(prices.length<2)
            return 0;
        int pro = 0, min = prices[0];
        for(int i=1;i<prices.length;i++) {
            pro = Math.max(pro, prices[i]-min);
            min = Math.min(min,prices[i]);
        }
        return pro;
    }
}
