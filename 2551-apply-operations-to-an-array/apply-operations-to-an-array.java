class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int ansIterator = 0;

        for (int i = 0; i < n - 1; ++i) {
            if (nums[i] > 0 && nums[i] == nums[i + 1]) {
                ans[ansIterator] = 2 * nums[i];
                nums[i + 1] = 0;
                ++ansIterator;
            } else if (nums[i] > 0) {
                ans[ansIterator] = nums[i];
                ++ansIterator;
            }
        }

        ans[ansIterator] = nums[n - 1];

        return ans;
    }
}