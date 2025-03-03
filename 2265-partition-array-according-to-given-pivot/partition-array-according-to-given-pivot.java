class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int left = 0, right = nums.length - 1;
        int ans[] = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < pivot) ans[left++] = nums[i];
            if(nums[nums.length -1 - i] > pivot) ans[right--] = nums[nums.length - 1 - i];
        }
        while(left <= right) {
            ans[right--] = pivot;
            ans[left++] = pivot;
        } 
        return ans;
    }
}