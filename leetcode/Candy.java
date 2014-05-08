
public class Candy {
    public int candy(int[] ratings) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int len = ratings.length;
        int sum = len;
        int[] res = new int[len];
        for(int i=0, k=1;i<len;i++) {
            if(i>0 && ratings[i]>ratings[i-1])
                res[i] = Math.max(k++,res[i]);
            else
                k = 1;
        }
        
        for(int i=len-1,k=1;i>=0;i--) {
            if(i<len-1 && ratings[i]>ratings[i+1])
                res[i] = Math.max(k++,res[i]);
            else
                k = 1;
        }
        for(int i=0;i<len;i++)
            sum += res[i];
        return sum;
    }
}
