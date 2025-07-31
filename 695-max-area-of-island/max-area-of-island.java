class Solution {
    int max = 0, width, height;

    public int maxAreaOfIsland(int[][] grid) {
        this.height = grid.length;
        this.width = grid[0].length;

        boolean[][] visited = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    max = Math.max(max, findMax(grid, i, j, visited));
                }
            }
        }

        return max;
    }

    public int findMax(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= height || j < 0 || j >= width || grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }

        visited[i][j] = true;
        int sum = 1;

        sum += findMax(grid, i - 1, j, visited); // Up
        sum += findMax(grid, i, j + 1, visited); // Right
        sum += findMax(grid, i + 1, j, visited); // Down
        sum += findMax(grid, i, j - 1, visited); // Left

        return sum;
    }
}