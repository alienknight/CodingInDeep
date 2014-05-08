
public class JumpGame {
    public static int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length==0 || A[0]==0) return 0;
        return helper(A,0,0);
    }
    public static int helper(int[] A, int count, int n) {
        if(count>=A.length-1) return n;
        int min = Integer.MAX_VALUE;
        for(int i=1;i<=A[count];i++)
        {
            int temp = helper(A,count+i,n+1);
            min = temp<min ? temp : min; 
        }
        return min;
    }
    public static void main(String[] args){
    	int[] A = {1,2};
    	jump(A);
    }
}
/*
public int jump(int[] A) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if(A.length==0 || A[0]==0) return 0;
    int step=0;
    int cur=0;
    int max=0;
    for(int i=0;i<A.length;i++)
    {
        if(i>max)
        {
            max = cur;
            step++;
        }
        cur = Math.max(cur,i+A[i]);
    }
    return step;
}
*/