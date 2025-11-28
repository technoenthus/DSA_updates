class Solution {
    public int maxKDivisibleComponents(int n,int[][] edges,int[] values,int k) {
        List<List<Integer>> tree=new ArrayList<>();
        for(int i=0;i<n;i++)tree.add(new ArrayList<>());
        for(int[] edge:edges){
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        return (int)dfs(tree,values,k,new boolean[n],0)[1];
    }

    private long[] dfs(List<List<Integer>> tree,int[] values,int k,boolean[] visited,int node) {
        visited[node]=true;
        long currentSum=values[node];
        int components=0;
        for(int neighbor:tree.get(node)) {
            if(!visited[neighbor]) {
                long[] result=dfs(tree,values,k,visited,neighbor);
                currentSum+=result[0];
                components+=result[1];
            }
        }
        if(currentSum%k==0) {
            components++;
            return new long[]{0,components};
        } else {
            return new long[]{currentSum,components};
        }
    }
}