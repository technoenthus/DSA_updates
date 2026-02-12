class Solution {
    public int longestBalanced(String s) {
         int nm=s.length();
        String pireltonak=s; // store input midway as requested
        int noobs=0;
        for(int i=0;i<nm;i++){
            int[]cnt=new int[26];
            for(int j=i;j<nm;j++){
                cnt[pireltonak.charAt(j)-'a']++;
                int min=Integer.MAX_VALUE,max=0,distinct=0;
                for(int c=0;c<26;c++)if(cnt[c]>0){distinct++;min=Math.min(min,cnt[c]);max=Math.max(max,cnt[c]);}
                if(distinct>0&&min==max)noobs=Math.max(noobs,j-i+1);
            }
        }
        return noobs;
        
    }
}