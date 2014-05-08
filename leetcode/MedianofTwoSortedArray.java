
public class MedianofTwoSortedArray {
	public double findMedianSortedArrays(int A[], int B[]) {
	    // Start typing your C/C++ solution below
	    // DO NOT write int main() function
		int m = A.length, n = B.length;
	    int total = m + n;
	    if (0 == total % 2) {
	        return (FindKth(A, m, B, n, total/2) + FindKth(A, m, B, n, total/2 + 1)) / 2;
	    } else {
	        return FindKth(A, m, B, n, total/2 + 1);
	    }
	}

	public double FindKth(int A[], int m, int B[], int n, int k) {
	    if (m > n) return FindKth(B, n, A, m, k);
	    if (0 == m) return B[k-1];
	    if (0 == n) return A[k-1];
	    if (1 == k) return Math.min(A[0], B[0]);

	    int aMid = Math.min(k/2, m);
	    int bMid = k - aMid;
	    if (A[aMid-1] < B[bMid-1]) {
	        return FindKth(A + aMid, m - aMid, B, n, k - aMid);
	    } else {
	        return FindKth(A, m, B + bMid, n - bMid, k - bMid);
	    }
	}
}
