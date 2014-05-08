
public class UniquePath2 {

public int uniquePathsWithObstacles(int[][] obstacleGrid) {

    int n = obstacleGrid.length;
    int m = obstacleGrid[0].length;
    int[] dp = new int[m + 1];

    if(obstacleGrid[0][0] != 1)
        dp[1] = 1;

    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            dp[j + 1] = obstacleGrid[i][j] == 1 ? 0 : dp[j + 1] + dp[j]; 
        }
    }

    return dp[m];
}


}

/*
public int uniquePathsWithObstacles(int[][] obstacleGrid) {
// Start typing your Java solution below
// DO NOT write main() function
int m = obstacleGrid.length;
int n = obstacleGrid[0].length;
int[][] res = new int[m+1][n+1];
for(int i=0;i<m;i++)
    res[i][0] = 0;
for(int j=0;j<n;j++)
    res[0][j] = 0;
res[0][1] = 1;
for(int i=1;i<=m;i++)
    for(int j=1;j<=n;j++) {
        if(obstacleGrid[i-1][j-1]==1) {
            res[i][j] = 0;
            continue;
        }
        res[i][j] = res[i-1][j] + res[i][j-1];
    }
return res[m][n];
}*/