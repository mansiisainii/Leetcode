class Solution {
    public List<Integer> generateRow(int row){
        int ans=1;
        ArrayList<Integer>ansRow=new ArrayList<>();
        ansRow.add(1);
        for(int c=1;c<row;c++)
        {
    ans=ans*(row-c);
    ans=ans/c;
    ansRow.add(ans);
    } 
    return ansRow;
   }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            ans.add(generateRow(i));
        }
        return ans;
    }
}