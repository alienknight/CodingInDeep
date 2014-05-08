
public class FirstMissingPositive {
    public static int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length==0) return 1;
        int i=0;
        int n=A.length;
        while(i<n)
        {
            if(A[i]!=i+1 && A[i]>=1 && A[i]<=n && A[i]!=A[A[i]-1])		//Important
            {
                int temp = A[i];
                A[i] = A[A[i]-1];
                A[temp-1] = temp;
            }
            else				//Important
                i++;
        }
        for(int j=0;j<n;j++)
        {
            if(A[j]!=j+1)
                return j+1;
        }
        return n+1;
    }
    public static void main(String[] args) {
    	int[] A = {0,1,2};
    	firstMissingPositive(A);
    }
}
