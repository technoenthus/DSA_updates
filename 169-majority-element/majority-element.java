class Solution {
    public int majorityElement(int[] arr) {
        int c=0;
        int ele=0;
int n=arr.length;
        for (int i=0;i<n;i++){
            if (c==0){
                c++;
                ele=arr[i];
            }
            else if(arr[i]==ele){
                c++;
            }else{
                c--;
            }
        }
int cc=0;
        for (int i=0;i<n;i++){
            if (arr[i]==ele){
                cc++;
            }
        }
        if (cc>n/2){
            return ele;
        }
        return -1;
    }
}