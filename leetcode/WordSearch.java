
public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(board.length==0 || board[0].length==0 || word.length()==0)
            return false;
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    boolean[][] tab = new boolean[m][n];
                    for(int p=0;p<tab.length;p++)
                        for(int q=0;q<tab[0].length;q++)
                            tab[p][q] = false;
                    if(helper(board,word,0,i,j,tab)==true)
                        return true;
                }
            }
        return false;
    }
    public static boolean helper(char[][] board, String word, int count, int m, int n, boolean[][] tab) {
        if(count==word.length())
            return true;
        if(m>=board.length || n>=board[0].length || m<0 || n<0 || tab[m][n]==true || board[m][n]!=word.charAt(count))
            return false;
        else  
        {
            tab[m][n]=true;
            return helper(board,word,count+1,m-1,n,tab) || helper(board,word,count+1,m,n-1,tab) || helper(board,word,count+1,m+1,n,tab) || helper(board,word,count+1,m,n+1,tab);        
        }
    }
    public static void main(String[] args) {
    	char[][] board = {{'a','a'}};
    	String word = "aaa";
    	System.out.print(exist(board, word));
    }
}
