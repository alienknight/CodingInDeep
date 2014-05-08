
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(matrix.length==0 || matrix[0].length==0)
            return false;
        int row = helper1(matrix,target,0,matrix.length-1);
        return helper2(matrix,target,row,0,matrix[0].length-1);
    }
    public int helper1(int[][] matrix, int target, int start, int end) {
        if(end<=start) return start;
        int mid = (start+end)/2;
        if(matrix[mid][0]<=target && matrix[mid][matrix[0].length-1]>=target)
            return mid;
        else if(matrix[mid][matrix[0].length-1]<target)
            return helper1(matrix,target,mid+1,end);
        else
            return helper1(matrix,target,start,mid-1);
        
    }
    public boolean helper2(int[][] matrix, int target, int row, int start, int end) {
        if(start>end) return false;
        if(start==end) {
            if(target==matrix[row][start])
                return true;
            else
                return false;
        }
        int mid = (start+end)/2;
        if(matrix[row][mid]==target) return true;
        else if(matrix[row][mid]<target)
            return helper2(matrix,target,row,mid+1,end);
        else
            return helper2(matrix,target,row,start,mid-1);
    }
}

/*
public boolean searchMatrix(int[][] matrix, int target) {
// Start typing your Java solution below
// DO NOT write main() function
int m = matrix.length, n = matrix[0].length;
int low = 0, high = m*n -1;
while(low<=high) {
    int mid = (low + high)/2;
    if(matrix[mid/n][mid%n]==target)
        return true;
    else if(matrix[mid/n][mid%n]<target)
        low = mid + 1;
    else
        high = mid -1;
}
return false;
}
*/