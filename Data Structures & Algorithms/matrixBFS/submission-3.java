class Solution {
    public int shortestPath(int[][] grid) {

        Queue<Integer> que = new LinkedList<>();

        int[][] neighs = {{0,1},{0,-1},{1,0},{-1,0}};

        que.add(0);
        que.add(0);
        que.add(0);

        grid[0][0] = 1;

        while(que.size() > 0) {

            int x = que.remove();
            int y = que.remove();
            int s = que.remove();

            if (x == grid.length - 1 && y == grid[x].length - 1) {
                return s;
            }

            for (int i = 0;i < 4; i++) {

                int nx = x + neighs[i][0];
                int ny = y + neighs[i][1];

                if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[x].length || grid[nx][ny] == 1) continue;

                que.add(nx);
                que.add(ny);
                que.add(s + 1);

                grid[nx][ny] = 1;
            }

        }

        return -1;
    }
}
