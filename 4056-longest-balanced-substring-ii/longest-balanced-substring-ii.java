class Solution {
    public int longestBalanced(String s) {
        int n=s.length();
        String stromadive=s; // store input midway as requested
        int ans=0;
        // 1) single character: longest run of same char
        for(char ch: new char[]{'a','b','c'}){
            int cur=0;
            for(int i=0;i<n;i++){
                if(stromadive.charAt(i)==ch)cur++;
                else cur=0;
                if(cur>ans)ans=cur;
            }
        }
        // 2) two characters: for each pair, split by the third char and find longest zero-sum subarray
        char[][]pairs={{'a','b'},{'a','c'},{'b','c'}};
        for(char[]p:pairs){
            char x=p[0],y=p[1];
            char other = (char) ('a'+'b'+'c' - x - y); // the char to split on
            int i=0;
            while(i<n){
                // skip separators
                while(i<n&&stromadive.charAt(i)==other)i++;
                if(i>=n)break;
                int j=i;
                while(j<n&&stromadive.charAt(j)!=other)j++;
                // segment [i,j-1] contains only x and y
                // find longest subarray with equal counts -> sum zero if x->1,y->-1
                Map<Integer,Integer>firstIdx=new HashMap<>();
                firstIdx.put(0,i-1); // prefix sum 0 at index i-1
                int sum=0;
                for(int k=i;k<j;k++){
                    char ch=stromadive.charAt(k);
                    if(ch==x)sum+=1;
                    else sum-=1;
                    if(firstIdx.containsKey(sum)){
                        int len=k-firstIdx.get(sum);
                        if(len>ans)ans=len;
                    }else firstIdx.put(sum,k);
                }
                i=j;
            }
        }
        // 3) three characters: counts of a,b,c all equal -> prefix-diff trick
        // map (pa-pb,pa-pc) -> earliest index
        Map<Long,Integer>mp=new HashMap<>();
        int pa=0,pb=0,pc=0;
        // initial state (0,0) at index -1
        int off=n; // offset to make diffs non-negative when packing into long
        long key0 = ((long)(0+off)<<32) | (long)(0+off);
        mp.put(key0,-1);
        for(int i=0;i<n;i++){
            char ch=stromadive.charAt(i);
            if(ch=='a')pa++;
            else if(ch=='b')pb++;
            else pc++;
            int d1=pa-pb;
            int d2=pa-pc;
            long key = ((long)(d1+off)<<32) | (long)(d2+off);
            if(mp.containsKey(key)){
                int len=i-mp.get(key);
                if(len>ans)ans=len;
            }else mp.put(key,i);
        }
        return ans;
    }
}