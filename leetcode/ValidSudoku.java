import java.util.HashMap;


public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return isValidr(board) && isValidc(board) && isValidx(board,0,0);
    }
    public boolean isValidr(char[][] board) {
        for(int i=0;i<9;i++)
        {
            HashMap map = new HashMap();
            for(int j=0;j<9;j++)
            {
                if(map.containsKey(board[i][j]))
                    return false;
                else if(board[i][j]!='.')
                    map.put(board[i][j],true);
            }
        }
        return true;
    }
    public boolean isValidc(char[][] board) {
        for(int j=0;j<9;j++)
        {
            HashMap map = new HashMap();
            for(int i=0;i<9;i++)
            {
                if(map.containsKey(board[i][j]))
                    return false;
                else if(board[i][j]!='.')
                    map.put(board[i][j],true);
            }
        }
        return true;
    }
    public boolean isValidx(char[][] board,int i,int j) {
        if(i>6 || j>6) return true;
        HashMap map = new HashMap();
        for(int m=i;m<i+3;m++)
        {
            for(int n=j;n<j+3;n++)
            {
                if(map.containsKey(board[m][n]))
                    return false;
                else if(board[m][n]!='.')
                    map.put(board[m][n],true);
            }
        }
        return isValidx(board,i+3,j) && isValidx(board,i,j+3);
    }
}
