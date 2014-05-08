import java.io.*;

public class MergeSort {
	public static void mergesort(int n[]) {
		if (n == null)
			return;
		int[] m = n.clone();
		mergesort(n, m, 0, n.length-1);
	}

	public static void mergesort(int[] n, int[] m, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergesort(n, m, start, mid);
			mergesort(n, m, mid + 1, end);
			merge(n, m, start, mid, end);
		}
	}

	public static void merge(int[] n, int[] m, int start, int mid, int end) {
		int i = start, j = mid + 1, k = start;
		while (i <= mid && j <= end) {
			if (m[i] <= m[j])
				n[k++] = m[i++];
			else
				n[k++] = m[j++];
		}
		int remain = mid - i;
		for (int count = 0; count <= remain; count++)
			n[k + count] = m[i + count];
		for(int c=0;c<n.length;c++)
			m[c] = n[c];
	}

	public static void main(String[] args) {
		int[] n = { 1, 5, 7, 8, 4, 9, 23, 56, 43, 21 };
		mergesort(n);
		System.out.print(n);
	}
}
