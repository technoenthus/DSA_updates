class Solution {
    public int maximumCount(int[] arr) {
        int neg=0;
        int n=arr.length;
        int pos=0;
        for (int i=0;i<n;i++){
            if (arr[i]<0){
                neg++;
            }else if (arr[i]>0){
                pos++;
            }
        }
        return Math.max(pos,neg);
    }
}