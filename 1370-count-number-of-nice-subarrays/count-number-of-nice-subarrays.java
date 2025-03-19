class Solution {
    public int numberOfSubarrays(int[] arr, int goal) {
        for (int i=0;i<arr.length;i++){
            if (arr[i]%2!=0){
                arr[i]=1;
            }else{
                arr[i]=0;
            }
        }

        int i=0;
        int j=0;
        int sum=0;
        int count=0;
        int freq=0;

        while(i<arr.length) {
            sum+=arr[i];
            if(arr[i]==1) {
                freq=0;
            }
            if(sum>goal) {
                sum-=arr[j];
                j++;
            }
            
            while(j<=i && sum==goal) {
                sum-=arr[j];
                j++;
                freq++;
            }
            count+=freq;
            i++;
        }
        return count;
    }
}