class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int n=g.length;
        int m=s.length;
        if (m==0 || n==0)return 0;
        int l=0;
        int r=0;
        while(r<m && l<n){
            if (g[l]<=s[r]){
                l++;
            }
            r++;
        }
        return l;
    }
}