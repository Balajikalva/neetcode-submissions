class Solution {

    int[][] neighs = {{0,1},{1,0},{0,-1},{-1,0}};

    public int maxAreaOfIsland(int[][] grid) {
        
        int max = 0;

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0;j < grid[i].length; j++) {

                if (grid[i][j] == 0) continue;

                max = Math.max(max, dfs(grid, i, j));
            }
        }

        return max;
    }

    public int dfs(int[][] grid, int x, int y) {

        if (x < 0 || y < 0 || x >= grid.length || y >= grid[x].length || grid[x][y] == 0) {

            return 0;
        }

        grid[x][y] = 0;

        int count = 0;

        for (int i = 0; i < 4;i++) {
            
            int nx = x + neighs[i][0];
            int ny = y + neighs[i][1];

            count += dfs(grid, nx, ny);
        }

        return 1 + count;

    }
}
