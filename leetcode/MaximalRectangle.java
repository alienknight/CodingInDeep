import java.util.*;
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(matrix.length==0 || matrix[0].length==0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[] height = new int[n];
        int max = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(matrix[i][j]=='1')
                    height[j]++;
                else height[j] = 0;
            }
            Stack<Integer> stack = new Stack<Integer> ();
            int j = 0;
            while(j<=n) {
                if(stack.isEmpty() || height[stack.peek()]<= (j<n ? height[j] : 0))
                    stack.push(j++);
                else {
                    int h = stack.pop();
                    max = Math.max(max, height[h] * (stack.isEmpty() ? j : j-stack.peek()-1));
                }
            }
        }
        return max;
    }
//    public int maximalRectangle(char[][] matrix) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        if(matrix.length==0 || matrix[0].length==0)
//            return 0;
//        int m = matrix.length, n = matrix[0].length;
//        int max = 0;
//        for(int i=0;i<m;i++) {
//            for(int j=0;j<n;j++) {
//                int temp = area(matrix,i,j);
//                max = Math.max(max,temp);
//            }
//        }
//        return max;
//    }
//    public int area(char[][] matrix, int i, int j) {
//        int m = matrix.length, n = matrix[0].length;
//        int maxcol = n;
//        int max = 0;
//        for(int row=i;row<m;row++) {
//            if(matrix[row][j]=='0') break;
//            for(int col=j;col<maxcol;col++) {
//                if(matrix[row][col]=='0') {
//                    maxcol = col;
//                    break;
//                }
//            }
//            int temp = (maxcol-j) * (row-i+1);
//            max = Math.max(max,temp);
//        }
//        return max;
//    }
//    public static void main(String[] args) {
//    	char[][] a = {{'1','0'}};
//    	System.out.print(maximalRectangle(a));
//    }
}
