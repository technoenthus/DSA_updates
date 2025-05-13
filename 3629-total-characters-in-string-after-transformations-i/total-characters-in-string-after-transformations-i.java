import java.util.HashMap;

class Solution {
    private static final int MOD = 1000000007;

    public int lengthAfterTransformations(String s, int t) {
        HashMap<String, Integer> cache = new HashMap<>();
        return helper(s, t, cache) % MOD;
    }

    private int helper(String s, int t, HashMap<String, Integer> cache) {
        String key = t + ":" + s;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        int ans = 0;
        for (char c : s.toCharArray()) {
            if (c + t <= 'z') {
                ans++;
            } else {
                int newT = t - ('z' + 1 - c);
                ans += helper("ab", newT, cache);
                ans %= MOD;
            }
        }

        cache.put(key, ans % MOD);
        return ans;
    }
}