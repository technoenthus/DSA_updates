class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";

        String result = "1";

        for (int i = 2; i <= n; i++) {
            StringBuilder current = new StringBuilder();
            int count = 1;
            char prev = result.charAt(0);

            for (int j = 1; j < result.length(); j++) {
                char c = result.charAt(j);
                if (c == prev) {
                    count++;
                } else {
                    current.append(count).append(prev);
                    prev = c;
                    count = 1;
                }
            }
            current.append(count).append(prev); 
            result = current.toString();
        }
        return result;
    }
}