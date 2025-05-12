class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] nums = new int[10];
        for(int num: digits){
            nums[num]++;
        }
        List<Integer> res = new ArrayList<>();
        for(int i=1; i<nums.length; i++){
            if(nums[i] == 0) continue;
            nums[i]--;
            for(int j=0; j<nums.length; j++){
                if(nums[j] == 0) continue;
                nums[j]--;
                for(int k=0; k<nums.length; k++){
                    if(nums[k] == 0) continue;
                    nums[k]--;
                    int num = i*100 + j*10 + k;
                    if(num % 2 == 0) res.add(num);
                    nums[k]++;
                }
                nums[j]++;
            }
            nums[i]++;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}