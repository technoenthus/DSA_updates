class Solution {
    public int[] twoSum(int[] arr, int target) {
        int[] ans={-1,-1};
        int i=0;
       while(i<arr.length){
        int j=i+1;
        while(j<arr.length){
            if (arr[i]+arr[j]==target){
            return new int[]{i,j};

        }
        j++;
        }
        
    
        i++;
       }
    return ans;
    }
}