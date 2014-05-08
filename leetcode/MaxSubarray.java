
public class MaxSubarray {
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = A.length;
        boolean judge = false;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            max = A[i]>max?A[i]:max;
            if(A[i]>0)
                judge = true;
        }
        if(judge==false)
            return max;
        int maxsum=0, sum=0;
        for(int j=0;j<n;j++)
        {
            sum+=A[j];
            if(maxsum<sum)
                maxsum = sum;
            else if(sum<0)
                sum=0;
        }
        return maxsum;
    }
}

/*
public int maxSubArray(int[] A) {
// Start typing your Java solution below
// DO NOT write main() function
int max=A[0], sum=0;
for(int i=0;i<A.length;i++)
{
    sum = Math.max(sum+A[i],A[i]);
    max = Math.max(max, sum);
}
return max;
}*/