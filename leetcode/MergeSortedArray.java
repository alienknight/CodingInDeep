
public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i = m-1, j = n-1, t = m+n-1;
        while(i>=0 && j>=0) {
            if(A[i]>B[j]) {
                A[t--]=A[i--];
            }
            else {
                A[t--]=B[j--];
            }
        }
        if(i<0) {
            while(j>=0) {
                A[j] = B[j];
                j--;
            }
        }
    }
}
