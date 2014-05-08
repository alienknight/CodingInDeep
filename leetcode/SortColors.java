public class SortColors {


	public static void sortColors(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (A.length == 0)
			return;
		int n = A.length;
		int r = 0, w = 0, b = n - 1;
		for (; w <= b;) {
			if (A[w] == 0)
				swap(A, r++, w++);
			else if (A[w] == 2)
				swap(A, w, b--);
			else
				w++;
		}
		return;
	}

	public static void swap(int[] A, int a, int b) {
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;
	}

//	public static void main(String[] args) {
//		int[] A = { 0, 2, 1 };
//		sortColors(A);
//	}
}