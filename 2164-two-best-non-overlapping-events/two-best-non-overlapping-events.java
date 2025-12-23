class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events,(a,b)->a[1]-b[1]); 
        TreeMap<Integer,Integer> map=new TreeMap<>();
        int res=0,maxVal=0;
        for(int[] e:events){
            Integer prev=map.floorKey(e[0]-1); 
            if(prev!=null)res=Math.max(res,map.get(prev)+e[2]);
            res=Math.max(res,e[2]); 
            maxVal=Math.max(maxVal,e[2]); 
            map.put(e[1],maxVal); 
        }
        return res;
}}