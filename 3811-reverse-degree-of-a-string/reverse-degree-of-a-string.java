class Solution {
    public int reverseDegree(String l) {
        int sum=0;
        for(int i=0;i<l.length();i++) {
            sum+=(26-(l.charAt(i)-'a'))*(i+1);
        }
        return sum;
    }
}