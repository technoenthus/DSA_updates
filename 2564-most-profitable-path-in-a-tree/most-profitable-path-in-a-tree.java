class Solution {
    List<List<Integer>> graph;
    int[] amount;
    int[] bobTime;
    int maxIncome;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        this.amount = amount;
        this.maxIncome = Integer.MIN_VALUE;
        
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        bobTime = new int[n];
        Arrays.fill(bobTime, n);
        calculateBobPath(bob, 0, 0, new boolean[n]);
        
        dfs(0, 0, 0, new boolean[n]);
        
        return maxIncome;
    }
    private void dfs(int curr, int time, int income, boolean[] visited) {
        if (time < bobTime[curr]) {
            income += amount[curr];
        } else if (time == bobTime[curr]) {
            income += amount[curr] / 2;
        }
        
        visited[curr] = true;
        
        boolean isLeaf = true;
        for (int next : graph.get(curr)) {
            if (!visited[next]) {
                isLeaf = false;
                dfs(next, time + 1, income, visited);
            }
        }
        
        if (isLeaf) {
            maxIncome = Math.max(maxIncome, income);
        }
        
        visited[curr] = false;
    }
    private boolean calculateBobPath(int curr, int parent, int time, boolean[] visited) {
        if (curr == 0) {
            bobTime[curr] = time;
            return true;
        }
        
        visited[curr] = true;
        for (int next : graph.get(curr)) {
            if (!visited[next] && calculateBobPath(next, curr, time + 1, visited)) {
                bobTime[curr] = time;
                return true;
            }
        }
        visited[curr] = false;
        return false;
    }
}