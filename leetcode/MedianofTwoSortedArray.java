public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        if (A == null || B == null || A.length == 0 && B.length == 0)
            return 0.00;
        int m = A.length, n = B.length;
        if ((m + n) % 2 == 1) {
            return findMedianSortedArrays(A, 0, m, B, 0, n, (m + n) / 2 + 1);
        } else {
            return (findMedianSortedArrays(A, 0, m, B, 0, n, (m + n) / 2 + 1) + findMedianSortedArrays(A, 0, m, B, 0, n, (m + n) / 2)) / 2;
        }
    }
    
    public double findMedianSortedArrays(int A[], int startA, int endA, int B[], int startB, int endB, int k) {
        if (endA - startA > endB - startB)  return findMedianSortedArrays(B, startB, endB, A, startA, endA, k);
        else if(endA <= startA) return B[startB + k -1];
        else if(k==1) return Math.min(A[startA], B[startB]);
        
        int pa = Math.min(endA - startA, k / 2), pb = k - pa;
        if (A[startA + pa - 1] < B[startB + pb - 1])
            return findMedianSortedArrays(A, startA + pa, endA, B, startB, endB, k - pa);
        else if (A[startA + pa - 1] > B[startB + pb - 1])
            return findMedianSortedArrays(A, startA, endA, B, startB + pb, endB, k - pb);
        else
            return A[startA + pa -1];
    }
}





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
