class Solution {
    public boolean divideArray(int[] arr) {
        if (arr.length%2!=0){
            return false;
        }
        
        Arrays.sort(arr);
        for (int i=0;i<arr.length;i=i+2){
            if (arr[i]!=arr[i+1]){
                return false;
            }
        }
        return true;
    }
}