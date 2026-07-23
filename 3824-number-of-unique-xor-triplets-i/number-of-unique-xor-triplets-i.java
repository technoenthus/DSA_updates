class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;

        // Handle small input cases
        if (n==1) return 1;
        if (n==2) return 2;

        // Find the maximum bit length less than or equal to n
        int bits=0;
        while ((1<<(bits+1))<=n) {
            bits++;
        }

        return 1<<(bits+1);
    }
}