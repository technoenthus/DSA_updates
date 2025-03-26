class Solution {
    public int findTargetSumWays(int[] arr, int target) {
        int n=arr.length;
        int totSum = 0;
        for (int i = 0; i < n; i++) {
            totSum += arr[i];
        }
        if (totSum - target < 0 || (totSum - target) % 2 == 1)
            return 0;

        return findWays(arr, (totSum - target) / 2);
    }
    static int findWays(int[] num, int tar) {
        int n = num.length;

        int[][] dp = new int[n][tar + 1];

        if (num[0] == 0)
            dp[0][0] = 2; 
        else
            dp[0][0] = 1; 

        if (num[0] != 0 && num[0] <= tar)
            dp[0][num[0]] = 1;
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= tar; target++) {
                int notTaken = dp[ind - 1][target];
                int taken = 0;
                if (num[ind] <= target)
                    taken=dp[ind - 1][target - num[ind]];
                dp[ind][target]=(notTaken + taken);
            }
        }
        return dp[n - 1][tar];
    }
}