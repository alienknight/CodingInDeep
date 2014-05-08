public class Nqueen2 {
	public int totalNQueens(int n) {
		int[] rec = new int[n];
		rec[0] = -1;
		int k = 0;
		int count = 0;
		while (k >= 0) {
			rec[k] = rec[k] + 1;
			while (rec[k] < n && !isValid(rec, k))
				rec[k] += 1;
			if (rec[k] < n) {
				if (k == n - 1) {
					count++;
					k = k - 1;
				} else {
					k++;
					rec[k] = -1;
				}
			} else
				k--;
		}
		return count;
	}

	public boolean isValid(int[] rec, int k) {
		for (int i = 0; i < k; i++) {
			if (rec[i] == rec[k]
					|| Math.abs(rec[i] - rec[k]) == Math.abs(i - k))
				return false;
		}
		return true;
	}
}
