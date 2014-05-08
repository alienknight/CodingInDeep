
public class PalindromePartitioning2 {
    public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s==null || s.length()<=1 || isPalindrome(s))
            return 0;
        return helper(s,1);
    }
    public int helper(String s, int count) {
        for(int i=1;i<=s.length();i++) {
            if(isPalindrome(s.substring(0,i)) && isPalindrome(s.substring(i)))
                return 1;
        }
        int min = Integer.MAX_VALUE;
        for(int i=1;i<=s.length();i++) {
            if(isPalindrome(s.substring(0,i))) {
                min = min > count+helper(s.substring(i),count) ? count+helper(s.substring(i),count) : min;
            }
        }
        return min;
    }
    public boolean isPalindrome(String s) {
        if(s.length()<=1)
            return true;
        for(int i=0;i<s.length()/2;i++) {
            if(s.charAt(i)!=s.charAt(s.length()-1-i))  
                return false;
        }
        return true;
    }
}

/*
public int minCut(String s) {
// Start typing your Java solution below
// DO NOT write main() function
if(s==null || s.length()<=1)
    return 0;
int len = s.length();
int[] dp = new int[len+1];
boolean[][] ispalin = new boolean[len][len];
for(int i=0;i<=len;i++)
    dp[i] = len-1-i;
for(int i=0;i<len;i++)
    for(int j=0;j<len;j++)
        ispalin[i][j] = false;
for(int i=len-1;i>=0;i--)
    for(int j=i;j<len;j++) {
        if(s.charAt(i)==s.charAt(j) && (j<=i+2 || ispalin[i+1][j-1])) {
            ispalin[i][j] = true;
            dp[i] = Math.min(dp[i], dp[j+1]+1);
        }
    }
return dp[0];
}*/