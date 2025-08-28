class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        for (int d = 0; d < n; d++) {
            List<Integer> diagonal = new ArrayList<>();
            int i = d, j = 0;
            while (i < n && j < n) {
                diagonal.add(grid[i][j]);
                i++;
                j++;
            }
            Collections.sort(diagonal, Collections.reverseOrder());
            i = d;
            j = 0;
            int idx = 0;
            while (i < n && j < n) {
                grid[i][j] = diagonal.get(idx);
                i++;
                j++;
                idx++;
            }
        }
        for (int d = 1; d < n; d++) {
            List<Integer> diagonal = new ArrayList<>();
            int i = 0, j = d;
            while (i < n && j < n) {
                diagonal.add(grid[i][j]);
                i++;
                j++;
            }
            Collections.sort(diagonal);
            i = 0;
            j = d;
            int idx = 0;
            while (i < n && j < n) {
                grid[i][j] = diagonal.get(idx);
                i++;
                j++;
                idx++;
            }
        }
        return grid;
    }
}