import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Nking {
	public static int nking(int n, int k, int[] pos) {
		// If all placed, return 1
		if (k == n)
			return 1;
		int[] res = new int[n];
		// Initialize rows already placed
		for (int i = 0; i < k; i++)
			res[i] = pos[i];
		// Initialize result as 0, and the start row is k
		int count = 0, row = k;
		// Initialize start position
		res[row] = -1;
		// rows placed cannot be changed
		while (row >= k) {
			// If not valid, advanced by 1 step to continue to check
			res[row] = res[row] + 1;
			// find a valid position
			while (res[row] < n && !valid(res, row))
				res[row]++;
			if (res[row] < n) { // valid
				if (row == n - 1) { // If the last row is placed, add result by
									// 1 and change last row to continue to
									// check
					count++;
					row--;
				} else { // Not last row, continue to check
					row++;
					res[row] = -1;
				}
			} else
				// invalid, return to last row to check
				row--;
		}
		return count;
	}

	// Check whether the location of king is valid
	public static boolean valid(int[] res, int k) {
		for (int i = 0; i < k; i++) {
			if (res[i] == res[k]
					|| (Math.abs(res[i] - res[k]) == Math.abs(i - k) && i == k - 1))
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int num = Integer.parseInt(line);
		for (int i = 0; i < num; i++) {
			String line1 = br.readLine();
			String line2 = br.readLine();
			int n = Character.getNumericValue(line1.charAt(0));
			int k = Character.getNumericValue(line1.charAt(2));
			int[] pos = new int[k];
			for (int j = 0, count = 0; j < k; j++, count += 2)
				pos[j] = Character.getNumericValue(line2.charAt(k));
			int res = nking(n, k, pos);
			System.out.println(res);
		}

	}
}
