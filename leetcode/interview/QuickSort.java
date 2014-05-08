import java.io.*;
public class QuickSort {
	public static void quicksort(int[] n) {
		if(n==null) return ;
		quicksort(n,0,n.length-1);
	}
	public static void quicksort(int[] n, int start, int end) {
		if(start<end) {
			int pivot = partition(n,start,end);
			quicksort(n,start,pivot-1);
			quicksort(n,pivot+1,end);
		}
	}
	public static int partition(int[] n, int start, int end) {
		int pivot = n[start];
		while(start<end) {
			while(start<end && n[end]>=pivot) end--;
				n[start] = n[end];
			while(start<end && n[start]<=pivot) start++;
				n[end] = n[start];
		}
		n[start] = pivot;
		return start;
	}
	public static void main(String[] args) {
		int[] n = { 1, 5, 7, 8, 4, 9, 23, 56, 43, 21 };
		quicksort(n);
		System.out.print(n);
	}
}
