class Solution {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }
    public int maxLength(int[] nums) {
        int n = nums.length;
        int maxLength = 0;

        for (int start = 0; start < n; start++) {
            int product = 1;
            int currentGCD = nums[start];
            int currentLCM = nums[start];

            for (int end = start; end < n; end++) {
                product *= nums[end];

                currentGCD = gcd(currentGCD, nums[end]);

                currentLCM = lcm(currentLCM, nums[end]);

                if (product == currentGCD * currentLCM) {
                    maxLength = Math.max(maxLength, end - start + 1);
                }
            }
        }

        return maxLength;
    }
}