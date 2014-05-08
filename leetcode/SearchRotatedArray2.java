public class SearchRotatedArray2 {
																		//O(n) because of duplicates
    public boolean search(int[] A, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int start = 0, end = A.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(A[mid]==target) return true;
            if(A[mid] > A[start]) {
                if(target < A[mid] && target >= A[start]) end = mid - 1;
                else start = mid + 1;
            }
            else if(A[mid] < A[start]) {
                if(target > A[mid] && target <=A[end]) start = mid + 1;
                else end = mid - 1;
            }
            else
                start++;
        }
        return false;
    }
//	public boolean search(int[] A, int target) {
//		// Start typing your Java solution below
//		// DO NOT write main() function
//		if (A.length == 0)
//			return false;
//		return helper(A, target, 0, A.length - 1);
//	}
//
//	public boolean helper(int[] A, int target, int first, int last) {
//		if (first >= last && A[first] != target)
//			return false;
//		int median = (first + last) / 2;
//		if (A[median] == target)
//			return true;
//		if (A[first] < A[median]) {
//			if (target >= A[first] && target < A[median]) {
//				last = median - 1;
//			} else
//				first = median + 1;
//		} else if (A[first] > A[median]) {
//			if (target <= A[last] && target > A[median]) {
//				first = median + 1;
//			} else {
//				last = median - 1;
//			}
//		} else {
//			if (A[median] != A[last]) {
//				first = median + 1;
//				return helper(A, target, first, last);
//			} else {
//				boolean result = helper(A, target, median + 1, last);
//				if (result == true)
//					return result;
//				return helper(A, target, first, median - 1);
//			}
//		}
//		return helper(A, target, first, last);
//	}
}
