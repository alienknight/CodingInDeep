import java.util.ArrayList;
import java.util.Arrays;

public class Nqueen {
	public ArrayList<String[]> solveNQueens(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String[]> result = new ArrayList<String[]>();
		int[] rec = new int[n];
		rec[0] = -1;
		int k = 0;
		while (k >= 0) {
			rec[k] = rec[k] + 1;
			while (rec[k] < n && !isValid(rec, k))
				rec[k] += 1;
			if (rec[k] < n) {
				if (k == n - 1) {
					createQ(rec, n, result);
					k = k - 1; // Important
				} else {
					k++;
					rec[k] = -1;
				}
			} else
				k--;
		}
		return result;
	}

	public void createQ(int[] rec, int n, ArrayList<String[]> result) {
		String[] s = new String[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j == rec[i])
					s[i] = j == 0 ? "Q" : s[i] + 'Q';
				else
					s[i] = j == 0 ? "." : s[i] + '.';
			}
		}
		result.add(s);
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
