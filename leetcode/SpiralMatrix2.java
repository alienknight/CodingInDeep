    public int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] result = new int[n][n];
        if(n==0)
            return result;
        helper(result,n,0,1);
        return result;
    }
    public void helper(int[][] result, int n, int k, int count) {
        if(n<=0)
            return ;
        if(n==1) {
            result[result.length/2][result.length/2] = count;
            return ;
        }
        for(int j=0;j<n-1;j++) 
            result[k][j+k] = count++;
        for(int i=0;i<n-1;i++)
            result[i+k][n-1+k] = count++;
        for(int j=n-1;j>0;j--)
            result[n-1+k][j+k] = count++;
        for(int i=n-1;i>0;i--)
            result[i+k][k] = count++;
        helper(result,n-2,k+1,count);
    }