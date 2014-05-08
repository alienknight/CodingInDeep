
public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length==0) return 0;
        int count = 0;
        for(int i=A.length-1;i>=0;i--)
        {
            if(A[i]==elem)
            {
                for(int j=i;j<A.length-1;j++)
                    A[j] = A[j+1];
                count++;
            }
        }
        return A.length-count;
    }
}

/*
    public int removeElement(int[] A, int elem) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(A.length==0) return 0;
        int i = 0, count = 0;
        while(i<A.length-count) {
            if(A[i]==elem) {
                int temp = A[i];
                A[i] = A[A.length-count-1];
                A[A.length-count-1] = temp;
                ++count;
            }else
                i++;
        }
        return i;
    }
*/