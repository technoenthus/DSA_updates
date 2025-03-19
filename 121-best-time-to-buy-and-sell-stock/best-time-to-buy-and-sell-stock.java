class Solution {
    public int maxProfit(int[] arr) {
        int mini=arr[0];
        int profit=0;
        for (int i=1;i<arr.length;i++){
            int net=arr[i]-mini;
            profit=Math.max(net,profit);
            mini=Math.min(arr[i],mini);

        }
        return profit;
    }
}