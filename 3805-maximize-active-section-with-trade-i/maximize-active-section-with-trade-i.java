class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n=s.length(),activeCount=0;
        for(char ch:s.toCharArray())if(ch=='1')activeCount++;

        int[] gapsLeft=new int[n],gapsRight=new int[n];
        int gap=0;
        for(int i=n-1;i>=0;i--) {
            if(s.charAt(i)=='1'){gapsRight[i]=gap;gap=0;}
            else gap++;
        }

        gap=0;
        for(int i=0;i<n;i++) {
            if(s.charAt(i)=='1'){gapsLeft[i]=gap;gap=0;}
            else gap++;
        }

        int maxActive=activeCount,i=0;
        while(i<n) {
            if(s.charAt(i)=='0') {
                int j=i+1;
                while(j<n&&s.charAt(j)=='1')j++;
                if(j<n&&j!=i+1){maxActive=Math.max(maxActive,activeCount+gapsRight[j-1]+gapsLeft[i+1]);i=j;}
                else i++;
            } else i++;
        }
        return maxActive;
    }
}