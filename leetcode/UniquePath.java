
public class UniquePath {
    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(m<1 || n<1) return 0;
        int[][] a = new int[m+1][n+1];
        return helper(1,1,m,n,a);
    }
    public int helper(int r, int c, int m, int n, int[][] a) {
        if(r>m || c>n)
            return 0;
        if(r==m && c==n)
            return 1;
        if(a[r][c]!=0) return a[r][c];
        a[r][c] = helper(r+1,c,m,n,a)+helper(r,c+1,m,n,a);
        return a[r][c];
    }
}

/*
public int uniquePaths(int m, int n) {
// Start typing your Java solution below
// DO NOT write main() function
int[][] res = new int[m][n];
for(int i=0;i<m;i++)
    res[i][0] = 1;
for(int j=0;j<n;j++)
    res[0][j] = 1;
for(int i=1;i<m;i++)
    for(int j=1;j<n;j++) 
        res[i][j] = res[i-1][j] + res[i][j-1];
return res[m-1][n-1];
}
*/