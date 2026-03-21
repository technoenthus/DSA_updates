class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int ky = k+y;
        int kx = k+x;
        if (x + k > m || y + k > n) {
            return grid; 
        }
        for(int i=y;i<ky;i++){
            int x1=x,x2 = x+k-1;
            while(x1<x2){
                int temp = grid[x1][i];
                grid[x1][i] = grid[x2][i];
                grid[x2][i] = temp;
                x1++;
                x2--;
            }
        }
        return grid;
    }
}