class Solution {
    public List<Integer> getRow(int rowIndex) {
        long ans=1;
        ArrayList<Integer>anss=new ArrayList<>();
        anss.add(1);
        for(int col=1;col<=rowIndex;col++){
            ans=ans*(rowIndex-col+1);
            ans=ans/col;
            anss.add((int)ans);
        }
        return anss;
    }
}