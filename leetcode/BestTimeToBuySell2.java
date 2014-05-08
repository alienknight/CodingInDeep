
public class BestTimeToBuySell2 {
    public static int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(prices.length<2)
            return 0;
        int pro = 0;
        int min = -1, max = -1;
        for(int i=0;i<prices.length;i++) {
            if(i<prices.length-1 && prices[i]<prices[i+1]) {
                if(i==0 || prices[i]<=prices[i-1])
                    min = prices[i];
            }
            if(i>0 && prices[i]>prices[i-1]) {
                if(i==prices.length-1 || prices[i]>=prices[i+1])
                    max = prices[i];
            }
            if(min!=-1 && max!=-1) {
                pro += max - min;
                max = -1;
                min = -1;
            }
        }
        return pro;
    }
    public static void main(String[] args) {
    	int[] prices = {2,1,2,0,1};
    	System.out.print(maxProfit(prices));
    }
}

/*
 * 

class Solution {
public:
    int maxProfit(vector<int> &prices) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int p = 0;
        for(int i = 1; i < prices.size() ; ++i) {
            int delta = prices[i] - prices[i-1];
            if(delta > 0 ) {
                p += delta;
            }
        }
        return p;
    }
};

*/
