class Solution {
    public int[] twoSum(int[] arr, int target) {
    //     int[] ans={-1,-1};
    //     int i=0;
    //    while(i<arr.length){
    //     int j=i+1;
    //     while(j<arr.length){
    //         if (arr[i]+arr[j]==target){
    //         return new int[]{i,j};

    //     }
    //     j++;
    //     }
    //     //o(n2)
    
    //     i++;
    //    }
    // return ans;


    HashMap<Integer, Integer> map=new HashMap<>();
    for (int i=0;i<arr.length;i++){
        map.put(arr[i],i);
    }
    for (int i=0;i<arr.length;i++){
        int other=target-arr[i];
        if (map.containsKey(other) && map.get(other)!=i){
            return new int[]{i,map.get(other)};
        }
    }
    return new int[]{};

    }
}