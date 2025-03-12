class Solution {
    public String reverseWords(String s) {
        String updated = s.trim().replaceAll("[^a-zA-Z0-9 ]", "").replaceAll("\\s+", " ");
        String arr[]=updated.split(" ");
        StringBuilder ans=new StringBuilder();
        for (int i=arr.length-1;i>=0;i--){
            ans.append(arr[i]);
            if (i!=0){
                ans.append(" ");
            }
        }
        return ans.toString();
    }
}