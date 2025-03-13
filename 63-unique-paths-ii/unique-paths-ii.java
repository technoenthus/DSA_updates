class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int[][] dp=new int[n][m];
        if (arr[0][0]==1) return 0;
        
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(n-1,m-1,dp,arr);
    }
    public static int helper(int i, int j, int[][] dp, int[][] arr){
        if (i==0 && j==0){
            return 1;
        }
        int n=arr.length;
        int m=arr[0].length;
        if (i<0 || j<0 || i>=n || j>=m || arr[i][j]==1){
            return 0;
        }
        if (dp[i][j]!=-1){
            return dp[i][j];
        }
        int up=helper(i-1, j, dp, arr);
        int left=helper(i,j-1,dp,arr);
        dp[i][j]=up+left;
        return dp[i][j];

    }
}