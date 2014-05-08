import java.util.Arrays;


public class BestTimeToBuySell3 {

    public static int maxProfit(int[] prices) {										
        // Start typing your Java solution below
        // DO NOT write main() function
        if(prices.length<2)
            return 0;
        int len = prices.length;
        int res = Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        int[] his = new int[len];
        int[] fut = new int[len];
        for(int i=0;i<len;i++) {
            min = prices[i]<min ? prices[i] : min;
            if(i>0)
                his[i] = Math.max(prices[i]-min, his[i-1]);
        }
        for(int i=len-1;i>=0;i--) {
            max = prices[i]>max ? prices[i] : max;
            if(i<len-1)
                fut[i] = Math.max(max-prices[i], fut[i+1]);
            res = Math.max(res,fut[i]+his[i]);
        }
        return res;
    }
	public static void main(String[] args) {
    	int[] prices = {1,2};
    	maxProfit(prices);
    }
}






/*
class Solution {
public:
    int maxProfit(vector<int> &prices) {
        int f[3] = {0};
        int g[3] = {0};

        int n = prices.size() - 1;
        for (int i = 0; i < n; ++i) {
            int diff = prices[i+1] - prices[i];
            int m = min(i+1, 2);
            for (int j = m; j >= 1; --j) {
                f[j] = max(f[j], g[j-1]) + diff;
                g[j] = max(g[j], f[j]);
            }
        }
        return max(g[1], g[2]);
    }
};
*/