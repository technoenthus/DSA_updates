class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length,c=0;
        Set<Integer>seenA=new HashSet<>(),seenB=new HashSet<>();
        int[]C=new int[n];
        for(int i=0;i<n;i++){
            if(seenB.contains(A[i]))c++;
            seenA.add(A[i]);
            if(seenA.contains(B[i]))c++;
            seenB.add(B[i]);
            C[i]=c;
        }
        return C;
    }
}