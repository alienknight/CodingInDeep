public class SetMatrixZero {
	public static void setZeroes(int[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function

		if (matrix.length == 0 || matrix[0].length == 0)
			return;
		String st = ".";
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					st = i+st+j;
				}
			}
		 //String a = String.valueOf((int)st).substring(1);
		 //String b =
		// String.valueOf(st-(int)st).substring(2,String.valueOf(st-(int)st).length()-1);
		// String s = String.valueOf(st);
		String[] s = String.valueOf(st).split("\\.");
		if(s.length==0)
				return ;
		String a = s[0];
		String b = s[1];
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[0].length; j++) {
				if (a.contains(String.valueOf(i))
						|| b.contains(String.valueOf(j)))
					matrix[i][j] = 0;
			}
	}

	public static void main(String[] args) {
		int[][] matrix = {{1}};
		setZeroes(matrix);
	}
}






/*
public static void setZeroes(int[][] matrix) {
    boolean firstCol = false;
     int m=matrix.length;
     int n=matrix[0].length;
     for(int i=0;i<m;i++){
         for(int j=0;j<n;j++){
             if(matrix[i][j]==0){
                 matrix[i][0]=0;
                 if(j!=0) matrix[0][j]=0;
                 else firstCol=true;
             }
         }
     }
     for(int i=1;i<m;i++){
         if(matrix[i][0]==0){
             for(int j=0;j<n;j++){
                 matrix[i][j]=0;
             }
         }
     }
     for(int j=1;j<n;j++){
         if(matrix[0][j]==0){
             for(int i=0;i<m;i++){
                 matrix[i][j]=0;
             }
         }
     }
     if(matrix[0][0]==0){
         for(int j=0;j<n;j++){
             matrix[0][j]=0;
         }
     }
     if(firstCol){
         for(int i=0;i<m;i++){
             matrix[i][0]=0;
         }
     }
	}*/