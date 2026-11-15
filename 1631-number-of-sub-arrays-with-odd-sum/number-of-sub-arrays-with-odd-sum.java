class Solution {
    public int numOfSubarrays(int[] arr) {
        int n=arr.length;
        int ans=0;
        int odd=0;
        int even=0;
        long res=0;
        int mod=1000000007;
        for (int i=0;i<n;i++){
            res=(res+arr[i])%2;
            if (res==1){
                ans=(ans+even+1)%mod;
                odd++;
            }
            else{
                ans=(ans+odd)%mod;
                even++;
            }
        }
        return ans;
    }
}