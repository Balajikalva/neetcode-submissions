class Solution {
    public int countPaths(int[][] grid) {

        return helper(0,0,grid);
    }

    public int helper(int x, int y, int[][] grid) {

        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 1) {
            return 0;
        }

        if (x == grid.length - 1 && y == grid[0].length - 1) {
            return 1;
        }

        grid[x][y] = 1;

        int count = 0;

        count += helper(x + 1, y, grid);
        count += helper(x - 1, y, grid);
        count += helper(x, y + 1, grid);
        count += helper(x, y - 1, grid);

        grid[x][y] = 0;

        return count;

    }
}
