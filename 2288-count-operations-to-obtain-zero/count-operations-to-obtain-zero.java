class Solution {
    public static int helper(int num1,int num2,int c){
        if (num1==0 || num2==0){
            return c;
        }
        int ans=0;
        if (num1<num2){
            num2=num2-num1;
            ans=helper(num1,num2,c+1);
        }else{
            num1=num1-num2;
            ans=helper(num1,num2,c+1);
        }
        return ans;
    }
    public int countOperations(int num1, int num2) {
        return helper(num1,num2,0);
    }
}