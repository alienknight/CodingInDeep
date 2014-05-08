import java.util.ArrayList;

public class SpiralOrder {
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (matrix.length == 0 || matrix[0].length == 0)
			return new ArrayList<Integer>();
		return spiralOrder(matrix, matrix.length, matrix[0].length,
				new ArrayList<Integer>(), 0);
	}

	public ArrayList<Integer> spiralOrder(int[][] matrix, int m, int n,
			ArrayList<Integer> res, int k) {
		if (m == 0 || n == 0)
			return res;
		if (m == 1) {
			for (int i = k; i <= n + k - 1; i++)
				res.add(matrix[k][i]);
			return res;
		}
		if (n == 1) {
			for (int i = k; i <= m + k - 1; i++)
				res.add(matrix[i][k]);
			return res;
		}
		for (int j = k; j < n + k - 1; j++)
			res.add(matrix[k][j]);
		for (int i = k; i < m + k - 1; i++)
			res.add(matrix[i][n + k - 1]);
		for (int j = n + k - 1; j > k; j--)
			res.add(matrix[m + k - 1][j]);
		for (int i = m + k - 1; i > k; i--)
			res.add(matrix[i][k]);
		return spiralOrder(matrix, m - 2, n - 2, res, k + 1);
	}
	// public static ArrayList<Integer> spiralOrder(int[][] matrix) {
	// // Start typing your Java solution below
	// // DO NOT write main() function
	// ArrayList<Integer> result = new ArrayList<Integer>();
	// if(matrix.length==0 || matrix[0].length==0) return result;
	// helper(matrix,result,0);
	// return result;
	// }
	// public static void helper(int[][] matrix, ArrayList<Integer> result, int
	// count)
	// {
	// if(count>(matrix.length-1)/2) return ;
	// int m = matrix.length;
	// int n = matrix[0].length;
	// if(result.size()==m*n) return ;
	// for(int i=count;i<n-count;i++)
	// result.add(matrix[count][i]);
	// for(int i=count+1;i<m-count;i++)
	// result.add(matrix[i][n-count-1]);
	// for(int i=n-count-2;i>=count;i--)
	// if(m!=1)
	// {
	// if(result.size()==m*n) return ;
	// result.add(matrix[m-count-1][i]);
	// }
	// for(int i=m-count-2;i>count;i--)
	// if(n!=1)
	// {
	// if(result.size()==m*n) return ;
	// result.add(matrix[i][count]);
	// }
	// helper(matrix,result,count+1);
	// }
	// public static void main(String[] args) {
	// int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
	// spiralOrder(matrix);
	// }
}

/*
 * public ArrayList<Integer> spiralOrder(int[][] matrix) { // Start typing your
 * Java solution below // DO NOT write main() function ArrayList<Integer> result
 * = new ArrayList<Integer>(); if(matrix.length==0 || matrix[0].length==0)
 * return result; int m = matrix.length, n = matrix[0].length; int k = 0;
 * for(;m>=2&&n>=2;m-=2,n-=2) { for(int temp=0;temp<n-1;temp++)
 * result.add(matrix[k][k+temp]); for(int temp=0;temp<m-1;temp++)
 * result.add(matrix[k+temp][k+n-1]); for(int temp=n-1;temp>0;temp--)
 * result.add(matrix[k+m-1][k+temp]); for(int temp=m-1;temp>0;temp--)
 * result.add(matrix[k+temp][k]); k++; } if(m==1) for(int temp=0;temp<n;temp++)
 * result.add(matrix[k][k+temp]); else if(n==1) for(int temp=0;temp<m;temp++)
 * result.add(matrix[k+temp][k]); return result; }
 */

/*
 * void print_spiral(int mat[][N_MAX], int m, int n, int k) { if (m <= 0 || n <=
 * 0) return; if (m == 1) { for (int j = 0; j < n; j++) cout << mat[k][k+j] <<
 * " "; return; } if (n == 1) { for (int i = 0; i < m; i++) cout << mat[k+i][k]
 * << " "; return; } // print from top left for (int j = 0; j < n - 1; j++) cout
 * << mat[k][k+j] << " "; // print from top right for (int i = 0; i < m - 1;
 * i++) cout << mat[k+i][k+n-1] << " "; // print from bottom right for (int j =
 * 0; j < n - 1; j++) cout << mat[k+m-1][k+n-1-j] << " "; // print from bottom
 * left for (int i = 0; i < m - 1; i++) cout << mat[k+m-1-i][k] << " ";
 * 
 * print_spiral(mat, m-2, n-2, k+1); }
 * 
 * void print_spiral_helper(int mat[][N_MAX], int m, int n) { print_spiral(mat,
 * m, n, 0); }
 */
