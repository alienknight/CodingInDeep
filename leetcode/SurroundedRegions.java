
public class SurroundedRegions {
    public static void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(board.length<3 || board[0].length<3)
            return ;
        int m = board.length, n = board[0].length;
        for(int j=0;j<n;j++)
            if(board[0][j]=='O') {
                board[0][j] = 'a';
                helper(board,0,j);
            }
        for(int j=0;j<n;j++)
            if(board[m-1][j]=='O') {
                board[m-1][j] = 'a';
                helper(board,m-1,j);
            }
        for(int i=0;i<m;i++)
            if(board[i][0]=='O') {
                board[i][0] = 'a';
                helper(board,i,0);
            }
        for(int i=0;i<m;i++)
            if(board[i][n-1]=='O') {
                board[i][n-1] = 'a';
                helper(board,i,n-1);
            }
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++) {
                if(board[i][j]=='O')
                    board[i][j] = 'X';
                else if(board[i][j]=='a')
                    board[i][j] = 'O';
            }
    }
    public static void helper(char[][] board, int i, int j) {
        if(i>0 && board[i-1][j]=='O') {
            board[i-1][j] = 'a';
            helper(board,i-1,j);
        }
        if(i<board.length-1 && board[i+1][j]=='O') {
            board[i+1][j] = 'a';
            helper(board,i+1,j);
        }
        if(j>0 && board[i][j-1]=='O') {
            board[i][j-1] = 'a';
            helper(board,i,j-1);
        }
        if(j<board[0].length-1 && board[i][j+1]=='O') {
            board[i][j+1] = 'a';
            helper(board,i,j+1);
        }
    }
}

/*

First scan the four edges of the board, if you meet an 'O', call a recursive mark function to mark that region to something else (for example, '+');
scan all the board, if you meet an 'O', flip it to 'X';
scan again the board, if you meet an '+', flip it to 'O';

*/

/*
public void solve(char[][] board) {
if(board == null || board.length == 0) return;
int m = board.length, n = board[0].length;
for(int i = 0; i < n; i++) {bfs(0, i, board); bfs(m - 1, i, board);}
for(int j = 1; j < m- 1; j++) {bfs(j, 0, board); bfs(j, n - 1, board);}
for(int i = 0; i < n; i++)
    for(int j = 0; j < m; j++)
        if(board[i][j] == 'O') board[i][j] = 'X';
        else if(board[i][j] == '+') board[i][j] = 'O';
}
public void bfs(int i, int j, char[][] board){
Queue<Integer> q = new LinkedList<Integer>(); 
visit(i, j, q, board);
while(!q.isEmpty()){
    int cur = q.poll();
    int t = cur / board[0].length;
    int s = cur % board[0].length;
    visit(t - 1, s, q, board);
    visit(t, s - 1, q, board);
    visit(t + 1, s, q, board);
    visit(t, s + 1, q, board);
}
}
public void visit(int i, int j, Queue<Integer> q, char[][] board){
int m = board.length, n = board[0].length;
if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') return;
board[i][j] = '+';
q.offer(i * n + j);
}
*/