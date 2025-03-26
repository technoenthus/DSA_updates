class Solution {
    public boolean canPartition(int[] arr) {
        int sum=0;
        for (int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        if (sum%2!=0){
            return false;
        }
        int[][] dp=new int[arr.length][sum/2 + 1];
        for (int[] row:dp){
            Arrays.fill(row,-1);
        }
        return helper(arr, arr.length-1,sum/2,dp);

    }
    public static boolean helper(int[] arr,int ind,int tar,int[][] dp){
        if (tar==0){
            return true;
        }
        if (ind==0){
            return (tar==arr[0]);
        }
        if (dp[ind][tar]!=-1){
            return dp[ind][tar]==0?false:true;
        }
        boolean nottake=helper(arr,ind-1,tar,dp);
        boolean take=false;
        if (tar>=arr[ind]){
            take=helper(arr,ind-1,tar-arr[ind],dp);
        }
        dp[ind][tar]=take || nottake ?1:0;
        return take || nottake;
    }
}