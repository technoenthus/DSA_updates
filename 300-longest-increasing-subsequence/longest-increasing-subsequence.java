class Solution {
    public int lengthOfLIS(int[] arr) {
        int n=arr.length;
        int[][] dp=new int[n+1][n+1];
        for (int[] row:dp){
            Arrays.fill(row,-1);
        }
        return helper(0,-1,arr,dp);
    }
    public static int helper(int ind, int prev, int[] arr, int[][] dp){
        if (ind==arr.length){
            return 0;
        }
        int len=0;
        if (dp[ind][prev+1]!=-1){
            return dp[ind][prev+1];
        }
        len=0+helper(ind+1,prev,arr,dp);

        if (prev==-1 || arr[ind]>arr[prev]){
            len=Math.max(len, 1+helper(ind+1,ind,arr,dp));
        }
        dp[ind][prev+1]=len;
        return dp[ind][prev+1];
    }
}