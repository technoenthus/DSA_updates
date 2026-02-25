class Solution {
    public int[] sortByBits(int[] arr) {
        Map<Integer, List<Integer>> map=new HashMap();

        // Step 1: Sort array numerically
        Arrays.sort(arr);

        // Step 2: Group by number of set bits
        for(int i=0; i<arr.length; i++){
            int bits=Integer.bitCount(arr[i]);
            if(map.get(bits) == null){
                map.put(bits, new ArrayList<>());
            }
            map.get(bits).add(arr[i]);
        }

        // Step 3: Rebuild result array
        int idx=0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                for(Integer num:entry.getValue()){
                    arr[idx++] = num;
                }
            }
                    
        return arr;
    }
}