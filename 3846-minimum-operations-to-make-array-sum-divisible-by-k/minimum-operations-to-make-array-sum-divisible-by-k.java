class Solution {
    public int minOperations(int[] nums, int k) {
        int t=0;
        for (int i=0;i<nums.length;i++) {
            t+= nums[i];
        }
        int r=t%k;
        return r;
    }
}