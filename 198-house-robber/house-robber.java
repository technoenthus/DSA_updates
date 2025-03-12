class Solution {
    public int rob(int[] arr) {
        int n = arr.length;
    if (n==0) return 0;
    if (n==1) return arr[0]; 

    int[] dp=new int[n];
    dp[0]=arr[0];
    dp[1]=Math.max(arr[0], arr[1]);

    for (int i=2;i<n;i++) {
        int pick=arr[i]+dp[i-2]; 
        int not_pick=dp[i-1]; 
        dp[i]=Math.max(pick, not_pick);
    }
    return dp[n-1];
    }
    
}