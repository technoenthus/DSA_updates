class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
	int low = -1, high = queries.length+1;
	while(high - low > 1){
		int h = high+low>>1;
		if(solve(nums, queries, h)){
			high = h;
		}else{
			low = h;
		}
	}
	return high > queries.length ? -1 : high;
}

boolean solve(int[] nums, int[][] queries, int h) {
	int n = nums.length;
	long[] count = new long[n + 1];
	for(int i = 0;i < h;i++){
		int[] q = queries[i];
		count[q[0]] += q[2];
		count[q[1] + 1] -= q[2];
	}
	for (int i = 0; i < n; i++) {
		count[i + 1] += count[i];
	}
	for (int i = 0; i < n; i++) {
		if (nums[i] > count[i]) return false;
	}
	return true;
    }
}