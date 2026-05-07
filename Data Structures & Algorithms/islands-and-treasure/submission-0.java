class Solution {
    public void islandsAndTreasure(int[][] grid) {
        

        Queue<Integer> que = new LinkedList<>();
        int[][] neighs = {{0,1},{0,-1},{1,0},{-1,0}};

        for (int i = 0;i < grid.length;i++) {

            for (int j = 0;j < grid[i].length;j++) {

                if (grid[i][j] == 0) {

                    que.add(i);
                    que.add(j);
                }
            }
        }

        int level = 0;

        while(que.size() > 0) {

            int l = que.size() / 2;

            for (int i = 0;i < l;i++) {

                int x = que.remove();
                int y = que.remove();

                for (int j = 0; j < 4;j++) {

                    int nx = x + neighs[j][0];
                    int ny = y + neighs[j][1];

                    if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[nx].length && grid[nx][ny] == Integer.MAX_VALUE) {

                        grid[nx][ny] = level + 1;

                        que.add(nx);
                        que.add(ny);
                    }
                }
            }
            
            level++;
        }
    }
}
