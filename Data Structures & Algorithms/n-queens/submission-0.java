class Solution {


    public List<List<String>> sol;
    private int[][] neighs = {{1,1}, {1,-1},{-1,1},{-1,-1}};

    public List<List<String>> solveNQueens(int n) {
        
        this.sol = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0;i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        recursive(board, 0);
        return sol;
    }

    public void recursive(char[][] board, int row) {

        if (row == board.length) {

           // StringBuilder builder = new StringBuilder();
            List<String> data = new ArrayList<>();

            for (char[] rowData : board) {

                data.add(new String(rowData));
            }

            sol.add(data);
            return;
        }

        for (int i = 0;i < board.length; i++) {

            if (check(board, row, i)) {

                board[row][i] = 'Q';
                recursive(board, row + 1);
                board[row][i] = '.';

            }
        }
    }

    public boolean check(char[][] board, int x, int y) {



        for (int i = 0; i < board.length; i++) {

            if (board[i][y] == 'Q' || board[x][i] == 'Q') return false;
        }

        for (int i = 0;i < 4;i++) {


            int nx = x + neighs[i][0];
            int ny = y + neighs[i][1];

            while(nx >= 0 && ny >= 0 && nx < board.length && ny < board.length) {

                if (board[nx][ny] == 'Q') return false;
                nx += neighs[i][0];
                ny += neighs[i][1];
            }
        }

        return true;

    }
}
