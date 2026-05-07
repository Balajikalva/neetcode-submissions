class Solution {
    public int shortestPath(int[][] grid) {

        int sol =  helper(0,0, grid);
        return sol == Integer.MAX_VALUE ? -1 : sol;
    }

    private int helper(int x, int y, int[][] grid) {

        if (x < 0 || y < 0 || x >= grid.length || y >= grid[x].length || grid[x][y] == 1) {

            return Integer.MAX_VALUE;
        }

        if (x == grid.length - 1 && y == grid[x].length - 1) {
            return 0;
        }

        grid[x][y] = 1;

        int sol = Integer.MAX_VALUE;

        sol = Math.min(sol, helper(x + 1, y, grid));
        sol = Math.min(sol, helper(x - 1, y, grid));
        sol = Math.min(sol, helper(x, y + 1, grid));
        sol = Math.min(sol, helper(x, y - 1, grid));

        grid[x][y] = 0;

        return sol == Integer.MAX_VALUE ? sol : 1 + sol;
        
    }
}
