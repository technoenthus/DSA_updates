class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int sum = 0;
        int l=0,r=0;
        int n = nums.length;
        int sign = nums[0]>=0?1:-1;
        int ans =0;
        while(r<n){
            sum+=nums[r];
            if(sum*sign<0){
                int bl = l;
                int temp_sum = sum;
                while(l<r){
                    sum-=nums[l];
                    if(Math.abs(sum)>Math.abs(temp_sum)){
                        bl = l+1;
                        temp_sum = sum;
                    }
                    l++;
                }
                sum = temp_sum;
                l = bl;
                sign*=-1;
            }
            ans = Math.max(ans,Math.abs(sum)); 
            r++;
        }
        return ans;
    }
}