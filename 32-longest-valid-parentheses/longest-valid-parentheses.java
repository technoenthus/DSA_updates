class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] stack = new int[n + 1]; 
        int high = -1;
        int maxLen = 0;
        stack[++high] = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack[++high] = i;
            } else {
                high--; 
                if (high == -1) {
                    stack[++high] = i;
                } else {
                    maxLen = Math.max(maxLen, i - stack[high]);
                }
            }
        }
        return maxLen;
    }
}