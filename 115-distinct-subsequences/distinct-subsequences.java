class Solution {
    public int numDistinct(String s1, String s2) {
        int lt=s1.length();
        int ls=s2.length();
        int dp[][] = new int[lt][ls];
        for (int rows[] : dp)
            Arrays.fill(rows, -1);

        return countUtil(s1, s2, lt - 1, ls - 1, dp);
    }
    static int countUtil(String s1, String s2, int ind1, int ind2, int[][] dp) {
        if (ind2 < 0)
            return 1;
        if (ind1 < 0)
            return 0;

        if (dp[ind1][ind2] != -1)
            return dp[ind1][ind2];

        if (s1.charAt(ind1) == s2.charAt(ind2)) {
            int leaveOne = countUtil(s1, s2, ind1 - 1, ind2 - 1, dp);
            int stay = countUtil(s1, s2, ind1 - 1, ind2, dp);

            return dp[ind1][ind2] = (leaveOne + stay);
        } else { return dp[ind1][ind2] = countUtil(s1, s2, ind1 - 1, ind2, dp);
        }
    }
}