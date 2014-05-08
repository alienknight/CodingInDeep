
public class RemoveDuplicates {
    public static int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length==0) return 0;
        int count = 0;
        for(int i=A.length-2;i>=0;i--)
        {
            if(A[i]==A[i+1])
            {
                for(int j=i;j<A.length-1;j++)
                {
                    A[j] = A[j+1];
                }
                count++;
            }
        }
        return A.length-count;
    }
    public static void main(String[] args){
    	int[] A = {1,2,2};
    	removeDuplicates(A);
    }
}

/*
public static int removeDuplicates(int[] A) {
// Start typing your Java solution below
// DO NOT write main() function
if(A.length<=1)
    return A.length;
int i=0, j=1;
for(;j<A.length;j++) {
    if(A[i]!=A[j])
        A[++i] = A[j];
}
return i+1;
}
*/