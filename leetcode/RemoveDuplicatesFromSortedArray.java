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