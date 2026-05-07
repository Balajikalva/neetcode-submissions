class Solution {
    public boolean exist(char[][] board, String word) {

        if (word == null || word.length() == 0) return true;

        for (int i = 0;i < board.length; i++) {

            for (int j = 0;j < board[i].length; j++) {

                if (board[i][j] == word.charAt(0) && helper(board,i,j,word,0)) {
                    return true;
                }
            }
        } 

        return false;  
    }

    private boolean helper(char[][] board,int x, int y,String word, int ind) {

        // assumption is that we already have character match

        if (ind == word.length() - 1) {
            return true;
        }


        board[x][y] = '0';

        char ch = word.charAt(ind + 1);

        int[][] neighbors = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        for (int[] neigh : neighbors) {

            int nx = x + neigh[0];
            int ny = y + neigh[1];


            if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[nx].length || ch != board[nx][ny]) continue;

            if (helper(board, nx, ny, word, ind + 1)) return true;
        }

        board[x][y] = word.charAt(ind);
        return false;
    }
}
