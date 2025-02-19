class Solution {
     char []a = {'a','b','c'};
    public String getHappyString(int n, int k) {
        List<String> l = happy(n);
        if(l.size()<k){
            return "";
        }
        return l.get(k-1);
    }
    public List<String> happy(int n){
        List<String> r = new ArrayList<>();
        recursion("",n,r);
        return r;
    }
    public void recursion(String cur,int n,List<String> r){
        if(cur.length()==n){
            r.add(cur);
            return;
        }
        for(char c : a){
            if(cur.length()==0 || cur.charAt(cur.length()-1)!=c){
                recursion(cur+c,n,r);
            }
        }
    }
}