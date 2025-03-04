class Solution {
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 2) { // If the remainder is 2, return false
                return false;
            }
            n /= 3; // Reduce n by dividing it by 3
        }
        return true;
    }
}