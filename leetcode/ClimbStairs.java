
public class ClimbStairs {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //if(n<=1) return n;
        int[] result = new int[n+1];
        return helper(n,result);
    }
    public int helper(int n, int[] result) {
        if(n<0)
            return 0;
        if(n<=2)
            return n;
        if(result[n]!=0) return result[n];
        else
            result[n] = helper(n-1,result) + helper(n-2,result);
        return result[n];
    }
}

/*
public int climbStairs(int n) {
	int[] res = new int[n+1];
	res[0] = 1;
	res[1] = 1;
	for(int i=2;i<=n;i++)
    	res[i] = res[i-1] + res[i-2];
	return res[n];
}*/