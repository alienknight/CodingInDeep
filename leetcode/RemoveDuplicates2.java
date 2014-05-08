
public class RemoveDuplicates2 {
    public static int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length<=2)
            return A.length;
        int i=2, j=2;
        while(j<A.length) {
            if(A[j]==A[i-1] && A[j]==A[i-2])
                j++;
            else
                A[i++]=A[j++];
        }
        return i;
    }
    public static void main(String[] args) {
    	int[] a = {1,1,1,1,2,2};
    	removeDuplicates(a);
    }
}
