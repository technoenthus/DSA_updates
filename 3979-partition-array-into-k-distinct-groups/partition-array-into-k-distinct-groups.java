class Solution {
    public boolean partitionArray(int[] nums, int k) {
        if(nums.length%k !=0) return false;

        Map<Integer,Integer> map=new HashMap<>();
        int maxFreq=0;
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            maxFreq=Math.max(maxFreq,map.get(nums[i]));
        }

        return maxFreq <= (nums.length/k);     
    }
}