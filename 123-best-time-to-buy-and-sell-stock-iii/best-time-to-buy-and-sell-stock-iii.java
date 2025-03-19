class Solution {
    public int maxProfit(int[] arr) {
        int n=arr.length;
        int[][][] dp=new int[n][2][3];

         for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return helper(0,1,2,arr,dp);
    }
    public static int helper(int ind, int buy, int gap, int[] arr, int[][][] dp){
        
        if (ind==arr.length){
            return 0;
        }
        if (gap==0){
            return 0;
        }
        if (dp[ind][buy][gap]!=-1){
            return dp[ind][buy][gap];
        }
        if (buy==1){
            dp[ind][buy][gap]=Math.max((-arr[ind]+helper(ind+1,0,gap,arr,dp)), helper(ind+1,1,gap,arr,dp));
        }else{
            dp[ind][buy][gap]=Math.max((arr[ind]+helper(ind+1,1,gap-1,arr,dp)), helper(ind+1,0,gap,arr,dp));
        }

        return dp[ind][buy][gap];
    }

}