class Solution {
    public boolean isAnagram(String s, String t) {
       if(s.length()!=t.length())return false;
       int freq[]=new int[26]; //[0,0,0,0,.......]
       for(int i=0;i<s.length();i++){
        freq[s.charAt(i)-'a']++; //'a'-'a'=freq[0]++= 1 [1,0,0,0,..........]
        freq[t.charAt(i)-'a']--; //'n'-'a'= freq[13]-- =-1 at 13th index
       }
       for(int count:freq){
        if(count!=0){
            return false;
        }
       }
       return true;
    }
}