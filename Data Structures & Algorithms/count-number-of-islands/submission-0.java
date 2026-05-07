class Solution {
    public int numIslands(char[][] grid) {

        int l = grid.length;
        int m = grid[0].length;

        int islands = 0;
        int[][] neighs = {{0,1},{1,0},{0,-1},{-1,0}};
        
        for (int i = 0;i < l; i++) {

            for (int j = 0;j < m;j++) {

                if (grid[i][j] == '0') continue;

                grid[i][j] = '0';

                Stack<Integer> stk = new Stack<>();
                islands++;

                stk.push(i);
                stk.push(j);

                while(!stk.isEmpty()) {

                    int y = stk.pop();
                    int x = stk.pop();

                    for (int k = 0;k < 4;k++) {

                        int nx = x + neighs[k][0];
                        int ny = y + neighs[k][1];

                        if (nx >= 0 && ny >= 0 && nx < l && ny < m && grid[nx][ny] == '1') {

                            stk.push(nx);
                            stk.push(ny);

                            grid[nx][ny] = '0';
                        }
                    }
                    
                }
            }
        }

        return islands;
    }
}
