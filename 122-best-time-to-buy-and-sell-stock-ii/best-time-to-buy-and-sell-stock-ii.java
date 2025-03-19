class Solution {
    public int maxProfit(int[] arr) {
        int n=arr.length;
        int[][] dp=new int[n+1][2];
        int profit=0;
        dp[n-1][0]=0;
        dp[n-1][1]=0;
        for (int i=n-1;i>=0;i--){
            for (int buy=0;buy<=1;buy++){
            if (buy==1){
                profit=Math.max((-arr[i]+dp[i+1][0]), dp[i+1][1]);
            }
            else if (buy==0){
                profit=Math.max((arr[i]+dp[i+1][1]), dp[i+1][0]);
            }
            dp[i][buy]=profit;
        }}
        return dp[0][1];
    }
}