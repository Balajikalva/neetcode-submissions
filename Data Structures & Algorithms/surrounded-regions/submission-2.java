class Solution {
    public void solve(char[][] board) {

        Queue<Integer> que = new LinkedList<>();

        int l = board.length;
        int m = board[0].length;
        int[][] neighs = {{0,1},{0,-1},{1,0},{-1,0}};

        boolean[][] seen = new boolean[l][m];
        
        for (int i = 0;i < m; i++) {

            if (board[0][i] == 'O') {
                que.add(0);
                que.add(i);
                seen[0][i] = true;
            }

            if (board[l-1][i] == 'O') {
                que.add(l-1);
                que.add(i);
                seen[l-1][i] = true;
            }
        }

        for (int i = 0;i < l;i++) {

            if (board[i][0] == 'O' && !seen[i][0]) {
                que.add(i);
                que.add(0);
                seen[i][0] = true;
            }

            if (board[i][m-1] == 'O' && !seen[i][m-1]) {
                que.add(i);
                que.add(m-1);
                seen[i][m-1] = true;
            }
        }

        while(que.size() > 0) {

            int x = que.remove();
            int y = que.remove();

            for (int i = 0;i < 4;i++) {

                int nx = x + neighs[i][0];
                int ny = y + neighs[i][1];

                if (nx < 0 || ny < 0 || nx >= l || ny >= m || seen[nx][ny] || board[nx][ny] == 'X') continue;

                seen[nx][ny] = true;
                
                que.add(nx);
                que.add(ny);
            }
        }

        for (int i = 0;i < l;i++) {

            for (int j = 0;j < m;j++) {

                if (seen[i][j] == false && board[i][j] == 'O') {

                    board[i][j] = 'X';
                }
            }
        }
    }
}
