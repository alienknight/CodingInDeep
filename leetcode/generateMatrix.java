
public class generateMatrix {
    public int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] result = new int[n][n];
        helper(result,n,0,1,n);
        return result;
    }
    public void helper(int[][] result, int n, int k, int num, int length) {
        if(n<=0) return;
        if(n==1) 
        {
            result[length/2][length/2]=num;
            return ;
        }
        for(int i=0;i<n-1;i++)
            result[k][k+i] = num++;
        for(int i=0;i<n-1;i++)
            result[k+i][n-1+k] = num++;
        for(int i=0;i<n-1;i++)
            result[n-1+k][n-1-i+k] = num++;
        for(int i=0;i<n-1;i++)
            result[n-1-i+k][k] = num++;
        helper(result,n-2,k+1,num,length);
    }
}
