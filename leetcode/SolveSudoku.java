public class SolveSudoku {
	public void solveSudoku(char[][] board) {
		// Start typing your Java solution below
		// DO NOT write main() function
		solve(board);
	}

	public boolean solve(char[][] board) {
		char[] record = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		int i = 0, j = 0;
		int label = 0;
		for (i = 0; i < 9; i++) {
			for (j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					label = 1;						//Important
					break;
				}
			}
			if (label == 1)
				break;
		}
		if (i == 9 && j == 9)
			return true;
		for (int k = 1; k < 10; k++) {
			board[i][j] = record[k];
			if (isValid(board, i, j) && solve(board))			//Important
				return true;
			board[i][j] = '.';
		}
		return false;
	}

	public boolean isValid(char[][] board, int i, int j) {
		for (int n = 0; n < 9; n++) {
			if (n != j) {
				if (board[i][j] == board[i][n])
					return false;
			}
		}
		for (int m = 0; m < 9; m++) {
			if (m != i) {
				if (board[i][j] == board[m][j])
					return false;
			}
		}
		int p = i % 3;
		int q = j % 3;
		for (int m = i - p; m < i + 3 - p; m++)
			for (int n = j - q; n < j + 3 - q; n++) {
				if (m != i && n != j) {
					if (board[i][j] == board[m][n])
						return false;
				}
			}
		return true;
	}
}
